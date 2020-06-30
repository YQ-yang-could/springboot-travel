package com.yang.travel.mapper;

import com.yang.travel.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysLogMapper {
    public List<SysLog> findSysLogAll();
    public void insertSysLog(SysLog sysLog);
}
