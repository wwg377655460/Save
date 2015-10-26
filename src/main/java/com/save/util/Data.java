package com.save.util;

import com.save.entity.Time;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wsdevotion on 15/10/14.
 */
public class Data {

    public final static String Salt = "wfgvbh";//Md5 Salt
    public final static int Type_num = 20;//类型的数量
    public final static int Time_num = 13;//时间类型的数量

    public static String key = "A1B2C3D4E5F60708";

    public final static String pub = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCMIVUfXRO3UbPqeQqrcVOr4ywbbPBzj5LlqOA8\n" +
            "teTikn+eaDJckP3oVChf6zsfzTC471B0Eo93MPX0lVK3CyxXZOpPiWpOZ4kMmgI1N4F+Q9BGVDEc\n" +
            "EhnVp3XhumMt2dnNjt4ec3pTtohKclUpdr2Dzf88hVQA2cQSIi3zf257OwIDAQAB";

    public final static String pri = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIwhVR9dE7dRs+p5CqtxU6vjLBts\n" +
            "8HOPkuWo4Dy15OKSf55oMlyQ/ehUKF/rOx/NMLjvUHQSj3cw9fSVUrcLLFdk6k+Jak5niQyaAjU3\n" +
            "gX5D0EZUMRwSGdWndeG6Yy3Z2c2O3h5zelO2iEpyVSl2vYPN/zyFVADZxBIiLfN/bns7AgMBAAEC\n" +
            "gYBRl9cIvBmO1HP+QxyDVylxHIXCMlyP7TmLoBlxQDhV9Rd6FRG99G7jqJ0ZvM5gZgnIpRAjhesj\n" +
            "a87K62eOTWMzYshHATuKDLvSymsFYY63bt8d8r8cxq34wg9YnrKmhoMy6gE+5iP80t7SuAy7X8Oz\n" +
            "ALZ/JyQD6zw2yyU3UmoIAQJBAMx2xourwtiyC5Ov4vhSGVR9htIxPX07c3dhTDWGL3axQtF0GJll\n" +
            "srCqRFq8YZiGdrl4YZyDLhzroYXsT/cEuUECQQCvc1y0TvId/RytCAuIyotFQbPnIZOe/l+4Bc6i\n" +
            "vB0GPwUEHyYcZVOxovNejPNc/KQTEVJI3I5eYza0wZGOajl7AkBulQq6/bGLK3hxbt5NuXFzrdRe\n" +
            "GD2OXroLZfcmt6UyB5sA1056oHMtc1k2zc3nBUpu8zmvwY8OGy6n1PBGxCpBAkEAjmgqlMeHScQK\n" +
            "JH/lLNCJnlsn9LCSK3j4pFtCT2A0hr9cCO5ndqDf/8ztkI8DcTQ20Ks8iJtMi1woKSr8RAYARQJB\n" +
            "AMDCdAz2elK6X3bw0jSbKOmtsxmx6KJ8gHKuXG51wgEqFpGcftAzPusvnI1Ih+5hhDnsch2rrrU9\n" +
            "ntLjNxpxAgQ=";

    public final static String getUserMessage = "{\"username\":\"wer\"}";


    //数字对应的项目
    /*
    1、个人收入 2、早午晚餐 3、公共交通 4、水果零食 5、衣服鞋帽 6、日常用品 7、休闲聚餐 8、运动健身 9、网上购物 10、打车租车 11、交流通讯 12、旅游度假 13、化妆饰品 14、数码设备 15、通讯上网 16、邮寄快递 17、宠物宝贝 18、水电煤气 19、学习培训 20、其他杂项
     */

