package org.luo.core.mp.conf;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 16:13 2021/4/26
 * @Description {
 *   mybatis-plus config
 * }
 * @Author lsay
 **/
@Configuration
public class MybatisPlusConfig {

    private static final Logger logger = LoggerFactory.getLogger(MybatisPlusConfig.class);

    @Bean
    public GlobalConfig globalConfig() {
        logger.info("INIT MybatisPlusConfig");
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
        return globalConfig;
    }



}
