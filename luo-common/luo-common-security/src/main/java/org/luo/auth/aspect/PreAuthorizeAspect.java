package org.luo.auth.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.luo.auth.annotation.PreAuthorize;
import org.luo.auth.model.LoginUser;
import org.luo.auth.model.RoleModel;
import org.luo.auth.service.TokenService;
import org.luo.core.exception.ServiceException;
import org.luo.core.tool.utils.CollectionUtils;
import org.luo.core.tool.utils.ObjectUtils;
import org.luo.core.tool.utils.StringUtils;
import org.luo.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

/**
 * 自定义权限实现
 * 
 * @author ruoyi
 */
@Aspect
@Component
public class PreAuthorizeAspect {

    @Autowired
    private RedisService redisService;

    @Autowired
    private TokenService tokenService;

    /** 所有权限标识 */
    private static final String ALL_PERMISSION = "*:*";

    /** 管理员角色权限标识 */
    private static final String SUPER_ADMIN = "Administrators";

    /** 数组为0时 */
    private static final Integer ARRAY_EMPTY = 0;

    @Around("@annotation(org.luo.auth.annotation.PreAuthorize)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        PreAuthorize annotation = method.getAnnotation(PreAuthorize.class);
        if (annotation == null) {
            return point.proceed();
        }
        if(hasAdministrators()){
            return point.proceed();
        }
        if (!StringUtils.isBlank(annotation.hasPermission())) {
            if(hasPermission(annotation.hasPermission())){
                return point.proceed();
            }else {
                throw new ServiceException("操作权限不足");
            }
        }
        else if (!StringUtils.isBlank(annotation.lacksPermission())) {
            if (lacksPermission(annotation.lacksPermission()))
            {
                return point.proceed();
            }
            throw new ServiceException("操作权限不足");
        }
        else if (ARRAY_EMPTY < annotation.hasAnyPermission().length) {
            if (hasAnyPermission(annotation.hasAnyPermission()))
            {
                return point.proceed();
            }
            throw new ServiceException("操作权限不足");
        }
        else if (!StringUtils.isBlank(annotation.hasRole())) {
            if (hasRole(annotation.hasRole()))
            {
                return point.proceed();
            }
            throw new ServiceException("角色权限不足");
        }
        else if (!StringUtils.isBlank(annotation.lacksRole())) {
            if (lacksRole(annotation.lacksRole()))
            {
                return point.proceed();
            }
            throw new ServiceException("角色权限不足");
        }
        else if (ARRAY_EMPTY < annotation.hasAnyRoles().length) {
            if (hasAnyRoles(annotation.hasAnyRoles()))
            {
                return point.proceed();
            }
            throw new ServiceException("角色权限不足");
        }
        return point.proceed();
    }

    /**
     * 判断用户是否为超级管理员
     * @return
     */
    private boolean hasAdministrators(){
        LoginUser userInfo = tokenService.getLoginUser();
        for (RoleModel roleModel : userInfo.getRoles()) {
            if(!ObjectUtils.isEmpty(roleModel)){
                String roleKey = roleModel.getCode();
                if (SUPER_ADMIN.equals(roleKey)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断用户是否拥有某个角色
     *
     * @param role 角色字符串
     * @return 用户是否具备某角色
     */
    public boolean hasRole(String role) {
        LoginUser userInfo = tokenService.getLoginUser();
        if (ObjectUtils.isEmpty(userInfo) || CollectionUtils.isEmpty(userInfo.getRoles())) {
            return false;
        }
        for (RoleModel roleModel : userInfo.getRoles()) {
            if(!ObjectUtils.isEmpty(roleModel)){
                String roleKey = roleModel.getCode();
                if (roleKey.equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 验证用户是否不具备某角色，与 isRole逻辑相反。
     *
     * @param role 角色名称
     * @return 用户是否不具备某角色
     */
    public boolean lacksRole(String role)
    {
        return hasRole(role) != true;
    }

    /**
     * 验证用户是否具有以下任意一个角色
     *
     * @param roles 角色列表
     * @return 用户是否具有以下任意一个角色
     */
    public boolean hasAnyRoles(String[] roles)
    {
        LoginUser userInfo = tokenService.getLoginUser();
        if (StringUtils.isEmpty(userInfo) || CollectionUtils.isEmpty(userInfo.getRoles()))
        {
            return false;
        }
        for (String role : roles)
        {
            if (hasRole(role))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证用户是否具备某权限
     * @param hasPermission 权限
     * @return 用户是否具备某权限
     */
    private boolean hasPermission(String hasPermission) {
        LoginUser userInfo = tokenService.getLoginUser();
        if (ObjectUtils.isEmpty(userInfo) || CollectionUtils.isEmpty(userInfo.getPermissions()))
        {
            return false;
        }
        return hasPermissions(userInfo.getPermissions(), hasPermission);
    }

    /**
     * 验证用户是否不具备某权限，与 hasPermi逻辑相反
     *
     * @param permission 权限字符串
     * @return 用户是否不具备某权限
     */
    public boolean lacksPermission(String permission)
    {
        return hasPermission(permission) != true;
    }

    /**
     * 验证用户是否具有以下任意一个权限
     *
     * @param permissions 权限列表
     * @return 用户是否具有以下任意一个权限
     */
    public boolean hasAnyPermission(String[] permissions)
    {
        LoginUser userInfo = tokenService.getLoginUser();
        if (StringUtils.isEmpty(userInfo) || CollectionUtils.isEmpty(userInfo.getPermissions()))
        {
            return false;
        }
        Collection<String> authorities = userInfo.getPermissions();
        for (String permission : permissions)
        {
            if (permission != null && hasPermissions(authorities, permission))
            {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断是否包含权限
     * 
     * @param authorities 权限列表
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    private boolean hasPermissions(Collection<String> authorities, String permission)
    {
        return authorities.stream().filter(StringUtils::hasText)
                .anyMatch(x -> ALL_PERMISSION.contains(x) || PatternMatchUtils.simpleMatch(permission, x));
    }
}
