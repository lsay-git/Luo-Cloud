package org.luo.system.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Date 14:03 2021/4/30
 * @Description {
 *   UserInfoVo
 * }
 * @Author lsay
 **/
@Data
public class UserInfoVo implements Serializable {

    @JsonSerialize(using= ToStringSerializer.class)
    private Long userId;

    private String username;

    private String nickname;

    private String telephone;

    private String profilePicture;

    private String email;

    private int deadStatus;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private List<RoleVo> userRoles;

}
