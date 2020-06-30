package com.yang.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.travel.pojo.Orders;
import com.yang.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Y_travel/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/findOrderList")
    public String findOrderAll(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,5);
        List<Orders> ordersList = orderService.findAll();
        PageInfo<Orders> pageInfo=new PageInfo<>(ordersList);
        model.addAttribute("orderlist",ordersList);
        model.addAttribute("orderpageInfo",pageInfo);
        return "/pages/orders-list";
    }
    @RequestMapping("/findById")
    public String findByOrderId(@RequestParam(name = "id") Integer id,Model model){
        Orders orders = orderService.findById(id);
        model.addAttribute("order",orders);
        return "/pages/order-list";
    }
}
