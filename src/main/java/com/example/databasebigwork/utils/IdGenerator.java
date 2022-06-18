package com.example.databasebigwork.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String USER_ID_KEY = "id:user";
    private static final String ORDER_ID_KEY = "id:order";
    private static final String ADDR_ID_KEY = "id:addr";

    /**
     * 生成唯一ID
     * @param mode 0,1,2 分别表示 userid, orderid, addrid
     * @return
     */
    public Long incrementID(int mode){
        String id = null;
        switch (mode){
            case 0:id = this.USER_ID_KEY;break;
            case 1:id = this.ORDER_ID_KEY;break;
            case 2:id = this.ADDR_ID_KEY;break;
        }
        Long n = this.redisTemplate.opsForValue().increment(id);
        return n;
    }
}
