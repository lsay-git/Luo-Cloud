package org.luo.core.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.luo.core.tool.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Date 14:23 2021/4/27
 * @Description {
 *   DruidConfig
 * }
 * @Author lsay
 **/
@Configuration
public class DruidConfig {

    private static final Logger logger = LogUtils.logger(DruidConfig.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        logger.info("INIT DruidConfig");
        System.getProperties().put("druid.mysql.usePingMethod","false");
        return new DruidDataSource();
    }

}
