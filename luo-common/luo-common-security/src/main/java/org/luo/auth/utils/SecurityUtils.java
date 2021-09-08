package org.luo.auth.utils;

import org.luo.core.constant.CacheConstants;
import org.luo.core.tool.utils.Base64Utils;
import org.luo.core.tool.utils.Md5Utils;
import org.luo.core.tool.utils.StringUtils;
import org.luo.core.tool.utils.http.ServletUtils;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 14:24 2021/4/30
 * @Description {
 *
 * }
 * @Author lsay
 **/
public class SecurityUtils {

    /**
     * 生成 自定义加密密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        return Md5Utils.getMD5(Base64Utils.encoder(password));
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        return encryptPassword(rawPassword).equals(encodedPassword);
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
//    public static String encryptPassword(String password)
//    {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.encode(password);
//    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
//    public static boolean matchesPassword(String rawPassword, String encodedPassword)
//    {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(rawPassword, encodedPassword);
//    }

    /**
     * 获取 token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String token = ServletUtils.getRequest().getHeader(CacheConstants.HEADER);
        if (StringUtils.isNotEmpty(token) && token.startsWith(CacheConstants.TOKEN_PREFIX))
        {
            token = token.replace(CacheConstants.TOKEN_PREFIX, "");
        }
        return token;
    }

    public static void main(String[] args) {
        System.err.println(encryptPassword("admin123456"));
        System.err.println(matchesPassword("admin123456","05DEA60821086A2B107B9346A6E8A86E"));
    }

}
