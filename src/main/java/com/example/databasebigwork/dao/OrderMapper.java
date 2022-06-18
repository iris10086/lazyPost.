package com.example.databasebigwork.dao;

import com.example.databasebigwork.pojo.Find;
import com.example.databasebigwork.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Mapper
public interface OrderMapper {
    ArrayList<Order> orderList(@Param("page") int page);
    ArrayList<Order> myorders(String uid);
    int put(Order order);
    int delete(String oid);
    int modify(Order order);
    int get(@Param("oid") String oid,@Param("uid") String uid);
    int finish(String oid);
    Order getOrder(String oid);
    int addCoinTo(@Param("uid") String uid,@Param("coin") int coin);
    Integer getSumCoin(String uid);
    public ArrayList<Order> find(@Param("find") Find find,@Param("page") int page);
}
