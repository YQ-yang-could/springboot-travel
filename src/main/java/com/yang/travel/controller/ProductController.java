package com.yang.travel.controller;

import com.yang.travel.pojo.Product;
import com.yang.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Y_travel/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/saveProduct")
    public String saveProduct(Product product){
        productService.insertProduct(product);
        return "redirect:findProductList";
    }
    @RequestMapping("/deleteProduct")
    public String deleteProduct(Integer id){
        productService.deletsProduct(id);
        return "redirect:findProductList";
    }
    @RequestMapping("/findProductList")
    public String findAllProduct(Model model){
        List<Product> productList = productService.findAllProduct();
        model.addAttribute("products",productList);
        return "/pages/product-list1";
    }
    @RequestMapping("/findById")
    public String findByProducyId(@RequestParam(name = "id") Integer id,Model model){
        Product product = productService.findByProductId(id);
        model.addAttribute("product",product);
        return "/pages/product-show";
    }
}
