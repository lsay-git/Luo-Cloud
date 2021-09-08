package org.luo.app.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.luo.mp.base.BaseEntity;

/**
    * 用户信息表
    */
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "luo_user_info")
public class UserInfo extends BaseEntity {
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 用户昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 手机号码
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 头像
     */
    @TableField(value = "profile_picture")
    private String profilePicture;

    /**
     * 性别：0=男,1=女,2=未知
     */
    @TableField(value = "sex")
    private Byte sex;

    /**
     * 是否停用：0-正常 1-停用
     */
    @TableField(value = "dead_status")
    private Byte deadStatus;
}