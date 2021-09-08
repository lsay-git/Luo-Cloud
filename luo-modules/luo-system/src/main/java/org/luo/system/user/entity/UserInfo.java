package org.luo.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.luo.mp.base.BaseEntity;

/**
 * @Date 13:51 2021/4/30
 * @Description {
 *   用户信息表
 * }
 * @Author lsay
 **/
@Data
@TableName(value = "luo_user_info")
public class UserInfo extends BaseEntity {

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "telephone")
    private String telephone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "profile_picture")
    private String profilePicture;

    @TableField(value = "dead_status")
    private int deadStatus;

}
