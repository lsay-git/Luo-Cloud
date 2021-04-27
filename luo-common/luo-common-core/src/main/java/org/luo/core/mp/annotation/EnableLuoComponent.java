package org.luo.core.mp.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date 9:06 2021/4/27
 * @Description {
 *  Luo 自定义扫描注解
 * }
 * @Author lsay
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@MapperScan("org.luo.system.*.mapper")
@ComponentScan(basePackages = {"org.luo.*"})
public @interface EnableLuoComponent {
}
