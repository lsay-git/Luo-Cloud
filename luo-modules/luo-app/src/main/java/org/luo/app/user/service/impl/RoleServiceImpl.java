package org.luo.app.user.service.impl;

import org.luo.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.luo.app.user.entity.Role;
import org.luo.app.user.mapper.RoleMapper;
import org.luo.app.user.service.RoleService;
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements RoleService{

}
