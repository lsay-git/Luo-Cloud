package org.luo.core.tool.utils;

import java.util.Collection;

/**
 * @Date 13:50 2021/4/27
 * @Description {
 *   StringUtils
 * }
 * @Author lsay
 **/
public class StringUtils extends org.springframework.util.StringUtils {

    /** 空字符串 */
    private static final String EMPTY_STR = "";

    public StringUtils() {
    }

    /**
     * 判断多个字符串是否为空
     * @param cs
     * @return
     */
    public static boolean isAnyBlank(CharSequence... cs) {
        if (!FuncUtils.isEmpty(cs)) {
            CharSequence[] var1 = cs;
            int var2 = cs.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                CharSequence css = var1[var3];
                if (isBlank(css)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 判断字符串是否为空
     * @param css
     * @return
     */
    public static boolean isBlank(CharSequence css) {
        int strLen = length(css);
        if (strLen != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(css.charAt(i))) {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * 获取字符串长度
     * @param css
     * @return
     */
    public static int length(CharSequence css) {
        return css == null ? 0 : css.length();
    }

    /**
     * * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str) {
        return isBlank(str) || EMPTY_STR.equals(str.trim());
    }

    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param collection 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, Collection collection) {
        return collection.contains(str);
    }

    /**
     * 去空格
     */
    public static String trim(String str)
    {
        return (str == null ? "" : str.trim());
    }

}
