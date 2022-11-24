package com.limyel.hammer.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.sys.model.request.PasswordDTO;
import com.limyel.hammer.modules.sys.model.response.SysUserResponse;
import com.limyel.hammer.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 *
 * @author limyel
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    private SysUserService sysUserService;
    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 分页
     * @param pageNum 页数
     * @param pageSize 每页数量
     * @return 系统用户分页
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:user:list')")
    public Result<IPage<SysUserResponse>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<SysUserResponse> page = sysUserService.list(pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 修改密码
     * @param passwordDTO 修改密码请求体
     * @return null
     */
    @PostMapping("/password")
    public Result<?> password(@Validated @RequestBody PasswordDTO passwordDTO) {
        return null;
    }

}
