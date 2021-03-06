package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.Role;

public interface RoleMapper {
	
	/**
	 * 添加角色
	 */
	public void insertRole(Role role);
	
	/**
	 * 修改角色
	 */
	public void updateRole(Role role);
	
	/**
	 * 删除角色
	 */
	public void deleteRole(String id);
	
	/**
	 * 根据id查找角色
	 */
	public Role queryRoleById(String id);
	
	/**
	 * 查询所有角色
	 */
	public List<Role> queryALLRole();
	
	/**
	 * 根据userID查找相应的角色
	 */
	public Role queryRoleByUserId(String userid);
}
