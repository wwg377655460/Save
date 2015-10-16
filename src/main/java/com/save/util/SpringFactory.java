package com.save.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.nutz.dao.impl.SimpleDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * Created by wsdevotion on 15/10/14.
 */
public class SpringFactory implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }


    public static Object getObject(String id) {
//        /Object object = null;
        Object object = context.getBean(id);
        System.out.println();
        return object;
    }
}