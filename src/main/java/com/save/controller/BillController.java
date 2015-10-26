package com.save.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.save.controller.base.BaseController;
import com.save.dao.TimeDao;
import com.save.entity.Time;
import com.save.util.*;
import com.save.util.UrlUtils.OnlineMethod;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wsdevotion on 15/10/15.
 */
@Controller
public class BillController extends BaseController{

    @Resource
    TimeDao timeDao;

    //获取最可能的类型
    @OnlineMethod(memo = "获取最可能的类型", param = "", method = "post", url ="/getMaxType", type = 1)
    @ResponseBody
    @RequestMapping("/getMaxType")
    @Transactional(rollbackFor = {Exception.class})
    public String getMaxType(String json){
        JSONObject jsonObject = isSecUtil.isSecMes(json);
        JSONObject jsons = new JSONObject();
        //如果判断加密信息不正确返回0
        if(jsonObject==null){
            jsons.put("status","0");
            return jsons.toString();
        }
//        JSONObject jsons = new JSONObject();
        Time time_a = JSON.parseObject(json.toString(), Time.class);
//        int timeType = TimeUtil.turnTimeType(time_a.getTime());
        int timeType = Integer.parseInt(time_a.getTime());
        Time time_p = timeDao.getTimeByType(timeType + "");
        Map<Integer, Double> map_a = TurnTypeNum.turnType(time_a);
        Map<Integer, Double> map_p = TurnTypeNum.turnType(time_p);
//        Map<Integer, Double> map_f = new HashMap<Integer, Double>();
//        Map<Integer, Double> map_f = MathUtil.getMap(timeType);
        Map<Integer, Double> map_f = TurnTypeNum.turnType(Data.times[timeType]);
        int type = MathUtil.getMaxType(map_p, map_a, map_f);
        jsons.put("type", type);
        jsons.put("result","1");

        return jsons.toString();

    }

    @RequestMapping("/setMes")
    public String setMes(Model model){
        Time [] time = Data.times;
        model.addAttribute("time", time);
        return "home";
    }
}
