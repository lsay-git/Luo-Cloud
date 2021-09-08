package org.luo.auth.service;

import org.luo.auth.model.LoginUser;
import org.luo.auth.utils.SecurityUtils;
import org.luo.core.constant.CacheConstants;
import org.luo.core.constant.Constants;
import org.luo.core.exception.ServiceException;
import org.luo.core.tool.utils.ObjectUtils;
import org.luo.core.tool.utils.StringUtils;
import org.luo.core.tool.utils.UUIDUtils;
import org.luo.core.tool.utils.http.IpUtil;
import org.luo.core.tool.utils.http.ServletUtils;
import org.luo.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Date 15:16 2021/4/29
 * @Description {
 *   token 管理
 * }
 * @Author lsay
 **/
@Component
public class TokenService {

    private final static long EXPIRE_TIME = Constants.TOKEN_EXPIRE * 60;

    private final static String ACCESS_TOKEN = CacheConstants.LOGIN_TOKEN_KEY;

    protected static final long MILLIS_SECOND = 1000;

    @Autowired
    private RedisService redisService;

    /**
     * 获取登录用户信息
     * @return
     */
    public LoginUser getLoginUser() {
        return getLoginUser(ServletUtils.getRequest());
    }

    /**
     * 获取登录用户信息
     * @return
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token))
        {
            String userKey = getTokenKey(token);
            LoginUser user = redisService.getCacheObject(userKey);
            return user;
        }else {
            throw new ServiceException("用户未登录");
        }
    }

    /**
     * 获取 token key
     * @param token
     * @return
     */
    private String getTokenKey(String token)
    {
        return ACCESS_TOKEN + token;
    }

    /**
     * 创建 token
     * @param loginUser
     * @return
     */
    public Map<String, Object> createToken(LoginUser loginUser) {
        String token = UUIDUtils.fastUUID();
        loginUser.setToken(token);
        loginUser.setIpaddr(IpUtil.getIpAddr(ServletUtils.getRequest()));
        refreshToken(loginUser);
        redisService.setCacheObject(ACCESS_TOKEN + token,loginUser,EXPIRE_TIME, TimeUnit.SECONDS);
        Map<String,Object> map = new HashMap<>(2);
        map.put("access_token",token);
        map.put("expires_in",EXPIRE_TIME);
        return map;
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser)
    {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + EXPIRE_TIME * MILLIS_SECOND);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisService.setCacheObject(userKey, loginUser, EXPIRE_TIME, TimeUnit.SECONDS);
    }

    /**
     * 设置用户身份信息
     */
    public void setLoginUser(LoginUser loginUser)
    {
        if (ObjectUtils.isNotEmpty(loginUser) && StringUtils.isNotEmpty(loginUser.getToken()))
        {
            refreshToken(loginUser);
        }
    }

    public void delLoginUser(String token)
    {
        if (StringUtils.isNotEmpty(token))
        {
            String userKey = getTokenKey(token);
            redisService.deleteObject(userKey);
        }
    }
}


























