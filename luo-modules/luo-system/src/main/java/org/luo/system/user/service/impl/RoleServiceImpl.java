package org.luo.system.user.service.impl;

import org.luo.core.tool.utils.NumberUtils;
import org.luo.core.tool.utils.ObjectUtils;
import org.luo.mp.base.BaseServiceImpl;
import org.luo.system.user.entity.Role;
import org.luo.system.user.entity.RolePermission;
import org.luo.system.user.mapper.RoleMapper;
import org.luo.system.user.dto.RoleSave;
import org.luo.system.user.service.RolePermissionService;
import org.luo.system.user.service.RoleService;
import org.luo.system.user.vo.RolePermissionVo;
import org.luo.system.user.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 14:38 2021/5/6
 * @Description {
 *   RoleServiceImpl
 * }
 * @Author lsay
 **/
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<RoleVo> listRole(String code) {
        return roleMapper.listRole(code);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRole(RoleSave roleSave) {

        boolean result;

        Role role = new Role();
        role.setCode(roleSave.getCode());
        role.setName(roleSave.getName());
        result = this.save(role);
        if(!ObjectUtils.isEmpty(roleSave.getPermissions())){
            List<RolePermission> rolePermissions = roleSave.getPermissions().stream().map(e -> {
               RolePermission rolePermission = new RolePermission();
               rolePermission.setRoleId(role.getId());
               rolePermission.setPermissionId(NumberUtils.toLong(e));
               return rolePermission;
            }).collect(Collectors.toList());
            result = rolePermissionService.saveBatch(rolePermissions);
        }

        return result;
    }

    @Override
    public RolePermissionVo getRolePermission(Long roleId) {
        return roleMapper.getRolePermission(roleId);
    }

    @Override
    public List<RoleVo> listUserRoles(long userId, Integer selectType) {
        return roleMapper.listUserRoles(userId,selectType);
    }
}
