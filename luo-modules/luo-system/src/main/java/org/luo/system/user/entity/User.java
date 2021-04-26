package org.luo.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.luo.core.mp.base.BaseEntity;

/**
 * @Date 14:15 2021/4/26
 * @Description {
 *   user
 * }
 * @Author lsay
 **/
@Data
@TableName(value = "luo_user")
public class User extends BaseEntity {

    @TableField(value = "username")
    private String username;

}
