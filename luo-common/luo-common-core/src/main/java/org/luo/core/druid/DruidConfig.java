package org.luo.core.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        System.err.println("INIT DruidConfig --------------------------------------");
        System.getProperties().put("druid.mysql.usePingMethod","false");
        return new DruidDataSource();
    }

}
