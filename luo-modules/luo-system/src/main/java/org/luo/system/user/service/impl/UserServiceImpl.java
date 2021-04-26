package org.luo.system.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.luo.core.mp.base.BaseServiceImpl;
import org.luo.system.user.entity.User;
import org.luo.system.user.mapper.UserMapper;
import org.luo.system.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {
}
