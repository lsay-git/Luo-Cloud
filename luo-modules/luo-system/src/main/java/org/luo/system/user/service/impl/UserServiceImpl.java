package org.luo.system.user.service.impl;

import org.luo.auth.model.LoginUser;
import org.luo.auth.utils.SecurityUtils;
import org.luo.mp.base.BaseServiceImpl;
import org.luo.core.tool.utils.CollectionUtils;
import org.luo.system.user.entity.User;
import org.luo.system.user.entity.UserInfo;
import org.luo.system.user.entity.UserRole;
import org.luo.system.user.mapper.UserMapper;
import org.luo.system.user.service.UserInfoService;
import org.luo.system.user.service.UserRoleService;
import org.luo.system.user.service.UserService;
import org.luo.system.user.vo.UserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 14:38 2021/5/6
 * @Description {
 *   UserServiceImpl
 * }
 * @Author lsay
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询登录用户的所有信息
     * @param id
     * @return
     */
    @Override
    public LoginUser selectUserInfo(Long id) {
        return userMapper.selectUserInfo(id);
    }

    @Override
    public List<UserInfoVo> listUserInfo(String username) {
        return userMapper.listUserInfo(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(User entity) {
        boolean result;
        entity.setPassword(SecurityUtils.encryptPassword(entity.getPassword()));
        result = super.save(entity);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(entity.getId());
        result = result && userInfoService.save(userInfo);
        return result;
    }
}
