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
    * 角色表
    */
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "luo_role")
public class Role extends BaseEntity {
    /**
     * 父级id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 角色code
     */
    @TableField(value = "code")
    private String code;

    /**
     * 角色名称
     */
    @TableField(value = "`name`")
    private String name;
}