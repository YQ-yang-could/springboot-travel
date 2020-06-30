package com.yang.travel.service;

import com.yang.travel.pojo.Orders;

import java.util.List;

public interface OrderService {
    public List<Orders> findAll();
    public Orders findById(Integer id);
}
