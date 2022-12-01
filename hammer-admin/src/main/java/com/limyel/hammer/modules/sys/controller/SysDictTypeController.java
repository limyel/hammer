package com.limyel.hammer.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.sys.model.entity.SysDictTypeEntity;
import com.limyel.hammer.modules.sys.model.request.SysUserRequest;
import com.limyel.hammer.modules.sys.model.response.SysUserResponse;
import com.limyel.hammer.modules.sys.service.SysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 数据字典类型
 *
 * @author limyel
 */
@RestController
@RequestMapping("/hammer/sys/dict-type")
public class SysDictTypeController {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    @GetMapping
    @PreAuthorize("hasAuthority('sys:dict:list')")
    public Result<IPage<SysDictTypeEntity>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<SysDictTypeEntity> page = sysDictTypeService.listByPage(pageNum, pageSize);

        return Result.success(page);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sys:dict:add')")
    public Result<?> add(@RequestBody SysDictTypeEntity sysDictTypeEntity) {
        sysDictTypeService.add(sysDictTypeEntity);

        return Result.success();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sys:dict:update')")
    public Result<?> update(@RequestBody SysDictTypeEntity sysDictType) {
        sysDictTypeService.update(sysDictType);

        return Result.success();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:dict:delete')")
    public Result<?> delete(@PathVariable("id") Long id) {

        return Result.success();
    }
}
