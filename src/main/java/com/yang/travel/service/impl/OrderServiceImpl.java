package com.yang.travel.service.impl;

import com.yang.travel.mapper.OrderMapper;
import com.yang.travel.pojo.Orders;
import com.yang.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Orders> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Orders findById(Integer id) {
        return orderMapper.findById(id);
    }
}
