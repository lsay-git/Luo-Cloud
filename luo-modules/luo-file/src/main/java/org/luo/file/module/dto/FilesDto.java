package org.luo.file.module.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @Date 16:04 2021/6/3
 * @Description {
 *   Files
 * }
 * @Author lsay
 **/
@Data
public class FilesDto implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableField(value = "id")
    private Long id;

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
    private Long size;

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