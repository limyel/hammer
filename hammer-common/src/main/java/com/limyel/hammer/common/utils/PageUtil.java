package com.limyel.hammer.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.error.ErrorCode;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class PageUtil<T> {

    public static <T> IPage<T> copyRecords(IPage<?> page, Class<T> clazz) {
        List<T> records = page.getRecords().stream().map(record -> {
            T target;
            try {
                target = clazz.getConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                throw new HammerException(ErrorCode.FAIL);
            }
            BeanUtils.copyProperties(record, target);
            return target;
        }).collect(Collectors.toList());
        IPage<T> result = Page.of(page.getCurrent(), page.getSize());
        return result.setTotal(page.getTotal()).setRecords(records);
    }

}
