package org.luo.app.user.service.impl;

import org.luo.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.luo.app.user.mapper.UserInfoMapper;
import org.luo.app.user.entity.UserInfo;
import org.luo.app.user.service.UserInfoService;
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService{

}
