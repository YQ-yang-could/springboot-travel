package com.yang.travel.controller;

import com.yang.travel.pojo.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class IndexController {
    @RequestMapping("/Y_travel/users/toinsertUser")
    public String toinsertuser(){
        return "/pages/user-add";
    }
    @RequestMapping("/Y_travel/product/tosaveProduct")
    public String toinsertProduct(){
        return "/pages/product-add";
    }
    @RequestMapping("/Y_travel/role/tosaveRole")
    public String toinsertRole(){
        return "/pages/role-add";
    }
    @RequestMapping("/login")
    public String toLogin(){
        return "all-admin-login";
    }
//    @GetMapping("/main.html")
//    public String main(Model model, HttpSession session){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if("anonymousUser".equals(principal)) {
//            model.addAttribute("name","anonymous");
//        }else {
//            User user = (User)principal;
//            model.addAttribute("name",user.getUsername());
//            session.setAttribute("user",user.getUsername());
//        }
//        return "all-admin-index";
//    }
}
