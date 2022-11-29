package com.limyel.hammer.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.modules.sys.model.request.SysMenuRequest;
import com.limyel.hammer.modules.sys.model.response.SysMenuResponse;
import com.limyel.hammer.modules.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 菜单
 *
 * @author limyel
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuController {

    private SysMenuService sysMenuService;
    @Autowired
    public void setSysMenuService(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public Result<?> add(@RequestBody SysMenuRequest sysMenuRequest) {
        sysMenuService.add(sysMenuRequest);

        return Result.success();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result<?> delete(@PathVariable("id") Long id) {
        List<SysMenuResponse> subMenuList = sysMenuService.listSubMenu(id);
        if (subMenuList.size() > 0) {
            return Result.fail(SysErrorCode.SYS_MENU_SUB_MENU_EXIST);
        }
        sysMenuService.removeById(id);
        return Result.success();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sys:menu:update')")
    public Result<?> update(@RequestBody SysMenuRequest sysMenuRequest) {
        sysMenuService.update(sysMenuRequest);
        return Result.success();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('sys:menu:list')")
    public Result<?> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize
    ) {
        IPage<SysMenuResponse> response = sysMenuService.listByPage(pageNum, pageSize);
        return Result.success(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:menu:get')")
    public Result<SysMenuResponse> get(@PathVariable("id") Long id) {
        SysMenuResponse response = sysMenuService.getById(id);
        return Result.success(response);
    }
}
