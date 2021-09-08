package org.luo.app.user.service.impl;

import org.luo.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.luo.app.user.mapper.UserRoleMapper;
import org.luo.app.user.entity.UserRole;
import org.luo.app.user.service.UserRoleService;
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements UserRoleService{

}
