package org.luo.app.article.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.luo.app.article.entity.Article;
import org.luo.app.article.entity.ArticleStatistics;
import org.luo.app.article.service.ArticleService;
import org.luo.app.article.service.ArticleStatisticsService;
import org.luo.auth.annotation.PreAuthorize;
import org.luo.core.domain.R;
import org.luo.core.tool.utils.FuncUtils;
import org.luo.mp.core.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Date 14:26 2021/7/5
 * @Description {
 *    ArticleController
 * }
 * @Author lsay
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleStatisticsService articleStatisticsService;

    @GetMapping
    public R<?> list(PageHelper pageHelper){
        return R.ok(articleService.selectPage(pageHelper));
    }

    @PreAuthorize(hasRole = "member")
    @PostMapping
    public R<Boolean> add(@RequestBody Article article){
        articleService.save(article);
        ArticleStatistics articleStatistics = new ArticleStatistics();
        articleStatistics.setArticleId(article.getId());
        articleStatisticsService.save(articleStatistics);
        return R.ok(Boolean.TRUE);
    }

    @PreAuthorize(hasRole = "member")
    @DeleteMapping
    public R<Boolean> remove(@RequestBody HashMap<String,String> requestMap){
        return R.ok(articleService.removeByIds(FuncUtils.toLongList(requestMap.get("ids"))));
    }

}
