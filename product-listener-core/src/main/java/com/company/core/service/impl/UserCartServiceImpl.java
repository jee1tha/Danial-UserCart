package com.company.core.service.impl;

import com.company.core.model.UserCart;
import com.company.core.repository.UserCartRepository;
import com.company.core.service.UserCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserCartServiceImpl implements UserCartService {

    private static final Logger LOG = LoggerFactory.getLogger(UserCartServiceImpl.class);

    @Autowired
    private UserCartRepository userCartRepository;

    @Transactional // Add product ID corresponding to the User's ID
    public void addProductToUSerCar(String productId, String userID) {
        LOG.info("ProductID : {} UserID: {}",productId,userID);
        UserCart userCart = new UserCart();
        userCart.setProductId(productId);
        userCart.setUserId(userID);
        userCartRepository.save(userCart);
        LOG.info("Item added to user cart");
    }

    @Override // Get Products in User's card by userID
    public List<UserCart> getUserCart(String userId){
      return userCartRepository.findByUserId(userId);
    };
}
