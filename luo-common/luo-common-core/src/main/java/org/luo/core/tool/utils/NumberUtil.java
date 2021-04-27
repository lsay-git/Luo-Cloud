package org.luo.core.tool.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.NumberUtils;

/**
 * @Date 14:07 2021/4/27
 * @Description {
 *   NumberUtil
 * }
 * @Author lsay
 **/
public class NumberUtil extends NumberUtils {

    public NumberUtil() {
    }

    public static long toLong(final String str) {
        return toLong(str, 0L);
    }

    public static Long toLong(@Nullable final String s,final long defaultValue) {
        if(s == null){
            return defaultValue;
        }else {
            try {
                return Long.valueOf(s);
            }catch (NumberFormatException ne){
                return defaultValue;
            }
        }
    }

}
