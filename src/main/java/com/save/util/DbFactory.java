package com.save.util;

import org.nutz.dao.Dao;

/**
 * Created by wsdevotion on 15/10/14.
 */
public abstract class DbFactory<T> {
    private Dao dao;

    public abstract T get(int id);

    public Dao getDao() {
        if (this.dao == null) {
            this.dao = DbUtils.getNutzDao();
        }
        return this.dao;
    }
}
