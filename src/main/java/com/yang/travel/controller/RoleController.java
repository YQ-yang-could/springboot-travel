package com.yang.travel.controller;

import com.yang.travel.pojo.Permission;
import com.yang.travel.pojo.Role;
import com.yang.travel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Y_travel/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findroleList")
    public String findRoleAll(Model model){
        List<Role> roleList=roleService.findAllRole();
        model.addAttribute("roleList",roleList);
        return "/pages/role-list";
    }
    @RequestMapping("/saveRole")
    public String saveRole(Role role){
        roleService.insertRole(role);
        return "redirect:roleAll";
    }
    @RequestMapping("/deleteRole")
    public String deleteRole(Integer id){
        roleService.deleteRoleById(id);
        return "redirect:roleAll";
    }
    @RequestMapping("/findByRoleId")
    public String findByRoleId(@RequestParam(name = "id")Integer id,Model model){
        Role role = roleService.findRoleById(id);
        model.addAttribute("role",role);
        return "/pages/role-show";
    }
    public String findRoleByUserId(@RequestParam(name = "userid") int id,Model model){
        List<Role> role = roleService.findRoleByUserId(id);
        model.addAttribute("roleByUserId",role);
        return "";
    }
    public String findPermissionByRoleId(@RequestParam(name = "roleid") Integer id,Model model){
        List<Permission> rolePermission = roleService.findOthersPermission(id);
        model.addAttribute("rolePermission",rolePermission);
        return "";
    }
    public String addPermissionByRole(Integer roleid,Integer[]permmissionId){
        roleService.addPermissionToRole(roleid,permmissionId);
        return "";
    }
    public String deletePermissionByRole(Integer id){
        roleService.deleteFromRole_PermissionByRoleId(id);
        return "redirect:findByRoleId";
    }

}
