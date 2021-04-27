package org.luo.core.tool.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

/**
 * @Date 13:42 2021/4/27
 * @Description {
 *   ObjectUtils
 * }
 * @Author lsay
 **/
public class ObjectUtil extends ObjectUtils {

    public ObjectUtil() {
    }

    public static boolean isNotEmpty(@Nullable Object obj){
        return  !isEmpty(obj);
    }

}
