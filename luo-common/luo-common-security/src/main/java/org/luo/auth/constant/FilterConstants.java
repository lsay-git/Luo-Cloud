package org.luo.auth.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date 10:55 2021/5/10
 * @Description {
 *   白名单
 * }
 * @Author lsay
 **/
public class FilterConstants {

    public final static Set<String> whites = new HashSet<String>(){{
        add("/login");
    }};

}
