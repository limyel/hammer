package com.limyel.hammer.common.entity;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.limyel.hammer.modules.security.utils.AuthenticationUtil;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Component
public class EntityMetaObjectHandler implements MetaObjectHandler {

    private final static String CREATOR_ID = "creatorId";
    private final static String CREATE_TIME = "createTime";
    private final static String UPDATER_ID = "updaterId";
    private final static String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        checkCreateTime(metaObject);
        checkCreatorId(metaObject);
        checkUpdaterId(metaObject);
        checkUpdateTime(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        checkUpdaterId(metaObject);
        checkUpdateTime(metaObject);
    }

    private void checkCreatorId(MetaObject metaObject) {
        if (metaObject.hasSetter(CREATOR_ID) && ObjectUtils.isEmpty(metaObject.getValue(CREATOR_ID))) {
            SysUserEntity sysUser = AuthenticationUtil.getSysUser();
            this.strictInsertFill(metaObject, CREATOR_ID, Long.class, sysUser.getId());
        }
    }

    private void checkCreateTime(MetaObject metaObject) {
        if (metaObject.hasSetter(CREATE_TIME) && ObjectUtils.isEmpty(metaObject.getValue(CREATE_TIME))) {
            Date now = new Date();
            this.strictInsertFill(metaObject, CREATE_TIME, Date.class, now);
        }
    }

    private void checkUpdaterId(MetaObject metaObject) {
        if (metaObject.hasSetter(UPDATER_ID) && ObjectUtils.isEmpty(metaObject.getValue(UPDATER_ID))) {
            SysUserEntity sysUser = AuthenticationUtil.getSysUser();
            this.strictInsertFill(metaObject, UPDATER_ID, Long.class, sysUser.getId());
        }
    }

    private void checkUpdateTime(MetaObject metaObject) {
        if (metaObject.hasSetter(UPDATE_TIME) && ObjectUtils.isEmpty(metaObject.getValue(UPDATE_TIME))) {
            Date now = new Date();
            this.strictInsertFill(metaObject, UPDATE_TIME, Date.class, now);
        }
    }

}
