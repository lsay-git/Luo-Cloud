package org.luo.core.constant;

/**
 * @Date 15:43 2021/4/27
 * @Description {
 *   Constants 通用常量信息
 * }
 * @Author lsay
 **/
public class Constants {

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * ISO8859-1
     */
    public static final String ISO8859_1 = "ISO8859-1";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功
     */
    public static final Integer SUCCESS_CODE = 200;

    /**
     * 成功描述
     */
    public static final String SUCCESS_MSG = "请求成功";

    /**
     * 异常
     */
    public static final Integer ERROR_CODE = 400;

    /**
     * 异常描述
     */
    public static final String ERROR_MSG = "请求处理异常";

    /**
     * 失败
     */
    public static final Integer FAIL_CODE = 500;

    /**
     * 失败描述
     */
    public static final String FAIL_MSG = "请求处理失败";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌有效期（分钟）
     */
    public final static long TOKEN_EXPIRE = 720;



}
