package org.luo.core.tool.utils;

import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * @Date 13:51 2021/4/27
 * @Description {
 *   ArrayUtils
 * }
 * @Author lsay
 **/
public class FuncUtils {

    public static List<Long> toLongList(String str){
        return Arrays.asList(toLongArray(str));
    }

    public static Long[] toLongArray(String str) {
        return toLongArray(",",str);
    }

    public static Long[] toLongArray(String split, String str) {
        if(StringUtil.isEmpty(str)){
            return new Long[0];
        }else {
            String[] arr = str.split(split);
            Long[] longs = new Long[arr.length];
            for (int i = 0; i < arr.length; i++) {
                Long v = toLong(arr[i],0L);
                longs[i] = v;
            }
            return longs;
        }
    }

    public static Long toLong(@Nullable final Object value, final long defaultValue) {
        return NumberUtil.toLong(String.valueOf(value),defaultValue);
    }

}
