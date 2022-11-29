package com.limyel.hammer.common.utils;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.error.ErrorCode;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class SpringUtil implements BeanFactoryPostProcessor, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        SpringUtil.beanFactory = configurableListableBeanFactory;
    }

    public static <T> T getBean(Class<T> clazz) {
        if (ObjectUtils.isEmpty(clazz)) {
            throw new HammerException(ErrorCode.FAIL);
        }
        return applicationContext.getBean(clazz);
    }

}
