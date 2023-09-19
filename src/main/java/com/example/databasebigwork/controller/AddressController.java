package com.example.databasebigwork.controller;


import com.example.databasebigwork.pojo.Paddr;
import com.example.databasebigwork.pojo.Result;
import com.example.databasebigwork.pojo.User;
import com.example.databasebigwork.pojo.UserAddress;
import com.example.databasebigwork.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api()
@RestController
@RequestMapping("/addr")
public class AddressController {

    @Autowired
    AddressService addressService;

    @ApiOperation("获取地址列表")
    @GetMapping("/getlist/{uid}")
    public ArrayList<UserAddress> getList(@ApiParam("用户ID")@PathVariable("uid")String uid){
        return addressService.getList(uid);
    }

    @PostMapping("/add")
    public Result addAddress(@RequestBody UserAddress addr){
        return addressService.addAddress(addr);
    }

    @PostMapping("/modify")
    public Result modifyAddr(@RequestBody UserAddress addr){
        return addressService.modifyAddr(addr);
    }

    @GetMapping("/delete/{aid}")
    public Result deleteAddr(@PathVariable("aid") String aid){
        return addressService.deleteAddr(aid);
    }

    @PostMapping("/deleteaddrs")
    public Result deleteAddrs(@RequestBody ArrayList<String> aids){
        System.out.println("aids:"+aids);
        return addressService.deleteAddrs(aids);
    }


    @GetMapping("/paddrs")
    public ArrayList<Paddr> getPaddr(){
        return addressService.getPAddr();
    }
}
