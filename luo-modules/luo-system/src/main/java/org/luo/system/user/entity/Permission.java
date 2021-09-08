package org.luo.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.luo.mp.base.BaseEntity;

/**
 * @Date 9:47 2021/5/21
 * @Description {
 *   Permission
 * }
 * @Author lsay
 **/
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "luo_permission")
public class Permission extends BaseEntity {
    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 编码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 权限
     */
    @TableField(value = "permission")
    private String permission;

    /**
     * 权限描述
     */
    @TableField(value = "permission_info")
    private String permissionInfo;

    /**
     * 权限级别
     */
    @TableField(value = "permission_level")
    private Integer permissionLevel;
}