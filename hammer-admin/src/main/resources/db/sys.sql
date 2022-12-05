-- hammer.sys_dict_data definition

CREATE TABLE `sys_dict_data` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典数据ID',
    `dict_type_id` bigint NOT NULL COMMENT '字典类型ID',
    `dict_label` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '字典标签',
    `dict_value` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典值',
    `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
    `order_num` int NOT NULL DEFAULT '0' COMMENT '排序',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- hammer.sys_dict_type definition

CREATE TABLE `sys_dict_type` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典类型ID',
    `dict_type` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '字典类型',
    `dict_name` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '字典名称',
    `remark` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
    `order_num` int NOT NULL DEFAULT '0' COMMENT '排序',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- hammer.sys_log_login definition

CREATE TABLE `sys_log_login` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '登录日志ID',
    `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
    `operation` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作',
    `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态，0:成功 1:失败',
    `ip` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'IP地址',
    `creator_id` bigint NOT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- hammer.sys_log_operation definition

CREATE TABLE `sys_log_operation` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '操作日志ID',
    `operation` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '操作',
    `request_uri` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '请求URI',
    `request_params` text COLLATE utf8mb4_bin COMMENT '请求参数',
    `request_method` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
    `request_time` int unsigned DEFAULT NULL COMMENT '执行时间',
    `called_method` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '调用方法',
    `status` smallint NOT NULL DEFAULT '0' COMMENT '状态，0:成功 1:失败',
    `ip` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'IP地址',
    `error_stack` text COLLATE utf8mb4_bin COMMENT '错误消息',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- hammer.sys_menu definition

CREATE TABLE `sys_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门ID',
    `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '菜单名称',
    `parent_id` bigint DEFAULT NULL COMMENT '父级菜单ID',
    `path` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '路由地址',
    `query` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '路由参数',
    `order_num` int NOT NULL DEFAULT '0' COMMENT '排序',
    `permissions` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限',
    `status` smallint NOT NULL DEFAULT '0' COMMENT '状态，0:正常 1:停用',
    `type` smallint NOT NULL DEFAULT '0' COMMENT '菜单类型，0:菜单 1:按钮',
    `remark` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
INSERT INTO hammer.sys_menu (name,parent_id,`path`,query,order_num,permissions,status,`type`,remark,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    ('权限管理',NULL,NULL,NULL,0,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('用户管理',1,NULL,NULL,0,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('查看',2,NULL,NULL,0,'sys:user:list,sys:user:get',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('新增',2,NULL,NULL,1,'sys:user:add',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('修改',2,NULL,NULL,2,'sys:user:update',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('删除',2,NULL,NULL,3,'sys:user:delete',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('导出',2,NULL,NULL,4,'sys:user:export',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('角色管理',1,NULL,NULL,1,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('查看',8,NULL,NULL,0,'sys:role:list,sys:role:get',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('新增',8,NULL,NULL,1,'sys:role:add',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);
INSERT INTO hammer.sys_menu (name,parent_id,`path`,query,order_num,permissions,status,`type`,remark,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    ('修改',8,NULL,NULL,2,'sys:role:update',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('删除',8,NULL,NULL,3,'sys:role:delete',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('系统设置',NULL,NULL,NULL,1,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('菜单管理',13,NULL,NULL,0,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('查看',14,NULL,NULL,0,'sys:menu:list,sys:menu:get',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('新增',14,NULL,NULL,1,'sys:menu:add',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('修改',14,NULL,NULL,2,'sys:menu:update',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('删除',14,NULL,NULL,3,'sys:menu:delete',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('参数管理',13,NULL,NULL,1,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('查看',19,NULL,NULL,0,'sys:param:list,sys:param:get',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);
INSERT INTO hammer.sys_menu (name,parent_id,`path`,query,order_num,permissions,status,`type`,remark,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    ('新增',19,NULL,NULL,1,'sys:param:add',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('修改',19,NULL,NULL,2,'sys:param:update',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('删除',19,NULL,NULL,3,'sys:param:delete',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('导出',19,NULL,NULL,4,'sys:param:export',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('字典管理',13,NULL,NULL,2,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('查看',25,NULL,NULL,0,'sys:dict:list,sys:dict:get',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('新增',25,NULL,NULL,1,'sys:dict:add',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('修改',25,NULL,NULL,2,'sys:dict:update',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('删除',25,NULL,NULL,3,'sys:dict:delete',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('定时任务',13,NULL,NULL,3,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);
INSERT INTO hammer.sys_menu (name,parent_id,`path`,query,order_num,permissions,status,`type`,remark,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    ('查看',30,NULL,NULL,0,'sys:schedule:list,sys:schedule:get',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('新增',30,NULL,NULL,1,'sys:schedule:add',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('修改',30,NULL,NULL,2,'sys:schedule:update',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('删除',30,NULL,NULL,3,'sys:schedule:delete',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('暂停',30,NULL,NULL,4,'sys:schedule:pause',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('恢复',30,NULL,NULL,5,'sys:schedule:resume',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('立即执行',30,NULL,NULL,6,'sys:schedule:run',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('日志列表',30,NULL,NULL,7,'sys:schedule:log',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('文件上传',13,NULL,NULL,4,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('查看',39,NULL,NULL,0,'sys:oss:list,sys:oss:get',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);
INSERT INTO hammer.sys_menu (name,parent_id,`path`,query,order_num,permissions,status,`type`,remark,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    ('新增',39,NULL,NULL,1,'sys:oss:add',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('修改',39,NULL,NULL,2,'sys:oss:update',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('删除',39,NULL,NULL,3,'sys:oss:delete',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('日志管理',NULL,NULL,NULL,2,NULL,0,0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('登录日志',44,NULL,NULL,0,'sys:log:login',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    ('操作日志',44,NULL,NULL,1,'sys:log:operation',0,1,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);


-- hammer.sys_param definition

CREATE TABLE `sys_param` (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '系统参数ID',
     `param_code` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参数编码',
     `param_value` varchar(2048) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参数值',
     `param_type` tinyint DEFAULT '1' COMMENT '类型 0: 系统参数，1: 非系统参数',
     `remark` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
     `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
     `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
     PRIMARY KEY (`id`),
     UNIQUE KEY `param_code` (`param_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- hammer.sys_oss definition

