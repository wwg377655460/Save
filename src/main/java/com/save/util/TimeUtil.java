package com.save.util;

import java.util.Date;

/**
 * Created by wsdevotion on 15/10/16.
 */
public class TimeUtil {

    /***
     *
     * @param time 当前时间的毫秒数
     * @return 时间的类型
     */
    public static int turnTimeType(String time){
        Date date = new Date(Long.parseLong(time));
        System.out.println(String.format("%tk", date));
        int hour = Integer.parseInt(String.format("%tH", date));
        int timetype = 0;
        if(hour>=2 && hour<6){
            timetype = 0;
        }else if(6==hour){
            timetype = 1;
        }else if(7==hour){
            timetype = 2;
        }else if(8==hour){
            timetype = 3;
        }else if(hour>=9 && hour<11){
            timetype = 4;
        }else if(hour>=11 && hour<13){
            timetype = 5;
        }else if(13==hour){
            timetype = 6;
        }else if(hour>=14 && hour<16){
            timetype = 7;
        }else if(16==hour){
            timetype = 8;
        }else if(hour>=17 && hour<19){
            timetype = 9;
        }else if(hour>=19 && hour<21){
            timetype = 10;
        }else if(hour>=21 && hour<23){
            timetype = 11;
        }else{
            timetype = 12;
        }


        return timetype;
    }
}
