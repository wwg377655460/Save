package com.save.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.save.controller.base.BaseController;
import com.save.dao.TimeDao;
import com.save.entity.Time;
import com.save.util.Data;
import com.save.util.MathUtil;
import com.save.util.TimeUtil;
import com.save.util.TurnTypeNum;
import com.save.util.UrlUtils.OnlineMethod;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
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
    public String getMaxType(@RequestBody String jsonObject){
        Time time_a = JSON.parseObject(jsonObject.toString(), Time.class);
        int timeType = TimeUtil.turnTimeType(time_a.getTime());
        Time time_p = timeDao.getTimeByType(timeType + "");
        JSONObject json = new JSONObject();
        Map<Integer, Double> map_a = TurnTypeNum.turnType(time_a);
        Map<Integer, Double> map_p = TurnTypeNum.turnType(time_p);
//        Map<Integer, Double> map_f = new HashMap<Integer, Double>();
        Map<Integer, Double> map_f = MathUtil.getMap(timeType);
        int type = MathUtil.getMaxType(map_p, map_a, map_f);
        json.put("type", type);

        return json.toString();

    }
}
