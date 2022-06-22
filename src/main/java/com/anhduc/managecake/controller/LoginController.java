package com.anhduc.managecake.controller;

import com.anhduc.managecake.global.GlobalData;
import com.anhduc.managecake.model.Role;
import com.anhduc.managecake.model.User;
import com.anhduc.managecake.reponsitory.RoleReponsitory;
import com.anhduc.managecake.reponsitory.UserReponsitory;
import com.anhduc.managecake.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller

public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserReponsitory userReponsitory;
    @Autowired
    RoleReponsitory roleReponsitory;

    @Autowired
    UserSerivce userSerivce;

    @GetMapping("/login")
    public String login(Model model){
        GlobalData.cart.clear();

        return "/account/login";
    }


    @GetMapping("/register")
    public String registerGet(){
        return "/account/register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user")User user,HttpServletRequest request)
            throws ServletException {
            String password = user.getPassword();
            user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleReponsitory.findById(1).get());
        user.setRoles(roles);
        userReponsitory.save(user);
//        request.login(user.getEmail(), password);
        return "redirect:/shop";
    }

}
