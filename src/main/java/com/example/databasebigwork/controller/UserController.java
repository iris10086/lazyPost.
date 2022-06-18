package com.example.databasebigwork.controller;


import com.example.databasebigwork.pojo.Result;
import com.example.databasebigwork.pojo.User;
import com.example.databasebigwork.service.UserService;
import com.example.databasebigwork.utils.GetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * 登录逻辑
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AddressController address;

    @RequestMapping("/test")
    public String test(){
        return "This is a test...";
    }

    @RequestMapping("/register")
    public Result userRegister(@RequestBody User user, HttpServletRequest request){
        Result result = userService.registerUser(user);
        if(result.getUser()!=null){
            request.getSession().setAttribute("user",result.getUser());
        }
        return result;
    }

    @RequestMapping("/login")
    public Result userLogin(@RequestBody User user,HttpServletRequest request){
        String phone = user.getPhone();
        String password = user.getPassword();
        Result result = userService.userLogin(phone,password);
        if(result.getUser()!=null){
            request.getSession().setAttribute("user",result.getUser());
        }
        return result;
    }

    @RequestMapping("/delete/{uid}")
    public Result userDelete(@PathVariable("uid")String uid){
        return userService.userDelete(uid);
    }

    @RequestMapping("/modify")
    public Result userModify(@RequestBody User user){
        Result result = userService.userModify(user);
        return result;
    }

    @RequestMapping("/uploadhead/{uid}")
    public Result uploadhead(@RequestParam("head") MultipartFile head,@PathVariable("uid") String uid,
                             HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return userService.uploadHead(head,uid,user);
    }

    @RequestMapping("/modifypassword")
    public Result modifyPassword(@RequestBody Map<String,String> map){
        String newpassword = map.get("newpassword");
        String oldpassword = map.get("oldpassword");
        String uid = map.get("uid");
        return userService.modifyPassword(uid,newpassword,oldpassword);
    }

    @RequestMapping("/get/{uid}")
    public User getUser(@PathVariable("uid")String uid){
        return userService.getUser(uid);
    }

    @RequestMapping("/mydetail/{uid}")
    public Result mydetail(@PathVariable("uid") String uid){
        return GetResult.success(1,userService.getUser(uid));
    }


}
