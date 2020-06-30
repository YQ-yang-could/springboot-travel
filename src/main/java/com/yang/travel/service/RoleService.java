package com.yang.travel.service;

import com.yang.travel.pojo.Permission;
import com.yang.travel.pojo.Role;

import java.util.List;

public interface RoleService {
    //根据用户id查询对应拥有的角色
    public List<Role> findRoleByUserId(Integer userid);
    public List<Role> findAllRole();
    public Role findRoleById(Integer id);
    public void insertRole(Role role);
    //根据角色id查询权限
    public List<Permission> findOthersPermission(Integer roleid);
    //给角色添加权限
    public void addPermissionToRole(Integer roleId,Integer[] permissionId);
    public void deleteRoleById(Integer id);
    //根据角色id删除角色权限
    public void deleteFromRole_PermissionByRoleId(Integer roleId);
    //根据角色id删除用户
    public void deleteFromUser_RoleByRoleId(Integer roleId);

}
