package com.limyel.hammer.common.utils;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.error.ErrorCode;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class BeanUtil {

    public static <T> T copyProperties(Object source, Class<T> clazz) {
        T target;
        try {
            target = clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new HammerException(ErrorCode.FAIL);
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T> List<T> copyToList(List<?> sourceList, Class<T> clazz) {
        return sourceList.stream().map(source -> {
            return copyProperties(source, clazz);
        }).collect(Collectors.toList());
    }

}
