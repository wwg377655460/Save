package com.save.entity;

import org.nutz.dao.entity.annotation.*;

import java.util.List;

/**
 * Created by wsdevotion on 15/10/14.
 */
@Table("s_user")
public class User {
    @Id
    private int id;
    @Name
    private String username;
    @Column
    private String password;
    @Column
    private String password_sec;


    @Many(target = Bill.class, field = "user_id")
    private List<Bill> bills;

    @Column
    private Double pay_money_bef;
    @Column
    private Double get_money_bef;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_sec() {
        return password_sec;
    }

    public void setPassword_sec(String password_sec) {
        this.password_sec = password_sec;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Double getPay_money_bef() {
        return pay_money_bef;
    }

    public void setPay_money_bef(Double pay_money_bef) {
        this.pay_money_bef = pay_money_bef;
    }

    public Double getGet_money_bef() {
        return get_money_bef;
    }

    public void setGet_money_bef(Double get_money_bef) {
        this.get_money_bef = get_money_bef;
    }
}
