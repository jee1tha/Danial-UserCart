package com.company.core;

import com.company.core.model.UserCart;
import com.company.core.service.UserCartService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = CoreApplication.class)
@Transactional
@RunWith(SpringRunner.class)
public class Test {

    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    @Autowired
    UserCartService  userCartService;


    @org.junit.Test
    public void testBuildTitle() throws Exception{
        userCartService.addProductToUSerCar("productID001","UserId001");
        List<UserCart> userCartList = userCartService.getUserCart("UserId001");
        for(UserCart usercart: userCartList){
            LOG.info(usercart.getId());
            LOG.info(usercart.getProductId());
            LOG.info(usercart.getUserId());
        }
    }
}
