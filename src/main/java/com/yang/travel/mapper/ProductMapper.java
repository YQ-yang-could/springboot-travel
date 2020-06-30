package com.yang.travel.mapper;

import com.yang.travel.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品接口
 */
@Repository
@Mapper
public interface ProductMapper {
    public Product findByProductId(Integer id);
    public List<Product> findAllProduct();
    public void insertProduct(Product product);
    public void deletsProduct(Integer id);
}
