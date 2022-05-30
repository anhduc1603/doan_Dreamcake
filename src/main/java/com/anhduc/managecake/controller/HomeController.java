package com.anhduc.managecake.controller;

import com.anhduc.managecake.global.GlobalData;
import com.anhduc.managecake.service.CategoryService;
import com.anhduc.managecake.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    //Cần xem xét
    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products",productService.getAllProduct());
         return "/index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProduct());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "home/shop";
    }


    @GetMapping("/shop/category/{id}")
    public String shopByCategory(@PathVariable int id, Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("products",productService.getAllProductCategoryId(id));
        return "home/shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(@PathVariable int id, Model model){
        model.addAttribute("product",productService.getProductById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "/home/viewProduct";
    }


}
