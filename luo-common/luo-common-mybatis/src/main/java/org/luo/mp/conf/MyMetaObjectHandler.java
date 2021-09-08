package org.luo.mp.conf;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.luo.auth.utils.SecureUser;
import org.luo.core.tool.utils.LogUtils;
import org.luo.core.tool.utils.NumberUtils;
import org.slf4j.Logger;
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

    private static final Logger logger = LogUtils.logger(MyMetaObjectHandler.class);

    private static final String CREATE_TIME;
    private static final String CREATE_USER;
    private static final String UPDATE_TIME;
    private static final String UPDATE_USER;
    private static final String STATUS;
    private static final String IS_DELETED;
    static {
        CREATE_TIME = "createTime";
        CREATE_USER = "createUser";
        UPDATE_TIME = "updateTime";
        UPDATE_USER = "updateUser";
        STATUS = "status";
        IS_DELETED = "isDeleted";
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("insertFill");
        this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, CREATE_USER, Long.class, SecureUser.getUserId());
        this.strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, UPDATE_USER, Long.class, SecureUser.getUserId());
        this.strictInsertFill(metaObject, STATUS, Integer.class, 1);
        this.strictInsertFill(metaObject, IS_DELETED, Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("updateFill");
        this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, UPDATE_USER, Long.class, SecureUser.getUserId());
    }
}
