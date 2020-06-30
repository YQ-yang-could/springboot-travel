package com.yang.travel.mapper;

import com.yang.travel.pojo.Permission;
import com.yang.travel.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色接口
 */
@Repository
@Mapper
public interface RoleMapper {
    //根据用户id查询对应拥有的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yang.travel.mapper.PermissionMapper.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(Integer userid);
    public List<Role> findAllRole();
    public Role findRoleById(Integer id);
    public void insertRole(Role role);
    //根据角色id查询权限
    public List<Permission> findOthersPermission(Integer roleid);
    //给角色添加权限
    public void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer[] permissionId);
    public void deleteRoleById(Integer id);
    //根据角色id删除角色权限
    public void deleteFromRole_PermissionByRoleId(Integer roleId);
    //根据角色id删除用户
    public void deleteFromUser_RoleByRoleId(Integer roleId);

}
