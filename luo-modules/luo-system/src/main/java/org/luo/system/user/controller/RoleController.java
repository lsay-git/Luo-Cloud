package org.luo.system.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.luo.auth.annotation.PreAuthorize;
import org.luo.core.domain.R;
import org.luo.core.tool.utils.FuncUtils;
import org.luo.core.tool.utils.NumberUtils;
import org.luo.core.tool.utils.ObjectUtils;
import org.luo.system.user.entity.RolePermission;
import org.luo.system.user.dto.RoleSave;
import org.luo.system.user.service.RolePermissionService;
import org.luo.system.user.service.RoleService;
import org.luo.system.user.vo.RolePermissionVo;
import org.luo.system.user.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 14:49 2021/5/6
 * @Description {
 *   RoleController
 * }
 * @Author lsay
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 查询所有角色
     * @param code
     * @return
     */
    @PreAuthorize(hasPermission = "role:list")
    @GetMapping
    public R<List<RoleVo>> listRole(String code){
        return R.ok(roleService.listRole(code));
    }

    /**
     * 添加角色
     * @param roleSave
     * @return
     */
    @PreAuthorize(hasPermission = "role:add")
    @PostMapping
    public R<Boolean> addRole(@RequestBody RoleSave roleSave){
        return R.ok(roleService.saveRole(roleSave));
    }

    /**
     * 删除角色
     * @param requestMap
     * @return
     */
    @PreAuthorize(hasPermission = "role:delete")
    @DeleteMapping
    public R<Boolean> deleteRole(@RequestBody HashMap<String,String> requestMap){
        return R.ok(roleService.removeByIds(FuncUtils.toLongList(requestMap.get("ids"))));
    }

    /**
     * 查询角色所有权限
     * @param roleId
     * @return
     */
    @PreAuthorize(hasPermission = "role:list")
    @GetMapping("/getRolePermission")
    public R<RolePermissionVo> getRolePermission(String roleId){
        return R.ok(roleService.getRolePermission(Long.valueOf(roleId)));
    }

    /**
     * 删除角色权限
     * @param rolePermission
     * @return
     */
    @PreAuthorize(hasPermission = "role:delete")
    @DeleteMapping("/deleteRolePermission")
    public R<Boolean> deleteRolePermission(@RequestBody RolePermission rolePermission){
        return R.ok(rolePermissionService.remove(new LambdaQueryWrapper<RolePermission>()
                .eq(RolePermission::getRoleId,rolePermission.getRoleId()).eq(RolePermission::getPermissionId,rolePermission.getPermissionId())));
    }

    /**
     * 添加角色权限
     * @param roleId
     * @param newPermissions
     * @return
     */
    @PreAuthorize(hasPermission = "role:update")
    @PutMapping("/updateRolePermission/{roleId}")
    public R<Boolean> updateRolePermission(@PathVariable("roleId") String roleId,@RequestBody List<String> newPermissions){
        boolean result = false;
        if(!ObjectUtils.isEmpty(newPermissions)){
            List<RolePermission> rolePermissions = newPermissions.stream().map(e -> {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(Long.valueOf(roleId));
                rolePermission.setPermissionId(NumberUtils.toLong(e));
                return rolePermission;
            }).collect(Collectors.toList());
            result = rolePermissionService.saveBatch(rolePermissions);
        }
        return R.ok(result);
    }

    /**
     * 查询用户角色
     * @param userId
     * @param selectType 1-查询用户所有角色 2-查询用户未拥有所有角色
     * @return
     */
    @PreAuthorize(hasPermission = "role:list")
    @GetMapping("/listUserRoles")
    public R<List<RoleVo>> listUserRoles(String userId,Integer selectType){
        return R.ok(roleService.listUserRoles(NumberUtils.toLong(userId),selectType));
    }

}
