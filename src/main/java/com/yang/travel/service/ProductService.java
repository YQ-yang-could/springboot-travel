package com.yang.travel.service;

import com.yang.travel.pojo.Product;

import java.util.List;

public interface ProductService {
    public Product findByProductId(Integer id);
    public List<Product> findAllProduct();
    public void insertProduct(Product product);
    public void deletsProduct(Integer id);
}
