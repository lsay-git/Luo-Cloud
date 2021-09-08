package org.luo.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.luo.system.user.entity.Permission;
import org.luo.system.user.vo.PermissionInfoCascadeVo;
import org.luo.system.user.vo.PermissionVo;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    List<PermissionVo> listPermission(@Param("code") String code);

    int savePermissins(Permission entity);

    List<PermissionInfoCascadeVo> permissionCascade(@Param("type") String type,@Param("roleId") Long roleId);
}