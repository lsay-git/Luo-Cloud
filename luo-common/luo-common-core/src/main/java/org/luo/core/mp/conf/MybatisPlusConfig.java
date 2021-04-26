package org.luo.core.mp.conf;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
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

    @Bean
    public GlobalConfig globalConfig() {
        System.err.println("MybatisPlusConfig------------------");
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
        return globalConfig;
    }



}
