package org.luo.system;

import org.luo.core.annotation.EnableLuoComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Date 9:52 2021/4/24
 * @Description {
 *   Luo-system 启动类
 * }
 * @Author lsay
 **/
@EnableLuoComponent
@SpringCloudApplication
public class LuoSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuoSystemApplication.class, args);
    }

}
