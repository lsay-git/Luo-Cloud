package org.luo.file.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.luo.mp.base.BaseEntity;

/**
 * @Date 16:04 2021/6/3
 * @Description {
 *   Files
 * }
 * @Author lsay
 **/
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "luo_files")
public class Files extends BaseEntity {
    /**
     * 文件名
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 文件后缀
     */
    @TableField(value = "suffix")
    private String suffix;

    /**
     * 文件大小单位：kb
     */
    @TableField(value = "`size`")
    private Double size;

    /**
     * 文件储存路径
     */
    @TableField(value = "`path`")
    private String path;

    /**
     * 文件展示url
     */
    @TableField(value = "static_url")
    private String staticUrl;

    /**
     * 文件下载url
     */
    @TableField(value = "down_url")
    private String downUrl;

    /**
     * 文件类型：1-图片 2-视频 3-其他文件
     */
    @TableField(value = "`type`")
    private Integer type;
}