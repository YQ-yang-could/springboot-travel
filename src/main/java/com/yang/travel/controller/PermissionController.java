package com.yang.travel.controller;

import com.yang.travel.pojo.Permission;
import com.yang.travel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Y_travel/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findPermissionList")
    public String findPermissionAll(Model model){
        List<Permission> permissionList = permissionService.findAllPermission();
        model.addAttribute("permissions",permissionList);
        return "/pages/permission-list";
    }
    @RequestMapping("/findById")
    public String findByPermissionId(@RequestParam(name = "id") Integer id,Model model){
        Permission permission = permissionService.findByPermissionId(id);
        model.addAttribute("permission",permission);
        return "/pages/permission-show";
    }
    @RequestMapping("/savePermission")
    public String insertPermission(Permission permission){
        permissionService.savePermission(permission);
        return "redirect:findAll";
    }
    @RequestMapping("deletePermission")
    public String deletePermission(Integer id){
        permissionService.deletePermissionById(id);
        return "redirect:findAll";
    }
}
