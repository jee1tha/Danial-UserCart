package com.company.core.service;

import com.company.core.model.UserCart;

import java.util.List;

public interface UserCartService {

    void addProductToUSerCar(String productId,String userID);
    List<UserCart> getUserCart(String userId);
}
