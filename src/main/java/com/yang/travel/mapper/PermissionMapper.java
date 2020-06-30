package com.yang.travel.mapper;

import com.yang.travel.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限接口
 */
@Repository
@Mapper
public interface PermissionMapper {
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
