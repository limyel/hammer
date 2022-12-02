package com.limyel.hammer.modules.oss.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.oss.model.entity.SysOssEntity;
import com.limyel.hammer.modules.oss.service.SysOssService;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 文件上传
 *
 * @author limyel
 */
@RestController
@RequestMapping("/sys/oss")
public class SysOssController {

    @Autowired
    private SysOssService sysOssService;

    @GetMapping
    @PreAuthorize("hasAuthority('sys:oss:list')")
    public Result<IPage<SysOssEntity>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<SysOssEntity> page = sysOssService.listByPage(pageNum, pageSize);

        return Result.success(page);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sys:oss:add')")
    public Result<?> add(@RequestBody SysOssEntity sysOssEntity) {
        sysOssService.add(sysOssEntity);

        return Result.success();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sys:oss:update')")
    public Result<?> update(@RequestBody SysOssEntity sysOssEntity) {
        sysOssService.update(sysOssEntity);

        return Result.success();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:oss:delete')")
    public Result<?> delete(@PathVariable("id") Long id) {

        return Result.success();
    }

}
