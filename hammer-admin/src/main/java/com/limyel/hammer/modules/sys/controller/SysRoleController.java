package com.limyel.hammer.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.modules.sys.model.request.SysMenuRequest;
import com.limyel.hammer.modules.sys.model.request.SysRoleRequest;
import com.limyel.hammer.modules.sys.model.response.SysMenuResponse;
import com.limyel.hammer.modules.sys.model.response.SysRoleResponse;
import com.limyel.hammer.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 角色
 *
 * @author limyel
 */
@RestController
@RequestMapping("/hammer/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping
    @PreAuthorize("hasAuthority('sys:role:list')")
    public Result<IPage<SysRoleResponse>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize
    ) {
        IPage<SysRoleResponse> response = sysRoleService.listByPage(pageNum, pageSize);

        return Result.success(response);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sys:role:add')")
    public Result<?> add(@RequestBody SysRoleRequest sysRoleRequest) {
        sysRoleService.add(sysRoleRequest);

        return Result.success();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public Result<?> delete(@PathVariable("id") Long id) {

        return Result.success();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sys:menu:update')")
    public Result<?> update(@RequestBody SysRoleRequest sysRoleRequest) {
        sysRoleService.update(sysRoleRequest);

        return Result.success();
    }
}
