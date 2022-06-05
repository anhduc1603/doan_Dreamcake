package com.anhduc.managecake.service;

import com.anhduc.managecake.model.Product;
import com.anhduc.managecake.model.User;
import com.anhduc.managecake.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSerivce {
    @Autowired
    UserReponsitory userReponsitory;

    public Optional<User> getProductById(int id){
        return userReponsitory.findById(id);
    }
}
