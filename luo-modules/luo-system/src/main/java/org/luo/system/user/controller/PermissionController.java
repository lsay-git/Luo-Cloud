package org.luo.system.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.luo.auth.annotation.PreAuthorize;
import org.luo.core.domain.R;
import org.luo.system.user.entity.Permission;
import org.luo.system.user.service.PermissionService;
import org.luo.system.user.vo.PermissionInfoCascadeVo;
import org.luo.system.user.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 9:52 2021/5/21
 * @Description {
 *   PageTable 页面权限
 * }
 * @Author lsay
 **/
@RestController
@RequestMapping("/pageTable")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 获取页面权限列表
     * @param code
     * @return
     */
    @PreAuthorize(hasPermission = "pageTable:list")
    @GetMapping
    public R<List<PermissionVo>> listPermission(String code){
        return R.ok(permissionService.listPermission(code));
    }

    /**
     * 添加页面权限
     * @param permission
     * @return
     */
    @PreAuthorize(hasPermission = "pageTable:add")
    @PostMapping
    public R<Boolean> addPermission(@RequestBody Permission permission){
        return R.ok(permissionService.save(permission));
    }

    /**
     * 删除页面权限
     * @param permission
     * @return
     */
    @PreAuthorize(hasPermission = "pageTable:delete")
    @DeleteMapping
    public R<Boolean> deletePermission(@RequestBody Permission permission){
        return R.ok(permissionService.remove(new LambdaQueryWrapper<Permission>().eq(Permission::getCode,permission.getCode())));
    }

    /**
     * 角色权限组件展示
     * @param type update 展示已有权限 add 展示角色未拥有权限
     * @param roleId
     * @return
     */
    @PreAuthorize(hasPermission = "pageTable:list")
    @GetMapping("/permissionCascade")
    public R<List<PermissionInfoCascadeVo>> permissionCascade(String type,String roleId){
        return R.ok(permissionService.permissionCascade(type,Long.valueOf(roleId == null ? "0" : roleId)));
    }

}
