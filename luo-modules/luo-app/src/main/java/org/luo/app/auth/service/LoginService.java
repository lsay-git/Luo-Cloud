package org.luo.app.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.luo.app.user.entity.User;
import org.luo.app.user.service.UserService;
import org.luo.auth.model.LoginUser;
import org.luo.auth.utils.SecurityUtils;
import org.luo.core.constant.user.UserConstants;
import org.luo.core.exception.ServiceException;
import org.luo.core.tool.utils.ObjectUtils;
import org.luo.core.tool.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 15:10 2021/4/29
 * @Description {
 *
 * }
 * @Author lsay
 **/
@Component
public class LoginService {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     */
    public LoginUser login(String username, String password) {

        if(StringUtils.isAnyBlank(username,password)){
            throw new ServiceException("用户名,密码不能为空");
        }
        if(username.length() > UserConstants.USERNAME_MAX_LENGTH || username.length() < UserConstants.USERNAME_MIN_LENGTH){
            throw new ServiceException("用户名不在指定范围内");
        }
        if(password.length() > UserConstants.PASSWORD_MAX_LENGTH || password.length() < UserConstants.PASSWORD_MIN_LENGTH){
            throw new ServiceException("密码不在指定范围内");
        }

        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
        if(!ObjectUtils.isNotEmpty(user)){
            throw new ServiceException("该用户不存在");
        }
        if(!SecurityUtils.matchesPassword(password,user.getPassword())){
            throw new ServiceException("密码错误");
        }

        LoginUser loginUser = userService.selectUserInfo(user.getId());

        return loginUser;

    }
}
















