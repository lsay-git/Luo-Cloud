package org.luo.system.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.luo.auth.annotation.PreAuthorize;
import org.luo.core.domain.R;
import org.luo.core.tool.utils.FuncUtils;
import org.luo.system.user.entity.User;
import org.luo.system.user.entity.UserRole;
import org.luo.system.user.service.UserRoleService;
import org.luo.system.user.service.UserService;
import org.luo.system.user.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 14:49 2021/5/6
 * @Description {
 *   UserController
 * }
 * @Author lsay
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 查询用户列表
     * @param username
     * @return
     */
    @PreAuthorize(hasPermission = "user:list")
    @GetMapping
    public R<List<UserInfoVo>> selectUser(String username){
        return R.ok(userService.listUserInfo(username));
    }

    /**
     * 添加用户
     * @param user username password
     * @return
     */
    @PreAuthorize(hasPermission = "user:add")
    @PostMapping
    public R<Boolean> addUser(@RequestBody User user){
        return R.ok(userService.save(user));
    }

    /**
     * 删除用户
     * @param ids 用户id 多个逗号隔开
     * @return
     */
    @PreAuthorize(hasPermission = "user:delete")
    @DeleteMapping
    public R<Boolean> deleteUser(@RequestParam String ids){
        return R.ok(userService.removeByIds(FuncUtils.toLongList(ids)));
    }

    /**
     * 添加用户角色
     * @param userRole userId roleId
     * @return
     */
    @PreAuthorize(hasPermission = "user:update")
    @PostMapping("/addUserRoles")
    public R<Boolean> addUserRoles(@RequestBody UserRole userRole){
        return R.ok(userRoleService.save(userRole));
    }

    /**
     * 删除用户角色
     * @param userRole userId roleId
     * @return
     */
    @PreAuthorize(hasPermission = "user:update")
    @DeleteMapping("/deleteUserRole")
    public R<Boolean> deleteUserRole(@RequestBody UserRole userRole){
        return R.ok(userRoleService.remove(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId,userRole.getUserId()).eq(UserRole::getRoleId,userRole.getRoleId())));
    }

}
