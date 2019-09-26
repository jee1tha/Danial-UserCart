package com.company.cart.listener;

import com.company.cart.constants.Constants;
import com.company.core.service.UserCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

@Component
public class ProductListener {
    private static final Logger LOG = LoggerFactory.getLogger(ProductListener.class);

    @Autowired
    UserCartService userCartService;

    @JmsListener(destination = "company.usercart.add", concurrency = "5")
    public void receiveUserCart(Message message) throws JMSException {
        String productid = null;
        String userid = null;
        if (message instanceof MapMessage) {
            final MapMessage mapTitleMessage = (MapMessage) message;
            productid = mapTitleMessage.getString(Constants.PRODUCT_ID);
            userid = mapTitleMessage.getString(Constants.USER_ID);
            LOG.debug("received message from Queue -> Product ID : {}  User ID : {} ",productid,userid);
            if (productid != "" && userid != "") {
                userCartService.addProductToUSerCar(productid, userid);
            }
        }
    }
}
