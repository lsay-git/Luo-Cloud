package org.luo.system.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @Date 14:12 2021/4/30
 * @Description {
 *   UserRoleVo
 * }
 * @Author lsay
 **/
@Data
public class PermissionInfoCascadeChildrenVo implements Serializable{
        /**
         * 权限 id
         */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long value;
        /**
         * 权限 permission_info
         */
        private String label;

}