    //个人使用时间对应的比例
    private static Time time1 = new Time().setTime(0,"0",1,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
    private static Time time2 = new Time().setTime(0,"1",1,10,5,5,1,1,1,5,1,1,1,1,5,1,1,1,1,1,1,1);
    private static Time time3 = new Time().setTime(0,"2",1,10,10,5,1,5,1,10,1,1,1,1,10,1,1,1,1,1,1,1);
    private static Time time4 = new Time().setTime(0,"3",1,10,10,5,1,5,1,1,1,5,1,5,1,1,1,1,1,1,1,1);
    private static Time time5 = new Time().setTime(0,"4",1,5,10,5,5,5,1,1,5,1,1,1,5,1,1,10,1,1,1,1);
    private static Time time6 = new Time().setTime(0,"5",1,10,10,10,1,10,10,1,10,10,1,1,1,1,1,1,1,1,1,1);
    private static Time time7 = new Time().setTime(0,"6",1,1,5,1,5,5,1,1,5,1,1,1,1,1,1,1,1,1,1,1);
    private static Time time8 = new Time().setTime(0,"7",1,1,5,5,1,5,1,1,5,1,1,1,1,1,1,1,1,1,1,1);
    private static Time time9 = new Time().setTime(0,"8",1,1,5,5,1,5,1,1,5,1,1,1,1,1,1,1,1,1,1,1);
    private static Time time10 = new Time().setTime(0,"9",1,10,10,5,1,5,5,1,5,5,1,1,1,1,1,1,1,1,1,1);
    private static Time time11 = new Time().setTime(0,"10",1,10,10,5,1,5,5,5,5,10,5,1,1,1,1,1,1,1,1,1);
    private static Time time12 = new Time().setTime(0,"11",1,1,5,5,1,5,5,5,10,5,1,1,1,1,1,1,1,1,1,1);
    private static Time time13 = new Time().setTime(0,"12",1,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1,1,1,1,1);

//    private static Time time11 = new Time(0,"0",1,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
//    private static Time time2 = new Time(0,"1",1,10,5,5,1,1,1,5,1,1,1,1,5,1,1,1,1,1,1,1);
//    private static Time time3 = new Time(0,"2",1,10,10,5,1,5,1,10,1,1,1,1,10,1,1,1,1,1,1,1);
//    private static Time time4 = new Time(0,"3",1,10,10,5,1,5,1,1,1,5,1,5,1,1,1,1,1,1,1,1);
//    private static Time time5 = new Time(0,"4",1,5,10,5,5,5,1,1,5,1,1,1,5,1,1,10,1,1,1,1);
//    private static Time time6 = new Time(0,"5",1,10,10,10,1,10,10,1,10,10,1,1,1,1,1,1,1,1,1,1);
//    private static Time time7 = new Time(0,"6",1,1,5,1,5,5,1,1,5,1,1,1,1,1,1,1,1,1,1,1);
//    private static Time time8 = new Time(0,"7",1,1,5,5,1,5,1,1,5,1,1,1,1,1,1,1,1,1,1,1);
//    private static Time time9 = new Time(0,"8",1,1,5,5,1,5,1,1,5,1,1,1,1,1,1,1,1,1,1,1);
//    private static Time time10 = new Time(0,"9",1,10,10,5,1,5,5,1,5,5,1,1,1,1,1,1,1,1,1,1);
//    private static Time time11 = new Time(0,"10",1,10,10,5,1,5,5,5,5,10,5,1,1,1,1,1,1,1,1,1);
//    private static Time time12 = new Time(0,"11",1,1,5,5,1,5,5,5,10,5,1,1,1,1,1,1,1,1,1,1);
//    private static Time time13 = new Time(0,"12",1,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1,1,1,1,1);
//
    public static Time[] times = {time1, time2,time3,time4,time5,time6,time7,time8,time9,time10,time11,time12,time13};


//    public final static String[][] strings = {
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"},
//            {"0:0.1", "1:0.1", "2:0.1", "3:0.1", "4:0.1", "5:0.1", "6:0.1", "7:0.1", "8:0.1", "9:0.1", "10:0.1", "11:0.1", "12:0.1", "13:0.1", "14:0.1", "15:0.1", "16:0.1", "17:0.1", "18:0.1", "19:0.1"}
//    };


}
