package org.luo.system.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Date 14:12 2021/4/30
 * @Description {
 *   UserRoleVo
 * }
 * @Author lsay
 **/
@Data
public class PermissionVo implements Serializable {

    private String code;
    private String name;
    private List<PermissionInfoVo> permissions;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

}
