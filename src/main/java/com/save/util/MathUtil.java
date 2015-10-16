package com.save.util;

import java.util.*;

/**
 * Created by wsdevotion on 15/10/15.
 */
public class MathUtil {


    /***
     *
     * @param map_p 所有的数据
     * @param map_a 个人上传的数据
     * @param map_f 设置的数据
     * @return 可能的类型
     */
    public static int getMaxType(Map<Integer, Double> map_p, Map<Integer, Double> map_a, Map<Integer, Double> map_f) {

        Map<Integer, Double> map = new HashMap<Integer, Double>();
        Integer[] sort = new Integer[Data.Type_num];
        Double d;

        for (int i = 0; i < Data.Type_num; i++) {
            if(map_p==null) {
                d = map_a.get(i) * 0.4 + map_f.get(i) * 0.2;
            }else {
                d = map_p.get(i) * 0.4 + map_a.get(i) * 0.4 + map_f.get(i) * 0.2;
            }
            map.put(i, d);
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int max = list.get(0).getKey();
        return max;
    }

    /***
     *
     * @param timeType 时间的类型
     * @return 时间类型所对应事件的可能性
     */
    public static Map<Integer, Double> getMap(int timeType) {
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        for (int i = 0; i < Data.Type_num; i++) {
            String s = Data.strings[timeType][i];
            String mes[] = s.split(":");
            Integer k = Integer.parseInt(mes[0]);
            Double d = Double.parseDouble(mes[1]);
            map.put(k, d);
        }

        return map;
    }
}
