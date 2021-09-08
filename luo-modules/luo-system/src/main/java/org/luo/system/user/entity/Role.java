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
@TableName(value = "luo_role")
public class Role extends BaseEntity {

    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "code")
    private String code;

    @TableField(value = "name")
    private String name;

}
