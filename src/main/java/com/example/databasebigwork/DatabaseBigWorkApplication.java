package com.example.databasebigwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;



import java.util.Map;

@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.databasebigwork.dao")
public class DatabaseBigWorkApplication {
    public static void main(String[] args) {
        // SpringApplication.run(DatabaseBigWorkApplication.class, args);

        ConfigurableApplicationContext applicationContext = SpringApplication.run(DatabaseBigWorkApplication.class, args);
//        AbstractHandlerMethodMapping<RequestMappingInfo> objHandlerMethodMapping = (AbstractHandlerMethodMapping<RequestMappingInfo>)applicationContext.getBean(RequestMappingHandlerMapping.class  );
//        Map<RequestMappingInfo, HandlerMethod> mapRet = objHandlerMethodMapping.getHandlerMethods();
//        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry:
//        mapRet.entrySet()) {
//            System.out.println("key"+entry.getKey()+"  value:"+entry.getValue());
//        }
    }

}
