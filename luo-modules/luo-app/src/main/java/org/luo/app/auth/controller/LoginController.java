package org.luo.app.auth.controller;

import org.luo.app.auth.entity.Login;
import org.luo.app.auth.service.LoginService;
import org.luo.auth.model.LoginUser;
import org.luo.auth.service.TokenService;
import org.luo.core.domain.R;
import org.luo.core.tool.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Date 15:06 2021/4/29
 * @Description {
 *
 * }
 * @Author lsay
 **/
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Resource
    private TokenService tokenService;

    /**
     * @Author lsay
     * @Description {
     *   登录接口
     * }
     * @Date 16:54 2021/5/8
     * @Param login 登录用户名密码
     * @return token
     **/
    @PostMapping("/login")
    public R<?> login(@RequestBody Login login){
        LoginUser loginUser = loginService.login(login.getUsername(),login.getPassword());
        return R.ok(tokenService.createToken(loginUser));
    }

    /**
     * @Author lsay
     * @Description {
     *   获取登录对象
     * }
     * @Date 16:54 2021/5/8
     * @return 登录用户信息
     **/
    @PostMapping("/getLoginUser")
    public R<?> getLoginUser(){
        return R.ok(tokenService.getLoginUser());
    }

    /**
     * @Author lsay
     * @Description {
     *    登出
     * }
     * @Date 16:55 2021/5/8
     **/
    @DeleteMapping("/logout")
    public R<?> logout(HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (ObjectUtils.isNotEmpty(loginUser))
        {
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
        }
        return R.ok();
    }

    /**
     * @Author lsay
     * @Description {
     *   刷新令牌
     * }
     * @Date 16:56 2021/5/8
     **/
    @PostMapping("/refresh")
    public R<?> refresh(HttpServletRequest request)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (ObjectUtils.isNotEmpty(loginUser))
        {
            // 刷新令牌有效期
            tokenService.refreshToken(loginUser);
            return R.ok();
        }
        return R.ok();
    }




}
