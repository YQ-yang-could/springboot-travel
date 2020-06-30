package com.yang.travel.service.impl;

import com.yang.travel.mapper.ProductMapper;
import com.yang.travel.pojo.Product;
import com.yang.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findByProductId(Integer id) {
        return productMapper.findByProductId(id);
    }

    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }

    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    @Override
    public void deletsProduct(Integer id) {
        productMapper.deletsProduct(id);
    }
}
