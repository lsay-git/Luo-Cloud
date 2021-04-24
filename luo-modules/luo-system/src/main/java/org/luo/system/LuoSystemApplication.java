package org.luo.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Date 9:52 2021/4/24
 * @Description {
 *   Luo-system
 * }
 * @Author lsay
 **/
@SpringCloudApplication
public class LuoSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuoSystemApplication.class, args);
    }

}
