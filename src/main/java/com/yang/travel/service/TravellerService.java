package com.yang.travel.service;

import com.yang.travel.pojo.Traveller;

import java.util.List;

public interface TravellerService {
    public List<Traveller> findByOrderId(Integer id);
}
