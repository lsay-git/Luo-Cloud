package org.luo.auth.config.mvc;

import org.luo.auth.model.LoginUser;
import org.luo.auth.service.TokenService;
import org.luo.auth.utils.SecurityUtils;
import org.luo.auth.constant.FilterConstants;
import org.luo.core.exception.ServiceException;
import org.luo.core.tool.utils.LogUtils;
import org.luo.core.tool.utils.ObjectUtils;
import org.luo.core.tool.utils.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date 11:23 2021/5/10
 * @Description {
 *   自定义拦截器
 * }
 * @Author lsay
 **/
public class MyInterceptor implements HandlerInterceptor {

    private final static Logger logger = LogUtils.logger(MyInterceptor.class);

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String url = request.getRequestURI();
        if(StringUtils.inStringIgnoreCase(url, FilterConstants.whites)){
            return true;
        }else {
            String token = SecurityUtils.getToken(request);
            if(StringUtils.isBlank(token)){
                throw new ServiceException("用户未登录");
            }
            LoginUser loginUser = tokenService.getLoginUser();
            if(ObjectUtils.isEmpty(loginUser)){
                throw new ServiceException("用户验证失败");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
