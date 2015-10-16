package com.save.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.save.util.HttpRequestJ;
import com.save.util.TimeUtil;
import org.junit.Test;
import org.nutz.json.Json;

/**
 * Created by wsdevotion on 15/10/15.
 */
public class UserTest {


    @Test
    public void insertUser(){
        JSONObject json = new JSONObject();
        json.put("username","wer");
        json.put("password","123");
        json.put("password_sec","123");
        String url = "http://localhost:8080/insert";

        String param = json.toString();
        String s = HttpRequestJ.post(url, param);
        System.out.println(s);
    }

    @Test
    public void turnTimeType(){
        TimeUtil.turnTimeType(System.currentTimeMillis() + "");
    }

    @Test
    public void login(){
        JSONObject json = new JSONObject();
        json.put("username","wer");
        json.put("password","123");
        String url = "http://localhost:8080/login";

        String param = json.toString();
        String s = HttpRequestJ.post(url, param);
        System.out.println(s);
    }

    @Test
    public void getUserMessage(){
        JSONObject json = new JSONObject();
        json.put("username","wer");
        String url = "http://localhost:8080/getUserMessage";

        String param = json.toString();
        String s = HttpRequestJ.post(url, param);
        System.out.println(s);
    }

    @Test
    public void getBillsMes(){
        JSONObject json = new JSONObject();
        json.put("username","wer");
        String url = "http://localhost:8080/getBillsMessage";

        String param = json.toString();
        String s = HttpRequestJ.post(url, param);
        System.out.println(s);
    }

    @Test
    public void getMaxType(){
        JSONObject json = new JSONObject();
        json.put("time",System.currentTimeMillis());

        for(int i=0; i<20; i++){
            json.put("type_"+i, 1);
        }

        String url = "http://localhost:8080/getMaxType";
        String param = json.toString();
        String s = HttpRequestJ.post(url, param);
        System.out.println(s);
    }



    @Test
    public void updateUserMessage(){
        JSONObject json = new JSONObject();
        json.put("username","wer");
        json.put("pay_money_bef","100.0");
        json.put("get_money_bef","200.1");
        JSONArray arr = new JSONArray();
        JSONObject json1 = new JSONObject();
        json1.put("type",7);
        json1.put("money",200.0);
        json1.put("remark","123");
        json1.put("update_time",System.currentTimeMillis());
        arr.add(json1);
        JSONObject json2 = new JSONObject();
        json2.put("type", 3);
        json2.put("money", 300.0);
        json2.put("remark","123");
        json2.put("update_time",System.currentTimeMillis());
        arr.add(json2);
        json.put("bills", arr);
        String url = "http://localhost:8080/updateUserMessage";

        String param = json.toString();
        String s = HttpRequestJ.post(url, param);
        System.out.println(s);
    }
}
