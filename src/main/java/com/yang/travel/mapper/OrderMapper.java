package com.yang.travel.mapper;

import com.yang.travel.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
订单接口
 */
@Repository
@Mapper
public interface OrderMapper {
    public List<Orders> findAll();
    public Orders findById(Integer id);
}
