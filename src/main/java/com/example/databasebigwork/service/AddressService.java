package com.example.databasebigwork.service;

import com.example.databasebigwork.dao.AddressMapper;
import com.example.databasebigwork.pojo.Paddr;
import com.example.databasebigwork.pojo.Result;
import com.example.databasebigwork.pojo.User;
import com.example.databasebigwork.pojo.UserAddress;
import com.example.databasebigwork.utils.GetResult;
import com.example.databasebigwork.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    IdGenerator idGenerator;

    public ArrayList<UserAddress> getList(String uid){
        return addressMapper.getList(uid);
    }

    public Result addAddress(UserAddress addr){
        addr.setAid(String.format("%012d",idGenerator.incrementID(2)));
        int i = addressMapper.addAddress(addr);
        if(i == 1){
            return GetResult.success(1);
        }else return GetResult.failure(0);
    }

    public Result modifyAddr(UserAddress addr){
        int i = addressMapper.modifyAddr(addr);
        if(i == 1) return GetResult.success(1);
        else return GetResult.failure(0);
    }

    public Result deleteAddr(String aid){

        int i = addressMapper.deleteAddr(aid);
        if(i == 1)return GetResult.success(1);
        else return GetResult.failure(0);
    }

    public Result deleteAddrs( ArrayList<String> aid){
        aid = (ArrayList<String>) aid.stream().distinct().collect(Collectors.toList());
        int i = addressMapper.deleteAddrs(aid);
        if(i == aid.size())return GetResult.success(1);
        else return GetResult.failure(0);
    }

    public ArrayList<Paddr> getPAddr(){
        return addressMapper.getPAddr();
    }
}
