package com.yang.travel.service;

import com.yang.travel.pojo.Role;
import com.yang.travel.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserInfoService extends UserDetailsService{
    public void insertUser(UserInfo userInfo) throws Exception;
    List<UserInfo> findAll() throws Exception;
    public UserInfo findById(Integer id) throws Exception;
    public List<Role> findOtherRoles(Integer userId) throws Exception;
    public void addRoleToUser(Integer userId,Integer[] roleId);
}
