package com.save.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.save.util.*;
import com.save.util.desUtil;
import org.junit.Test;

/**
 * Created by wsdevotion on 15/10/15.
 */
public class UserTest {


    @Test
    public void insertUser() {
        JSONObject json = new JSONObject();
        json.put("username", "洒出123123234123");
        json.put("password", "123");
        json.put("password_sec", "123");
//        String result = "";
//        try {
//            result = desUtil.encrypt(json.toString(), Data.key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        result = SecUtil.encrypt(Data.pub, result);
//        String url = "http://saveapp.cn-hangzhou.aliapp.com/insert";
        String url = "http://localhost:8080/insert";
        String param = "json=" + json.toString();
        String s = HttpRequest.sendPost(url, param);
        System.out.println(s);
    }

    @Test
    public void turnTimeType() {
        TimeUtil.turnTimeType(System.currentTimeMillis() + "");
    }

    @Test
    public void login() {
        JSONObject json = new JSONObject();
        json.put("username", "wer");
        json.put("password", "123");
//        String p = "KfJkYlUeq1ocWxdiTj+YJyykOARo2LQoozW0PDwIj1lvqidWLXL6BJxPgCSEmZWmTnvULI2Hu6A4\n" +
//                "8qZROjvap84LKbF5xPsOsFrRjICtp9oKto3SEnx+nULXRY/pKDEckvN0H/kE27lZonp8rleDdnOL\n" +
//                "ldCe7SoXLBzfG71TucQ=10";
//        String result = "";
//        try {
//            result = desUtil.encrypt(json.toString(), Data.key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        result = SecUtil.encrypt(Data.pub, result);
        String url = "http://localhost:8080/login";

        String param = "json=" + json.toString();
        System.out.println(param);
        String s = HttpRequest.sendPost(url, param);
        System.out.println(s);
    }

    @Test
    public void getUserMessage() {
        JSONObject json = new JSONObject();
        json.put("username", "洒出123");
        json.put("password", "123");
//        String result = "";
//        try {
//            result = desUtil.encrypt(json.toString(), Data.key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        result = SecUtil.encrypt(Data.pub, result);
        String url = "http://localhost:8080/getUserMessage";

        String param = "json=" + json.toString();
        String s = HttpRequest.sendPost(url, param);
        System.out.println(s);
    }

    @Test
    public void getBillsMes() {
        JSONObject json = new JSONObject();
        json.put("username", "洒出123");
        json.put("password", "123");
//        String result = "";
//        //des加密，减小信息字节数，再用RSA解密
//        try {
//            result = desUtil.encrypt(json.toString(), Data.key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        result = SecUtil.encrypt(Data.pub, result);
        String url = "http://localhost:8080/getBillsMessage";

        String param = "json=" + json.toString();
        String s = HttpRequest.sendPost(url, param);
        System.out.println(s);
    }

    @Test
    public void getMaxType() {


//        String url = "http://localhost:8080/getMemoMes";
//        String s = HttpRequestJ.post(url, "");
//        System.out.println(s);

        JSONObject json = new JSONObject();
        json.put("time", 9);

        for (int i = 0; i < 20; i++) {
            json.put("type_" + i, 1);
        }

//        String result = "";
//        //des加密，减小信息字节数，再用RSA解密
//        try {
//            result = desUtil.encrypt(json.toString(), Data.key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);
//        result = SecUtil.encryptMax(Data.pub, result);
        String url = "http://localhost:8080/getMaxType";
        String param = "json=" + json.toString();
        String s = HttpRequest.sendPost(url, param);
        System.out.println(s);
    }


    @Test
    public void updateUserMessage() {
        JSONObject json = new JSONObject();
        json.put("username", "洒出123");
        json.put("pay_money_bef", "100.0");
        json.put("get_money_bef", "203.1");
        json.put("password_sec", "123");
        JSONArray arr = new JSONArray();
        JSONObject json1 = new JSONObject();
        json1.put("type", 7);
        json1.put("money", 243.0);
        json1.put("remark", "你好123123123");
        json1.put("update_time", System.currentTimeMillis());
        arr.add(json1);
        JSONObject json2 = new JSONObject();
        json2.put("type", 3);
        json2.put("money", 300.0);
        json2.put("remark", "123");
        json2.put("update_time", System.currentTimeMillis());
        arr.add(json2);
        json.put("bills", arr);
//        String result = "";
//        //des加密，减小信息字节数，再用RSA解密
//        try {
//            result = desUtil.encrypt(json.toString(), Data.key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        result = SecUtil.encryptMax(Data.pub, result);
        String url = "http://localhost:8080/updateUserMessage";

        String param = "json=" + json.toString();
        String s = HttpRequest.sendPost(url, param);
        System.out.println(s);
    }

    @Test
    public void getUrlMessage(){
        String url = "http://saveapp.cn-hangzhou.aliapp.com/getMemoMes";
        String s = HttpRequest.sendPost(url, "");
        System.out.println(s);
    }
}
