package com.example.databasebigwork.service;


import com.example.databasebigwork.dao.OrderMapper;
import com.example.databasebigwork.pojo.Find;
import com.example.databasebigwork.pojo.Order;
import com.example.databasebigwork.pojo.Result;
import com.example.databasebigwork.utils.GetResult;
import com.example.databasebigwork.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;


@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    IdGenerator getId;

    public ArrayList<Order> orderList(int page) {
        System.out.println("list method ...");
        return orderMapper.orderList(page * 10);
    }

    public ArrayList<Order> myorders(String uid) {
        return orderMapper.myorders(uid);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Result put(Order order) {
        Result r = addCoinTo(order.getSuid(), order.getCoin());
        if (r.getStatus() == 0) return r;
        order.setOid(String.format("%012d", getId.incrementID(1)));
        order.setStime(new Date());
        order.setStatus(1);
        int i = orderMapper.put(order);
        if (i == 1) return GetResult.success(1);
        else return GetResult.failure(0);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Result delete(String oid) {
        Order order = orderMapper.getOrder(oid);
        addCoinTo(order.getSuid(), order.getCoin() * -1);
        int i = orderMapper.delete(oid);
        if (i == 1) return GetResult.success(1);
        else return GetResult.failure(0);
    }

    public Result modify(Order order) {
        orderMapper.modify(order);
        return null;
    }

    public Result get(String oid, String uid) {
        int i = orderMapper.get(oid,uid);
        if (i == 1) return GetResult.success(1);
        else return GetResult.failure(0);
    }

    public Order getOrder(String oid) {
        return orderMapper.getOrder(oid);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Result addCoinTo(String uid, int coin) {
        Integer sumCoin = orderMapper.getSumCoin(uid);
        if (sumCoin == null) return GetResult.failure(0, "用户不存在");
        if (coin > sumCoin) {
            return GetResult.failure(0, "积分不足");
        }
//        orderMapper.addCoinTo(uid,Integer.parseInt(sumCoin) - coin);
        orderMapper.addCoinTo(uid, sumCoin - coin);
        return GetResult.success(1);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Result finish(String oid) {
        Order o = orderMapper.getOrder(oid);
        addCoinTo(o.getRuid(), o.getCoin() * -1);
        int i = orderMapper.finish(oid);
        if (i == 1) return GetResult.success(1);
        else GetResult.failure(0);
        return null;
    }

    public ArrayList<Order> find(Find find,int page){
        System.out.println("find method ...");
        return orderMapper.find(find,(page-1)*10);
    }
}
