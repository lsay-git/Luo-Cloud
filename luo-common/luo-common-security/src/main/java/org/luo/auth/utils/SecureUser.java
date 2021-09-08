package org.luo.auth.utils;

import org.luo.auth.service.TokenService;
import org.luo.core.tool.utils.SpringUtil;

/**
 * @Date 10:49 2021/5/15
 * @Description {
 *   SecureUser 获取用户基本信息
 * }
 * @Author lsay
 **/
public class SecureUser {

    private static final TokenService tokenService;

    static {
        tokenService = SpringUtil.getBean(TokenService.class);
    }

    public static Long getUserId(){
        return tokenService.getLoginUser().getUserId();
    }

    public static String getUsername(){
        return tokenService.getLoginUser().getUsername();
    }

}
