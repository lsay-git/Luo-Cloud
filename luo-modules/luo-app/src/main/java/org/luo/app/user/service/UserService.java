package org.luo.app.user.service;

import org.luo.app.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.luo.auth.model.LoginUser;
import org.luo.mp.base.BaseService;

public interface UserService extends BaseService<User> {


    LoginUser selectUserInfo(Long id);
}
