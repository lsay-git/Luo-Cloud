package org.luo.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.luo.auth.model.LoginUser;
import org.luo.system.user.entity.User;
import org.luo.system.user.entity.UserInfo;

/**
 * @Date 14:51 2021/5/6
 * @Description {
 *   UserInfoMapper
 * }
 * @Author lsay
 **/
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
