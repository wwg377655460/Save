package com.save.dao;

import com.save.entity.Time;
import com.save.util.DbFactory;
import org.springframework.stereotype.Service;

/**
 * Created by wsdevotion on 15/10/14.
 */
@Service
public class TimeDao extends DbFactory<Time> {

    @Override
    public Time get(int id) {
        return null;
    }

    //获取时间段类型数量
    public Time getTimeByType(String time){
        return getDao().fetch(Time.class, time);
    }

    //更改时间段类型数量
    public int updateTimeByType(Time time){
        return getDao().update(time);
    }
}
