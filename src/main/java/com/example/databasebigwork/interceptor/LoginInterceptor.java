package com.example.databasebigwork.interceptor;

import com.example.databasebigwork.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        User user = (User) request.getSession().getAttribute("user");
        return user == null;
    }
}
