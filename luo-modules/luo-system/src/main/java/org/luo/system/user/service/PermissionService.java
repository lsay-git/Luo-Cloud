package org.luo.system.user.service;

import org.luo.mp.base.BaseService;
import org.luo.system.user.entity.Permission;
import org.luo.system.user.vo.PermissionInfoCascadeVo;
import org.luo.system.user.vo.PermissionVo;

import java.util.List;

public interface PermissionService extends BaseService<Permission> {


    List<PermissionVo> listPermission(String code);

    List<PermissionInfoCascadeVo> permissionCascade(String type, Long roleId);
}


