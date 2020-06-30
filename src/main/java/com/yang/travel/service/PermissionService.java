package com.yang.travel.service;

import com.yang.travel.pojo.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAllPermission();
    //根据角色来查询权限
    public List<Permission> findPermissionByRoleId(Integer id);
    //添加权限
    public void savePermission(Permission permission);
    //按id查询
    public Permission findByPermissionId(Integer id);
    //删除权限
    public void deletePermissionById(Integer id);
    //删除角色权限
    public void deleteRolePermissionById(Integer roleid);
}
