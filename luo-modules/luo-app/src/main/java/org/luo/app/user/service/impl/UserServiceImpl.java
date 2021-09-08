package org.luo.app.user.service.impl;

import org.luo.auth.model.LoginUser;
import org.luo.mp.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.luo.app.user.entity.User;
import org.luo.app.user.mapper.UserMapper;
import org.luo.app.user.service.UserService;
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginUser selectUserInfo(Long id) {
        return userMapper.selectUserInfo(id);
    }
}
