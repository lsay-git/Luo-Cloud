package org.luo.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.luo.auth.model.LoginUser;
import org.luo.system.user.entity.User;
import org.luo.system.user.vo.UserInfoVo;

import java.util.HashMap;
import java.util.List;

/**
 * @Date 14:51 2021/5/6
 * @Description {
 *   UserMapper
 * }
 * @Author lsay
 **/
public interface UserMapper extends BaseMapper<User> {
    LoginUser selectUserInfo(@Param("id") Long id);

    List<UserInfoVo> listUserInfo(@Param("username") String username);
}
