package org.luo.system.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @Date 14:38 2021/5/22
 * @Description {
 *
 * }
 * @Author lsay
 **/
@Data
public class OldPermissionVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long permissionId;
    private String permission;
    private String permissionInfo;

}
