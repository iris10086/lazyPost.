package com.example.databasebigwork.dao;


import com.example.databasebigwork.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public String getUsernameByPhone(@Param("phone") String phone);
    public int registerUser(@Param("user")User user);
    public User getUserByUid(@Param("uid") String uid);
    public String getUidByPhoneAndPassword(@Param("phone")String phone,@Param("password")String password);
    public int userModify(@Param("user")User user);
    public int userDelete(@Param("uid")String uid);
    public int modifyPassword(@Param("uid")String uid,@Param("password")String newpassword,@Param("old") String oldpassword);
}
