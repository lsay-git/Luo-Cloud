package org.luo.file;

import org.luo.core.annotation.EnableLuoComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;


/**
 * @Date 15:17 2021/6/3
 * @Description {
 *   LuoFileApplication
 * }
 * @Author lsay
 **/
@EnableLuoComponent
@SpringCloudApplication
public class LuoFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuoFileApplication.class, args);
    }

}
