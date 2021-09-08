package org.luo.app.article.service.impl;

import org.luo.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.luo.app.article.mapper.ArticleStatisticsMapper;
import org.luo.app.article.entity.ArticleStatistics;
import org.luo.app.article.service.ArticleStatisticsService;
@Service
public class ArticleStatisticsServiceImpl extends BaseServiceImpl<ArticleStatisticsMapper, ArticleStatistics> implements ArticleStatisticsService{

}
