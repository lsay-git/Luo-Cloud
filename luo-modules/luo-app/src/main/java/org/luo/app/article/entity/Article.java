package org.luo.app.article.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.luo.mp.base.BaseEntity;

import java.util.Date;

/**
    * 文章内容表
    */
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "luo_article")
public class Article extends BaseEntity {
    /**
     * 文章标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 作者ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 文章内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 发布时间
     */
    @TableField(value = "release_time")
    private Date releaseTime;

    /**
     * 是否置顶 0置顶 1默认
     */
    @TableField(value = "is_top")
    private Byte isTop;

    /**
     * 分类ID
     */
    @TableField(value = "type_id")
    private Long typeId;

    /**
     * 标签ID 存在多个标签
     */
    @TableField(value = "tag_id")
    private String tagId;
}