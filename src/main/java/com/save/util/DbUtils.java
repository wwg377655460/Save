package com.save.util;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;

import javax.sql.DataSource;

/**
 * Created by wsdevotion on 15/10/14.
 */
public class DbUtils {
    private static Dao nutzDao;

    public static Dao getNutzDao() {
        if (nutzDao == null) {
            nutzDao = new NutDao((DataSource) SpringFactory.getObject("ds"));
        }

        return nutzDao;
    }
}
