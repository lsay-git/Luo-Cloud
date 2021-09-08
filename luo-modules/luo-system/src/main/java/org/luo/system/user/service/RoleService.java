package org.luo.system.user.service;

import org.luo.mp.base.BaseService;
import org.luo.system.user.entity.Role;
import org.luo.system.user.dto.RoleSave;
import org.luo.system.user.vo.RolePermissionVo;
import org.luo.system.user.vo.RoleVo;

import java.util.List;

/**
 * @Date 14:37 2021/5/6
 * @Description {
 *   RoleService
 * }
 * @Author lsay
 **/
public interface RoleService extends BaseService<Role> {
    List<RoleVo> listRole(String code);

    boolean saveRole(RoleSave roleSave);

    RolePermissionVo getRolePermission(Long roleId);

    List<RoleVo> listUserRoles(long toLong, Integer selectType);

}
