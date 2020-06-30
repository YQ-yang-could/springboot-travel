package com.yang.travel.controller;

import com.yang.travel.pojo.Role;
import com.yang.travel.pojo.UserInfo;
import com.yang.travel.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/Y_travel/users")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/findUserList")
    public String findUserList(Model model) throws Exception {
        Collection<UserInfo> userInfos=userInfoService.findAll();
        model.addAttribute("users",userInfos);
        return "/pages/user-list";

    }

    @RequestMapping("findByUserId")
    public String findByUserId(Integer id,Model model) throws Exception {
        UserInfo userInfo=userInfoService.findById(id);
        model.addAttribute("userInfo",userInfo);
        return "/pages/user-show1";
    }
    @RequestMapping("/saveuser")
    public String save(UserInfo userInfo) throws Exception{
        userInfoService.insertUser(userInfo);
        return "redirect:findUserList";
    }
    //给用户添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) Integer userId, @RequestParam(name = "ids", required = true) Integer[] roleIds) {
        userInfoService.addRoleToUser(userId, roleIds);
        return "redirect:findUserList";
    }

    //查询用户以及用户可以添加的角色
//    @RequestMapping("/findUserByIdAndAllRole")
//    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) Integer userid) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        //1.根据用户id查询用户
//        UserInfo userInfo = userInfoService.findById(userid);
//        //2.根据用户id查询可以添加的角色
//        List<Role> otherRoles = userInfoService.findOtherRoles(userid);
//        mv.addObject("user", userInfo);
//        mv.addObject("roleList", otherRoles);
//        mv.setViewName("user-role-add");
//        return mv;
//    }
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndRole(@RequestParam(name = "id") Integer userid,Model model) throws Exception {
        UserInfo userInfo=userInfoService.findById(userid);
        List<Role> roles=userInfoService.findOtherRoles(userid);
        model.addAttribute("user",userInfo);
        model.addAttribute("user-roleList",roles);
        return "/pages/user-role-add";
    }
}
