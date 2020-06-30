package com.yang.travel.mapper;

import com.yang.travel.pojo.Role;
import com.yang.travel.pojo.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserMapper {
    public List<UserInfo> findAll() throws Exception;
    public void insertUser(UserInfo userInfo) throws Exception;
    public UserInfo findById(Integer id)throws Exception;
    public List<Role> findOtherRoles(Integer userId);
    public void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer[] roleId);
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yang.travel.mapper.RoleMapper.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);
}
