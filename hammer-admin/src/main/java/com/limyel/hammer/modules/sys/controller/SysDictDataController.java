package com.limyel.hammer.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import com.limyel.hammer.modules.sys.service.SysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 数据字典数据
 *
 * @author limyel
 */
@RestController
@RequestMapping("/hammer/sys/dict-data")
public class SysDictDataController {

    @Autowired
    private SysDictDataService sysDictDataService;

    @GetMapping
    @PreAuthorize("hasAuthority('sys:dict:list')")
    public Result<IPage<SysDictDataEntity>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<SysDictDataEntity> page = sysDictDataService.listByPage(pageNum, pageSize);

        return Result.success(page);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sys:dict:add')")
    public Result<?> add(@RequestBody SysDictDataEntity sysDictDataEntity) {
        sysDictDataService.add(sysDictDataEntity);

        return Result.success();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sys:dict:update')")
    public Result<?> update(@RequestBody SysDictDataEntity sysDictType) {
        sysDictDataService.update(sysDictType);

        return Result.success();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:dict:delete')")
    public Result<?> delete(@PathVariable("id") Long id) {

        return Result.success();
    }
}
