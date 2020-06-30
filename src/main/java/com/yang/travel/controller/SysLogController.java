package com.yang.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.travel.pojo.SysLog;
import com.yang.travel.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Y_travel/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/findSysLogList")
    public String sysLogs(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                          Model model){
        PageHelper.startPage(pageNum,10);
        List<SysLog> sysLogAll = sysLogService.findSysLogAll();
        PageInfo<SysLog> pageInfo=new PageInfo<SysLog>(sysLogAll);
        model.addAttribute("syslogs",sysLogAll);
        model.addAttribute("pageInfo",pageInfo);
        return "/pages/syslog-list";
    }
}
