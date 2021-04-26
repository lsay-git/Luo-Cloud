package org.luo.core.mp.conf;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Date 11:50 2021/4/26
 * @Description {
 *   mp 自动装填
 * }
 * @Author lsay
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static String CREATE_TIME;
    private static String CREATE_USER;
    private static String UPDATE_TIME;
    private static String UPDATE_USER;
    static {
        CREATE_TIME = "createTime";
        CREATE_USER = "createUser";
        UPDATE_TIME = "updateTime";
        UPDATE_USER = "updateUser";
    }


    @Override
    public void insertFill(MetaObject metaObject) {
        System.err.println("insertFill -----------------------------");
        this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, CREATE_USER, Long.class, 0L);
        this.strictInsertFill(metaObject, UPDATE_USER, Long.class, 0L);
//        this.setFieldValByName(CREATE_USER, 0,metaObject);
        this.strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
//        this.setFieldValByName(UPDATE_USER, 0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.err.println("updateFill -----------------------------");
        this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, UPDATE_TIME, Integer.class, 0);
    }
}
