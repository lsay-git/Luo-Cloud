package org.luo.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.luo.core.domain.R;
import org.luo.system.user.entity.Role;
import org.luo.system.user.vo.RolePermissionVo;
import org.luo.system.user.vo.RoleVo;

import java.util.List;

/**
 * @Date 15:43 2021/5/6
 * @Description {
 *   RoleMapper
 * }
 * @Author lsay
 **/
public interface RoleMapper extends BaseMapper<Role> {
    List<RoleVo> listRole(@Param("code") String code);

    RolePermissionVo getRolePermission(@Param("roleId") Long roleId);

    List<RoleVo> listUserRoles(@Param("userId") long userId,@Param("selectType") Integer selectType);

}
