package com.anhduc.managecake.controller;

import com.anhduc.managecake.global.GlobalData;
import com.anhduc.managecake.model.Product;
import com.anhduc.managecake.model.User;
import com.anhduc.managecake.reponsitory.UserReponsitory;
import com.anhduc.managecake.service.CategoryService;
import com.anhduc.managecake.service.ProductService;
import com.anhduc.managecake.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @Autowired
    UserSerivce userSerivce;


    //Cần xem xét
    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products",productService.getAllProduct());
        String contex =  SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user",contex);
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProduct());
        model.addAttribute("cartCount",GlobalData.cart.size());
        String contex =  SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user",contex);
        return "index";
    }


    @GetMapping("/shop/category/{id}")
    public String shopByCategory(@PathVariable int id, Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("products",productService.getAllProductCategoryId(id));
        String contex =  SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user",contex);
        return "home/listdetail";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(@PathVariable int id, Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("product",productService.getProductById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        String contex =  SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user",contex);
        return "/home/detail";

    }

    @GetMapping("/shop/view/{id}")
    public String viewProductTest(@PathVariable int id, Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("product",productService.getProductById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        String contex =  SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user",contex);
        return "/home/viewProduct";

    }

    @GetMapping("/product/search")
    public String searchProductByName(@RequestParam(name = "name",required = true) String name, Model model){
        String contex =  SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user",contex);
        List<Product> list= null;
        if(StringUtils.hasText(name)){
            list = productService.getAllProductByName(name);
        }else {
            list = productService.getAllProduct();

        }
        model.addAttribute("product",list);
        return "/home/searchresult";
    }

    @GetMapping("/shop/khuyenmai")
    public String khuyenMai(){
        return "/home/khuyenmai";
    }

}
