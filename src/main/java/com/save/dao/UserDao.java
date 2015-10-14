package com.save.dao;

import com.save.entity.Bill;
import com.save.entity.User;
import com.save.util.DbFactory;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wsdevotion on 15/10/14.
 */
@Service
public class UserDao extends DbFactory<User> {

    @Override
    public User get(int id) {
        return getDao().fetch(User.class, id);
    }

    //获取用户信息
    public User getUserMes(String username) {
        return getDao().fetch(User.class, username);
    }

    //获取用户账户信息
    public List<Bill> getUserBill(String username){
        User user = getDao().fetch(User.class, username);
        return getDao().fetchLinks(user, "bills").getBills();
    }

    //更新用户信息
    public int updateUser(User user){
        return getDao().update(user);
    }

    //更新用户信息
    public

    //注册
    public User insertUser(User user){
        return getDao().insert(user);
    }

    //判断是否能登录
    public User loginUser(String username, String password){
        List<User> list = getDao().query(User.class, Cnd.where("username","=",username).and("password", "=", password));
        if(list.size()==0){
            return null;
        }else{
            return list.get(0);
        }
    }


}
