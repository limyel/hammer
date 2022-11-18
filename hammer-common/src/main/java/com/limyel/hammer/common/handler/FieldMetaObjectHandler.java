package com.limyel.hammer.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 公共字段填充
 * @author limyel
 */
@Component
public class FieldMetaObjectHandler implements MetaObjectHandler {

    private final static String CREATE_TIME = "createTime";
    private final static String CREATOR_ID = "creatorId";
    private final static String UPDATE_TIME = "updateTime";
    private final static String UPDATER_ID = "updaterId";

    @Override
    public void insertFill(MetaObject metaObject) {
        //todo 当前用户
        Date now = new Date();

        strictInsertFill(metaObject, CREATE_TIME, Date.class, now);
        strictInsertFill(metaObject, UPDATE_TIME, Date.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //todo 当前用户
        Date now = new Date();

        strictInsertFill(metaObject, UPDATE_TIME, Date.class, now);
    }
}
