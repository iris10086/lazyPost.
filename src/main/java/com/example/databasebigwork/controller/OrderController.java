package com.example.databasebigwork.controller;

import com.example.databasebigwork.pojo.Find;
import com.example.databasebigwork.pojo.Order;
import com.example.databasebigwork.pojo.Result;
import com.example.databasebigwork.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/orderlist/{page}")
    public ArrayList<Order> orderList(@PathVariable int page) {
        return orderService.orderList(page - 1);
    }

    @RequestMapping("/myorder/{uid}")
    public ArrayList<Order> myorders(@PathVariable("uid") String uid) {
        return orderService.myorders(uid);
    }

    @RequestMapping("/put")
    public Result put(@RequestBody Order order) {
        return orderService.put(order);
    }

    @RequestMapping("/delete/{oid}")
    public Result delete(@PathVariable("oid") String oid) {
        return orderService.delete(oid);
    }

    @RequestMapping("/modify")
    public Result modify(@RequestBody Order order) {
        return orderService.modify(order);
    }

    @RequestMapping("/get")
    public Result get(@RequestBody HashMap<String, String> ids) {
        String oid = ids.get("orderId");
        String uid = ids.get("issuerId");
        return orderService.get(oid, uid);
    }

    @RequestMapping("/finish/{oid}")
    public Result finish(@PathVariable("oid") String oid) {
        Result finish = orderService.finish(oid);
        if(finish.getStatus() ==1){
            finish.setOrder(orderService.getOrder(oid));
        }
        return finish;
    }

    @RequestMapping("/find/{page}")
    public ArrayList<Order> find(@RequestBody Find find,@PathVariable("page")Integer page){
        return orderService.find(find,page);
    }
//    @RequestMapping("/getorder/{oid}")
//    public Order getorder(@PathVariable("oid") String oid){
//        return orderService.getOrder(oid);
//    }
}
