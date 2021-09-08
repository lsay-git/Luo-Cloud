package org.luo.system.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Date 14:12 2021/4/30
 * @Description {
 *   UserRoleVo
 * }
 * @Author lsay
 **/
@Data
public class RolePermissionVo implements Serializable {

    /**
     * 角色 id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    /**
     * 角色 code
     */
    private String code;
    /**
     * 角色 name
     */
    private String name;
    /**
     * 权限 permissions
     */
    private List<RoleOldPermissionVo> oldPermissions;

}
