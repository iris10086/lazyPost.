package com.example.databasebigwork.controller;


import com.example.databasebigwork.pojo.Paddr;
import com.example.databasebigwork.pojo.Result;
import com.example.databasebigwork.pojo.User;
import com.example.databasebigwork.pojo.UserAddress;
import com.example.databasebigwork.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/addr")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("/getlist/{uid}")
    public ArrayList<UserAddress> getList(@PathVariable("uid")String uid){
        return addressService.getList(uid);
    }

    @RequestMapping("/add")
    public Result addAddress(@RequestBody UserAddress addr){
        return addressService.addAddress(addr);
    }

    @RequestMapping("/modify")
    public Result modifyAddr(@RequestBody UserAddress addr){
        return addressService.modifyAddr(addr);
    }

    @RequestMapping("/delete/{aid}")
    public Result deleteAddr(@PathVariable("aid") String aid){
        return addressService.deleteAddr(aid);
    }

    @RequestMapping("/deleteaddrs")
    public Result deleteAddrs(@RequestBody ArrayList<String> aids){
        System.out.println("aids:"+aids);
        return addressService.deleteAddrs(aids);
    }


    @RequestMapping("/paddrs")
    public ArrayList<Paddr> getPaddr(){
        return addressService.getPAddr();
    }
}
