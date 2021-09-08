package org.luo.system.user.service.impl;

import org.luo.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.luo.system.user.mapper.RolePermissionMapper;
import org.luo.system.user.entity.RolePermission;
import org.luo.system.user.service.RolePermissionService;
@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService{

}
