package com.limyel.hammer.common.aspect;

import cn.hutool.json.JSONUtil;
import com.limyel.hammer.common.annotation.LogOperation;
import com.limyel.hammer.common.constant.OperationStatusConstant;
import com.limyel.hammer.common.utils.ExceptionUtil;
import com.limyel.hammer.common.utils.HttpContextUtil;
import com.limyel.hammer.modules.log.entity.SysLogOperationEntity;
import com.limyel.hammer.modules.log.service.SysLogOperationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author limyel
 */
@Aspect
@Component
public class LogOperationAspect {

    private SysLogOperationService sysLogOperationService;

    @Autowired
    public void setSysLogOperationService(SysLogOperationService sysLogOperationService) {
        this.sysLogOperationService = sysLogOperationService;
    }

    @Pointcut("@annotation(com.limyel.hammer.common.annotation.LogOperation)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            Object result = point.proceed();

            long time = System.currentTimeMillis() - beginTime;
            this.saveLog(point, time, OperationStatusConstant.SUCCESS.value(), null);

            return result;
        } catch (Exception e) {
            long time = System.currentTimeMillis() - beginTime;
            this.saveLog(point, time, OperationStatusConstant.FAIL.value(), ExceptionUtil.getStackTrace(e));

            throw e;
        }
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time, Integer status, String errorStack) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> clazz = joinPoint.getTarget().getClass();
        Method method = clazz.getDeclaredMethod(signature.getName(), signature.getParameterTypes());
        LogOperation logOperation = method.getAnnotation(LogOperation.class);

        SysLogOperationEntity log = new SysLogOperationEntity();
        log.setErrorStack(errorStack);
        if (logOperation != null) {
            log.setOperation(log.getOperation());
        }
        log.setCalledMethod(clazz.getName() + "." + method.getName() + "()");

        //todo 当前用户

        log.setStatus(status);
        log.setRequestTime((int) time);

        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        if (!ObjectUtils.isEmpty(request)) {
            log.setRequestUri(request.getRequestURI());
            log.setIp(request.getRemoteAddr());
            log.setRequestMethod(request.getMethod());
        }

        // 请求参数
        Object[] args = joinPoint.getArgs();
        String params = JSONUtil.toJsonStr(args[0]);
        log.setRequestParams(params);

        sysLogOperationService.save(log);
    }

}
