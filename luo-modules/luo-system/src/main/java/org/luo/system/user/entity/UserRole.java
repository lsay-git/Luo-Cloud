package org.luo.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.luo.mp.base.BaseEntity;

/**
 * @Date 14:09 2021/4/30
 * @Description {
 *   角色
 * }
 * @Author lsay
 **/
@Data
@TableName(value = "luo_user_role")
public class UserRole extends BaseEntity {

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "role_id")
    private Long roleId;

}
