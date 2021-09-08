package org.luo.system.user.dto;

import lombok.Data;

import java.util.List;

/**
 * @Date 11:07 2021/5/22
 * @Description {
 *    RoleSave
 * }
 * @Author lsay
 **/
@Data
public class RoleSave {

    private String code;

    private String name;

    private List<String> permissions;

}
