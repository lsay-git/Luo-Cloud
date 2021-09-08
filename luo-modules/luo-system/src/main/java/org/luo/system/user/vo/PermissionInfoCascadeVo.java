package org.luo.system.user.vo;

import lombok.Data;
import org.luo.system.user.vo.PermissionInfoCascadeChildrenVo;
import java.io.Serializable;
import java.util.List;

/**
 * @Date 14:12 2021/4/30
 * @Description {
 *   UserRoleVo
 * }
 * @Author lsay
 **/
@Data
public class PermissionInfoCascadeVo implements Serializable {

    /**
     * 页面 code
     */
    private String value;
    /**
     * 页面名称 name
     */
    private String label;
    /**
     * 权限 permissions
     */
    private List<PermissionInfoCascadeChildrenVo> children;

}
