package org.luo.app.article.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.luo.app.article.entity.Article;
import org.luo.mp.base.BaseService;
import org.luo.mp.core.PageHelper;

public interface ArticleService extends BaseService<Article> {


    IPage<Article> selectPage(PageHelper pageHelper);
}
