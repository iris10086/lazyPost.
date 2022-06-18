package com.example.databasebigwork.service;


import com.example.databasebigwork.dao.UserMapper;
import com.example.databasebigwork.pojo.Result;
import com.example.databasebigwork.pojo.User;
import com.example.databasebigwork.pojo.UserAddress;
import com.example.databasebigwork.utils.IdGenerator;
import com.example.databasebigwork.utils.GetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    AddressService address;

    private Long MAX_HEAD = 2097152l;
    private  String HEAD_PATH = "/res/head/";
    private String DEFAULT_HEAD_URL = "/res/head/defaultjpg";
    private String HEAD_STORE_PATH = "D:/img/head";
    @Scheduled(fixedDelay = 1000)
    public void init(){
        File file = new File(HEAD_STORE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public Result userLogin(String phone,String password){
        Result result = new Result();
        String uid = userMapper.getUidByPhoneAndPassword(phone, password);
        if(uid!=null){
            User user = userMapper.getUserByUid(uid);
            user.setMyAddress(address.getList(uid));
            result.setUser(user);
            result.setStatus(1);
        }else {
            result.setStatus(0);
        }
        return result;
    }

    private boolean checkUserExists(String uid){
        User user = userMapper.getUserByUid(uid);
        if(user==null)return false;
        else return true;
    }

    private boolean checkCash(String phone,String password){
        return true;
    }

    private boolean checkPhoneExists(String phone){
        return userMapper.getUsernameByPhone(phone) != null;
    }

    // 校验用户合法
    private boolean checkUser(User user){
//        if(user!=null) {
//            if (user.getUsername() == null || user.getUsername().length() > 20) {
//                return false;
//            }
//            if (user.getPhone() == null) {
//                return false;
//            }
//            if (user.getDesc() == null || user.getDesc().length() > 200) {
//                return false;
//            }
//
//        }
//        if(password!=null)
//            if(password.isEmpty()||password.length()>16)
//                return false;

        return true;
    }

    public Result registerUser(User user){
        boolean flag = checkUser(user);
        if(!flag){
            return GetResult.failure(0,"用户名密码不合法");
        }if(checkPhoneExists(user.getPhone())){
            return GetResult.failure(0,"该手机号已被注册");
        } else  {
        Long id = idGenerator.incrementID(0);
        user.setUid(String.format("%012d",id));
        if(user.getHead()==null)user.setHead(DEFAULT_HEAD_URL);
        int res = userMapper.registerUser(user);
            if(res == 1) {
                return GetResult.success(1,user);
            }else if (res == 0)return GetResult.failure(0,"添加失败");
        }
        return GetResult.failure(0);
    }

    public Result userModify(User user){
        if(this.checkUserExists(user.getUid())) {
            int i = userMapper.userModify(user);
            user = userMapper.getUserByUid(user.getUid());
            if (i == 1) {
                return GetResult.success(1,user);
            }
        }
        return GetResult.failure(0);
    }

    public Result userDelete(String uid){
        int i = userMapper.userDelete(uid);
        if(i==1)return GetResult.success(1,null);
        else return GetResult.failure(0);
    }

    public Result modifyPassword(String uid,String newPassword,String oldPassword){
        boolean flag = checkUser(null);
        if(flag){
            int i = userMapper.modifyPassword(uid, newPassword, oldPassword);
            if(i == 1){
                return GetResult.success(1);
            }else {
                return GetResult.failure(0,"旧密码不正确");
            }
        }else {
            return GetResult.failure(0,"密码不合法");
        }
    }

    public User getUser(String uid){
        return userMapper.getUserByUid(uid);
    }

    public Result uploadHead(MultipartFile head, String uid,User user){
        if(head.getSize()>MAX_HEAD) return GetResult.failure(0,"头像过大");
        String originalFileName = head.getOriginalFilename();
        String type = "."+originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = uid+type;
        File file = new File(HEAD_STORE_PATH,fileName);
        try {
            head.transferTo(file);
            user.setHead(HEAD_PATH+fileName);
            int i = userMapper.userModify(user);
            if(i == 1)return GetResult.success(1,user);
        } catch (IOException e) {
            e.printStackTrace();
            return GetResult.failure(0,"上传失败");
        }
        return GetResult.failure(0);
    }
}
