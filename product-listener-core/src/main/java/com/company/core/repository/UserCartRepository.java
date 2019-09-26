package com.company.core.repository;


import com.company.core.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCartRepository extends JpaRepository<UserCart, String> {
    List<UserCart> findByUserId(String userId);
}
