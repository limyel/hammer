package com.limyel.hammer.modules.oss.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.oss.model.entity.SysOssEntity;
import com.limyel.hammer.modules.oss.service.SysOssService;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Result<SysOssEntity> add(@RequestParam("file") MultipartFile file) {
        SysOssEntity sysOss = sysOssService.add(file);

        return Result.success(sysOss);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sys:oss:update')")
    public Result<?> update(@RequestBody SysOssEntity sysOssEntity) {
        sysOssService.update(sysOssEntity);

        return Result.success();
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('sys:oss:delete')")
    public Result<?> delete() {

        return Result.success();
    }

}
