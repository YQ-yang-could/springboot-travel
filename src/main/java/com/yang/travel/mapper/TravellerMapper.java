package com.yang.travel.mapper;

import com.yang.travel.pojo.Traveller;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TravellerMapper {
    //根据订单查询游客信息
    public List<Traveller> findByOrderId(Integer id);
}
