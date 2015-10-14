package com.save.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.save.controller.base.BaseController;
import com.save.dao.BillDao;
import com.save.dao.UserDao;
import com.save.entity.Bill;
import com.save.entity.User;
import com.save.util.Data;
import com.save.util.Md5;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wsdevotion on 15/10/14.
 */
@Controller
public class UserController extends BaseController {

    @Resource
    UserDao userdao;

    @Resource
    BillDao billDao;

    //登录
    @ResponseBody
    @RequestMapping("/login")
    @Transactional(rollbackFor = {Exception.class})
    public String loginUserController(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject json = new JSONObject();
        String password_m = Md5.MD5(password + Data.Salt);
        User user = userdao.loginUser(username, password_m);
        if(user==null){
            json.put("result","0");
        }else{
            json.put("result","1");
        }

        return json.toString();
    }

    //获取用户信息
    @ResponseBody
    @RequestMapping("/getUserMessage")
    @Transactional(rollbackFor = {Exception.class})
    public String getUserMes(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        User user = userdao.getUserMes(username);
        String json = JSON.toJSONString(user);
        return json;
    }

    //上传用户信息
    @ResponseBody
    @RequestMapping("/updateUserMessage")
    @Transactional(rollbackFor = {Exception.class})
    public String updateUserMes(@RequestBody JSONObject jsonObject){
        User user = JSON.parseObject(jsonObject.toString(), User.class);
        JSONObject jsonObject1 = new JSONObject();
        userdao.insertUser(user);
        List<Bill> bills = user.getBills();
        for(Bill bill : bills){
            billDao.insertBill(bill);
        }
        jsonObject1.put("result","1");
        return jsonObject1.toString();

    }

    //注册
    @ResponseBody
    @RequestMapping("/insert")
    @Transactional(rollbackFor = {Exception.class})
    public String insertUserController(@RequestBody JSONObject jsonObject){
        User user = JSON.parseObject(jsonObject.toString(), User.class);
        User user1 = userdao.getUserMes(user.getUsername());
        JSONObject json = new JSONObject();
        if(user1==null){
            //注册
            User user_new = userdao.insertUser(user);
            json.put("result","1");
        }else{
            json.put("result","0");
        }

        return json.toString();
    }

}
