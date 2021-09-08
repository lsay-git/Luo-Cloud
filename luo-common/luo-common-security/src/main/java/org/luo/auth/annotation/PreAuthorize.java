package org.luo.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date 16:36 2021/4/30
 * @Description {
 *   权限注解
 * }
 * @Author lsay
 **/
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PreAuthorize {


    /**
     * 验证用户是否具备某权限
     */
    public String hasPermission() default "";

    /**
     * 验证用户是否不具备某权限，与 hasPermission逻辑相反
     */
    public String lacksPermission() default "";

    /**
     * 验证用户是否具有以下任意一个权限
     */
    public String[] hasAnyPermission() default {};

    /**
     * 判断用户是否拥有某个角色
     */
    public String hasRole() default "";

    /**
     * 验证用户是否不具备某角色，与 isRole逻辑相反
     */
    public String lacksRole() default "";

    /**
     * 验证用户是否具有以下任意一个角色
     */
    public String[] hasAnyRoles() default {};

}
