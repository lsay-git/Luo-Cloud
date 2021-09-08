package org.luo.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.luo.core.exception.ServiceException;
import org.luo.core.tool.utils.ObjectUtils;
import org.luo.mp.base.BaseServiceImpl;
import org.luo.system.user.vo.PermissionInfoCascadeVo;
import org.luo.system.user.vo.PermissionVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.luo.system.user.entity.Permission;
import org.luo.system.user.mapper.PermissionMapper;
import org.luo.system.user.service.PermissionService;

import java.util.List;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<PermissionVo> listPermission(String code) {
        return permissionMapper.listPermission(code);
    }

    @Override
    public List<PermissionInfoCascadeVo> permissionCascade(String type, Long roleId) {
        return permissionMapper.permissionCascade(type,roleId);
    }

    @Override
    public boolean save(Permission entity) {
        List<Permission> permissionList = permissionMapper.selectList(new LambdaQueryWrapper<Permission>()
                .eq(Permission::getIsDeleted,0).eq(Permission::getCode,entity.getCode()));
        if(ObjectUtils.isNotEmpty(permissionList)){
            throw new ServiceException("页面 Code 已经存在");
        }
        int rows = permissionMapper.savePermissins(entity);
        return rows == 4;
    }
}


