package org.luo.core.tool.utils;

import org.springframework.lang.Nullable;

/**
 * @Date 13:42 2021/4/27
 * @Description {
 *   ObjectUtils
 * }
 * @Author lsay
 **/
public class ObjectUtils extends org.springframework.util.ObjectUtils {

    public ObjectUtils() {
    }

    public static boolean isNotEmpty(@Nullable Object obj){
        return  !isEmpty(obj);
    }

}
