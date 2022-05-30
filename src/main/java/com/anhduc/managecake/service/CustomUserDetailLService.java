package com.anhduc.managecake.service;

import com.anhduc.managecake.model.CustomUserDetail;
import com.anhduc.managecake.model.User;
import com.anhduc.managecake.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailLService implements UserDetailsService {

    @Autowired
    UserReponsitory userReponsitory;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userReponsitory.findUserByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("Khong tim thay user"));
        return user.map(CustomUserDetail::new).get();
    }
}
