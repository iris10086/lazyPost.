package com.example.databasebigwork.dao;

import com.example.databasebigwork.pojo.Paddr;
import com.example.databasebigwork.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

@Mapper
public interface AddressMapper {
    public ArrayList<UserAddress> getList(@Param("uid")String uid);
    public int addAddress(@Param("addr")UserAddress addr);
    public int modifyAddr(@Param("addr")UserAddress addr);
    public int deleteAddr(@Param("aid")String aid);
    public int deleteAddrs(@Param("aids") ArrayList<String> aids);
    public ArrayList<Paddr> getPAddr();


}
