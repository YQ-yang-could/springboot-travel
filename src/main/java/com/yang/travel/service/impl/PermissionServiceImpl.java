package com.yang.travel.service.impl;

import com.yang.travel.mapper.PermissionMapper;
import com.yang.travel.pojo.Permission;
import com.yang.travel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAllPermission() {
        return permissionMapper.findAllPermission();
    }

    @Override
    public List<Permission> findPermissionByRoleId(Integer id) {
        return permissionMapper.findPermissionByRoleId(id);
    }

    @Override
    public void savePermission(Permission permission) {
        permissionMapper.savePermission(permission);
    }

    @Override
    public Permission findByPermissionId(Integer id) {
        return permissionMapper.findByPermissionId(id);
    }

    @Override
    public void deletePermissionById(Integer id) {
        permissionMapper.deletePermissionById(id);
    }

    @Override
    public void deleteRolePermissionById(Integer roleid) {
        permissionMapper.deleteRolePermissionById(roleid);
    }
}
