package com.yang.travel.service.impl;

import com.yang.travel.mapper.TravellerMapper;
import com.yang.travel.pojo.Traveller;
import com.yang.travel.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravellerImplServiceImpl implements TravellerService {
    @Autowired
    private TravellerMapper travellerMapper;
    @Override
    public List<Traveller> findByOrderId(Integer id) {
        return travellerMapper.findByOrderId(id);
    }
}
