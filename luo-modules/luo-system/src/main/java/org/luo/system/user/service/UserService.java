package org.luo.system.user.service;

import org.luo.auth.model.LoginUser;
import org.luo.mp.base.BaseService;
import org.luo.system.user.entity.User;
import org.luo.system.user.vo.UserInfoVo;

import java.util.List;

/**
 * @Date 14:37 2021/5/6
 * @Description {
 *   UserService
 * }
 * @Author lsay
 **/
public interface UserService extends BaseService<User> {
    LoginUser selectUserInfo(Long id);

    List<UserInfoVo> listUserInfo(String username);

}
