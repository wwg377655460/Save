package com.save.util;

import com.save.entity.Time;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wsdevotion on 15/10/15.
 */
public class TurnTypeNum {

    /***
     * @param time time类型的对象
     * @return 对象数据封装的结构
     */
    public static Map<Integer, Double> turnType(Time time) {
        Integer all = 0;
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        Integer[] s = new Integer[Data.Type_num];
        Class<Time> time_class = (Class<Time>) time.getClass();
        try {
            for (int i = 0; i < Data.Type_num; i++) {
                Method m = time_class.getMethod("getType_" + i);
                s[i] = (Integer) m.invoke(time);
                all += s[i];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Data.Type_num; i++) {
            if (all == 0) {
                map.put(i, 0.00);
                continue;
            }
            Double db = s[i] / Double.parseDouble(all + "");
            DecimalFormat df = new DecimalFormat("0.00");//格式化小数
            String bds = df.format(db);//返回的是String类型
            Double d = Double.parseDouble(bds);
            map.put(i, d);
        }

        return map;

    }
}
