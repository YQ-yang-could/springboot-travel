package com.yang.travel.service;

import com.github.pagehelper.Page;
import com.yang.travel.pojo.SysLog;

import java.util.List;

public interface SysLogService {
    public List<SysLog> findSysLogAll();
    public void insert(SysLog sysLog);
}
