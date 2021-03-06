package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.UserMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMenuMapper {
	/**
	 * 根据用户id查找，用户菜单信息
	 */
	public List<UserMenu> queryUserMenuByUserId(String userid);
	
	/**
	 * 添加用户、菜单关系
	 */
	public void insertUserMenu(UserMenu userMenu);
	
	/**
	 * 删除用户、菜单关系
	 */
	public void deleteUserMenuByUserId(String userid);
}
