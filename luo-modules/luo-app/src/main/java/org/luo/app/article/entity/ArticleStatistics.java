package org.luo.app.article.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.luo.mp.base.BaseEntity;

/**
    * 文章数据统计表
    */
@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "luo_article_statistics")
public class ArticleStatistics extends BaseEntity {
    /**
     * 文章id
     */
    @TableField(value = "article_id")
    private Long articleId;

    /**
     * 浏览数
     */
    @TableField(value = "browse_count")
    private Long browseCount;

    /**
     * 收藏数
     */
    @TableField(value = "collect_count")
    private Long collectCount;

    /**
     * 分享数
     */
    @TableField(value = "share_count")
    private Long shareCount;

    /**
     * 评论数
     */
    @TableField(value = "comment_count")
    private Long commentCount;
}