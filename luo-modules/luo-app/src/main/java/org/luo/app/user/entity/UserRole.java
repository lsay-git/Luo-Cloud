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
    * 用户角色表
    */
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "luo_user_role")
public class UserRole extends BaseEntity {
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    private Long roleId;
}