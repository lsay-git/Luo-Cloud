package org.luo.core.tool.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Date 16:03 2021/4/28
 * @Description {
 *   日志
 * }
 * @Author lsay
 **/
public class LogUtils {

    public LogUtils() {
    }

    public static final Logger logger(String name){
        return LoggerFactory.getLogger(name);
    }

    public static final Logger logger(Class<?> clazz){
        return LoggerFactory.getLogger(clazz);
    }

}
