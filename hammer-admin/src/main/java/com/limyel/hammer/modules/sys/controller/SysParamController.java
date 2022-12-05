package com.limyel.hammer.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.sys.model.entity.SysParamEntity;
import com.limyel.hammer.modules.sys.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 系统参数
 *
 * @author limyel
 */
@RestController
@RequestMapping("/hammer/sys/param")
public class SysParamController {

    @Autowired
    private SysParamService sysParamService;

    @GetMapping
    @PreAuthorize("hasAuthority('sys:param:list')")
    public Result<IPage<SysParamEntity>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<SysParamEntity> page = sysParamService.listByPage(pageNum, pageSize);

        return Result.success(page);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sys:param:add')")
    public Result<?> add(@RequestBody SysParamEntity sysParam) {
        sysParamService.add(sysParam);

        return Result.success();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sys:param:update')")
    public Result<?> update(@RequestBody SysParamEntity sysParam) {
        sysParamService.update(sysParam);

        return Result.success();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:param:delete')")
    public Result<?> delete(@PathVariable("id") Long id) {

        return Result.success();
    }
}
