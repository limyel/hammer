package com.limyel.hammer.modules.sys.controller;

import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.sys.model.request.SysMenuDTO;
import com.limyel.hammer.modules.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.awt.*;

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
    public Result<?> add(@RequestBody SysMenuDTO dto) {
        sysMenuService.add(dto);

        return Result.success();
    }

}
