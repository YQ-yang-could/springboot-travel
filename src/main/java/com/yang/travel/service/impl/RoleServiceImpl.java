package com.yang.travel.service.impl;

import com.yang.travel.mapper.RoleMapper;
import com.yang.travel.pojo.Permission;
import com.yang.travel.pojo.Role;
import com.yang.travel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findRoleByUserId(Integer userid) {
        return roleMapper.findRoleByUserId(userid);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleMapper.findRoleById(id);
    }

    @Override
    public void insertRole(Role role) {
        roleMapper.insertRole(role);
    }

    @Override
    public List<Permission> findOthersPermission(Integer roleid) {
        return roleMapper.findOthersPermission(roleid);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionId) {
        roleMapper.addPermissionToRole(roleId,permissionId);
    }

    @Override
    public void deleteRoleById(Integer id) {
        roleMapper.deleteRoleById(id);
    }

    @Override
    public void deleteFromRole_PermissionByRoleId(Integer roleId) {
        roleMapper.deleteFromRole_PermissionByRoleId(roleId);
    }

    @Override
    public void deleteFromUser_RoleByRoleId(Integer roleId) {
        roleMapper.deleteFromUser_RoleByRoleId(roleId);
    }
}
