package com.limyel.hammer.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.sys.model.request.PasswordDTO;
import com.limyel.hammer.modules.sys.model.response.SysUserDTO;
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

    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:user:list')")
    public Result<IPage<SysUserDTO>> list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize) {
        IPage<SysUserDTO> page = sysUserService.list(pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 修改密码
     * @param passwordDTO
     * @return
     */
    @PostMapping("/password")
    public Result<?> password(@Validated @RequestBody PasswordDTO passwordDTO) {
        return null;
    }

}
