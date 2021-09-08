package org.luo.app;

import org.luo.core.annotation.EnableLuoComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Date 11:20 2021/6/24
 * @Description {
 *    LuoAppApplication
 * }
 * @Author lsay
 **/
@EnableLuoComponent
@SpringBootApplication
public class LuoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuoAppApplication.class, args);
    }

}
