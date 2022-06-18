package com.example.databasebigwork;

import com.example.databasebigwork.dao.OrderMapper;
import com.example.databasebigwork.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DAOTest {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderService orderService;

    @Test
    public void getSumCoinTest(){
        System.out.println(orderMapper.getSumCoin("202252700012"));
        orderService.addCoinTo("202252700012",20);
    }
}
