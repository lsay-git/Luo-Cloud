package org.luo.auth.config.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Date 11:29 2021/5/10
 * @Description {
 *   拦截器注册
 * }
 * @Author lsay
 **/
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor());
        super.addInterceptors(registry);
    }
}
