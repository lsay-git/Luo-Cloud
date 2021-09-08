package org.luo.app.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.luo.app.user.entity.User;
import org.luo.auth.model.LoginUser;

public interface UserMapper extends BaseMapper<User> {
    LoginUser selectUserInfo(Long id);
}