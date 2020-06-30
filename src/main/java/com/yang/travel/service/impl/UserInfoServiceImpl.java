package com.yang.travel.service.impl;

import com.yang.travel.mapper.UserMapper;
import com.yang.travel.pojo.Role;
import com.yang.travel.pojo.UserInfo;
import com.yang.travel.service.RoleService;
import com.yang.travel.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service()
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void insertUser(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        mapper.insertUser(userInfo);
    }

    @Override
    public List<UserInfo> findAll() throws Exception {
        return mapper.findAll();
    }

    @Override
    public UserInfo findById(Integer id) throws Exception {
        return mapper.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(Integer userId) throws Exception {
        return mapper.findOtherRoles(userId);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] roleId) {
        mapper.addRoleToUser(userId,roleId);
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        UserInfo user = mapper.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        for (Role role:user.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        User userdateils=new User(user.getUsername(),user.getPassword(),authorities);
        return userdateils;
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserInfo userInfo = null;
//        try {
//            userInfo = mapper.findByUsername(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //处理自己的用户对象封装成UserDetails
//        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
//        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
//        return user;
//    }
//
//    //作用就是返回一个List集合，集合中装入的是角色描述
//    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
//
//        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        for (Role role : roles) {
//            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//        }
//        return list;
//    }
}
