package org.luo.core.tool.utils;

import org.springframework.lang.Nullable;

import java.lang.reflect.Array;
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

    public FuncUtils() {
    }

    public static List<Long> toLongList(String str){
        return Arrays.asList(toLongArray(str));
    }

    public static Long[] toLongArray(String str) {
        return toLongArray(",",str);
    }

    public static Long[] toLongArray(String split, String str) {
        if(StringUtils.isBlank(str)){
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
        return NumberUtils.toLong(String.valueOf(value),defaultValue);
    }

    public static boolean isEmpty(Object[] array) {
        return getLength(array) == 0;
    }

    public static int getLength(Object[] array) {
        return array == null ? 0 : Array.getLength(array);
    }

    /**
     * 转换为字符串<br>
     * 如果给定的值为null，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     *
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static String toStr(Object value, String defaultValue) {
        if (null == value)
        {
            return defaultValue;
        }
        if (value instanceof String)
        {
            return (String) value;
        }
        return value.toString();
    }

    /**
     * 转换为int<br>
     * 如果给定的值为<code>null</code>，或者转换失败，返回默认值<code>null</code><br>
     * 转换失败不会报错
     *
     * @param value 被转换的值
     * @return 结果
     */
    public static Integer toInt(Object value)
    {
        return toInt(value, null);
    }

    /**
     * 转换为int<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     *
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Integer toInt(Object value, Integer defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Integer)
        {
            return (Integer) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).intValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isBlank(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Integer.parseInt(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

}
