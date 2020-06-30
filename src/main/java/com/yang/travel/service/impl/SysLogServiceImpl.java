package com.yang.travel.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yang.travel.mapper.SysLogMapper;
import com.yang.travel.pojo.SysLog;
import com.yang.travel.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public List<SysLog> findSysLogAll() {
        return sysLogMapper.findSysLogAll();
    }

    @Override
    public void insert(SysLog sysLog) {
        sysLogMapper.insertSysLog(sysLog);
    }
}
