package org.luo.system.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date 14:12 2021/4/30
 * @Description {
 *   UserRoleVo
 * }
 * @Author lsay
 **/
@Data
public class RoleVo implements Serializable {

    @JsonSerialize(using= ToStringSerializer.class)
    private Long roleId;
    private String code;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

}
