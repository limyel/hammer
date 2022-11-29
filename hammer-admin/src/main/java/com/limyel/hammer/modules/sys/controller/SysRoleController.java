package com.limyel.hammer.modules.sys.controller;

import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.sys.model.request.SysRoleRequest;
import com.limyel.hammer.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * 角色
 *
 * @author limyel
 */
@Controller
@RequestMapping("/hammer/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping
    public Result<?> add(@RequestBody SysRoleRequest sysRoleRequest) {
        sysRoleService.add(sysRoleRequest);

        return Result.success();
    }

}
