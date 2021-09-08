package org.luo.app.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.luo.mp.base.BaseServiceImpl;
import org.luo.mp.core.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.luo.app.article.entity.Article;
import org.luo.app.article.mapper.ArticleMapper;
import org.luo.app.article.service.ArticleService;
@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleMapper, Article> implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public IPage<Article> selectPage(PageHelper pageHelper) {
        Page<Article> page = new Page<>(pageHelper.getCurrent(), pageHelper.getSize());
        IPage<Article> articles = articleMapper.selectPage(page,new QueryWrapper<>());
        return articles;
    }
}
