package com.save.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.save.dao.BillDao;
import com.save.dao.TimeDao;
import com.save.dao.UserDao;
import com.save.entity.Bill;
import com.save.entity.Time;
import com.save.entity.User;
import com.save.util.Data;
import com.save.util.Md5;
import com.save.util.TimeUtil;
import com.save.util.UrlUtils.OnlineMethod;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by wsdevotion on 15/10/14.
 */
@Controller
public class UserController {

    @Resource
    UserDao userdao;


    @Resource
    TimeDao timeDao;

    @Resource
    BillDao billDao;

    //登录
    @OnlineMethod(memo = "登录", param = "", method = "post", url ="/login", type = 1)
    @ResponseBody
    @RequestMapping("/login")
    @Transactional(rollbackFor = {Exception.class})
    public String loginUserController(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject jsons = new JSONObject();
        String password_m = Md5.MD5(password + Data.Salt);
        User user = userdao.loginUser(username, password_m);
        if (user == null) {
            jsons.put("result", "0");
        } else {
            jsons.put("result", "1");
        }

        return jsons.toString();
    }

    //获取用户账单信息
    @OnlineMethod(memo = "获取用户账单信息", param = "", method = "post", url ="/getBillsMessage", type = 1)
    @ResponseBody
    @RequestMapping("/getBillsMessage")
    @Transactional(rollbackFor = {Exception.class})
    public String getUserBillsMes(String json){
        JSONObject jsonObject = JSON.parseObject(json);
        String username = jsonObject.getString("username");
        List<Bill> userBill = userdao.getUserBill(username);
        String bills = JSON.toJSONString(userBill);
        JSONArray bills_arr = (JSONArray) JSONArray.parse(bills);
        JSONObject jsons = new JSONObject();
        jsons.put("result",1);
        jsons.put("bills",bills_arr);

        return json.toString();
    }

    //获取用户信息
    @OnlineMethod(memo = "获取用户信息", param = Data.getUserMessage, method = "post", url ="/getUserMessage", type = 1)
    @ResponseBody
    @RequestMapping("/getUserMessage")
    @Transactional(rollbackFor = {Exception.class})
    public String getUserMes(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String username = jsonObject.getString("username");
        User user = userdao.getUserMes(username);
        user.setPassword("");
        String jsons = JSON.toJSONString(user);
        return jsons;
    }

    //上传用户账户信息
    @OnlineMethod(memo = "上传用户账户信息", param = "", method = "post", url ="/updateUserMessage", type = 1)
    @ResponseBody
    @RequestMapping("/updateUserMessage")
    @Transactional(rollbackFor = {Exception.class})
    public String updateUserMes(String json) {
        User user = JSON.parseObject(json.toString(), User.class);
        User user_n = userdao.getUserMes(user.getUsername());
        user_n.setGet_money_bef(user.getGet_money_bef());
        user_n.setPay_money_bef(user.getPay_money_bef());
        userdao.updateUser(user_n);
        JSONObject jsonObject1 = new JSONObject();
        List<Bill> bills = user.getBills();
        for (Bill bill : bills) {
            //获取类型，更改用户统计表
            int type = bill.getType();
            String time = bill.getUpdate_time();
            int timetype = TimeUtil.turnTimeType(time);
            Time times = timeDao.getTimeByType(timetype + "");
            Class<Time> cl = (Class<Time>) times.getClass();
            Method m1 = null;
            Method m2 = null;
            try {
                m1 = cl.getMethod("getType_" + type);
                int n = (Integer) m1.invoke(times);

                m2 = cl.getMethod("setType_" + type, int.class);
                m2.invoke(times, n + 1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            timeDao.updateTimeByType(times);
            bill.setUser_id(user_n.getId());
            bill.setUpdate_time(System.currentTimeMillis() + "");
            billDao.insertBill(bill);
        }
        jsonObject1.put("result", "1");
        return jsonObject1.toString();

    }

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "123awda";
    }

    //注册
    @OnlineMethod(memo = "注册", param = Data.getUserMessage, method = "post", url ="/insert", type = 1)
    @ResponseBody
    @RequestMapping("/insert")
    public String insertUserController(String json) {

//        String jsonObject = "{\"password\":\"123\",\"password_sec\":\"123\",\"username\":\"wer\"}";
//        System.out.println(jsonObject);
        User user = JSON.parseObject(json.toString(), User.class);
        user.setPassword(Md5.MD5(user.getPassword() + Data.Salt));
        User user1 = userdao.getUserMes(user.getUsername());
        JSONObject jsons = new JSONObject();
        if (user1 == null) {
            //注册
            userdao.insertUser(user);
            jsons.put("result", "1");
        } else {
            jsons.put("result", "0");
        }

        return jsons.toString();
    }


}