CREATE TABLE `sys_oss` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '文件上传ID',
    `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'URL地址',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- hammer.sys_role definition

CREATE TABLE `sys_role` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '操作日志ID',
    `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
    `status` smallint DEFAULT '0' COMMENT '状态，0:正常 1:停用',
    `remark` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
INSERT INTO hammer.sys_role (name,status,remark,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    ('超级管理员',0,NULL,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);


-- hammer.sys_role_menu definition

CREATE TABLE `sys_role_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色菜单关联ID',
    `role_id` bigint NOT NULL COMMENT '角色ID',
    `menu_id` bigint NOT NULL COMMENT '菜单ID',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
INSERT INTO hammer.sys_role_menu (role_id,menu_id,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    (1,1,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,2,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,3,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,4,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,5,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,6,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,7,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,8,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,9,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
(1,10,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);
INSERT INTO hammer.sys_role_menu (role_id,menu_id,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    (1,11,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,12,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,13,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,14,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,15,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,16,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,17,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,18,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,19,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
(1,20,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);
INSERT INTO hammer.sys_role_menu (role_id,menu_id,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    (1,21,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,22,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,23,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,24,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,25,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,26,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,27,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,28,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,29,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,30,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);
INSERT INTO hammer.sys_role_menu (role_id,menu_id,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    (1,31,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,32,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,33,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,34,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,35,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,36,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,37,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,38,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
    (1,39,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL),
(1,40,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);


-- hammer.sys_role_user definition

CREATE TABLE `sys_role_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色用户关联ID',
    `role_id` bigint NOT NULL COMMENT '角色ID',
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
INSERT INTO hammer.sys_role_user (role_id,user_id,creator_id,create_time,updater_id,update_time,delete_time) VALUES
    (1,1,1,'2022-11-28 15:00:30',1,'2022-11-28 15:00:30',NULL);


-- hammer.sys_user definition

CREATE TABLE `sys_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
    `password` varchar(512) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
    `avatar` varchar(512) COLLATE utf8mb4_bin DEFAULT '' COMMENT '头像地址',
    `gender` smallint DEFAULT '0' COMMENT '性别，0:男 1:女 2:未知',
    `email` varchar(128) COLLATE utf8mb4_bin DEFAULT '' COMMENT '邮箱',
    `mobile` varchar(32) COLLATE utf8mb4_bin DEFAULT '' COMMENT '手机号',
    `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
    `super_admin` tinyint(1) DEFAULT '0' COMMENT '超级管理员，0:否 1:是',
    `status` smallint NOT NULL DEFAULT '0' COMMENT '账号状态，0:正常 1:停用',
    `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `updater_id` bigint DEFAULT NULL COMMENT '更新者ID',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
INSERT INTO hammer.sys_user (username,password,avatar,gender,email,mobile,dept_id,super_admin,status,creator_id,create_time,updater_id,update_time,remark,delete_time) VALUES
    ('admin','$2a$10$VZ51iDHJn/T5pZc0eglavuVkhaoL1psHlrEUaeKrE5K.KbvJU.e.u','',0,'','',NULL,0,0,NULL,'2022-11-28 15:00:30',NULL,'2022-11-28 15:00:30',NULL,NULL);
