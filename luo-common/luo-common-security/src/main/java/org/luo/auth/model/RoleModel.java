package org.luo.auth.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * @Date 14:12 2021/4/30
 * @Description {
 *   UserRoleVo
 * }
 * @Author lsay
 **/
public class RoleModel implements Serializable {

    @JsonSerialize(using= ToStringSerializer.class)
    private Long roleId;
    private String code;
    private String name;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
