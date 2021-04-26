package org.luo.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Date 9:52 2021/4/24
 * @Description {
 *   Luo-system
 * }
 * @Author lsay
 **/
@MapperScan("org.luo.system.*.mapper")
@ComponentScan(basePackages = {"org.luo.*"})
@SpringCloudApplication
public class LuoSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuoSystemApplication.class, args);
    }

}
