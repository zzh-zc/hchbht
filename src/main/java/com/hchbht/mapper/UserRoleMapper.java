package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
	
	/**
	 * 根据用户id查找相对应的用户角色信息
	 */
	public List<UserRole> queryUserRoleByUserId(String userid);
	
	/**
	 * 添加用户角色
	 */
	public void insertUserRole(UserRole ur);
	
	/**
	 * 根据用户id，删除用户角色
	 */
	public void deleteUserRoleByUserId(String userid);
}
