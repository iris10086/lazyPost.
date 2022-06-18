package com.example.databasebigwork.utils;

import com.example.databasebigwork.pojo.Result;
import com.example.databasebigwork.pojo.User;

public class GetResult {
    private GetResult(){}
    public static Result success(int status, User user){
        Result result = new Result();
        result.setStatus(status);
        result.setUser(user);
        return result;
    }
    public static Result success(int status){
        return success(status,null);
    }

    public static Result failure(int status){
        Result result = new Result();
        result.setStatus(status);
        return result;
    }

    public static Result failure(int status,String msg){
        Result failure = failure(status);
        failure.setMsg(msg);
        return failure;
    }
}
