package com.save.dao;

import com.save.entity.Bill;
import com.save.util.DbFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wsdevotion on 15/10/14.
 */
@Service
public class BillDao extends DbFactory<Bill> {



    @Override
    public Bill get(int id) {
        return getDao().fetch(Bill.class, id);
    }

    //加入账单
    public Bill insertBill(Bill bill){
        return getDao().insert(bill);
    }


}
