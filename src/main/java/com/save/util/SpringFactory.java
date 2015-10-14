package com.save.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by wsdevotion on 15/10/14.
 */
public class SpringFactory implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;
    }

    public static Object getObject(String id) {
        Object object = null;
        object = context.getBean(id);
        return object;
    }
}
