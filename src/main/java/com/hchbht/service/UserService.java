package com.hchbht.service;

import javax.servlet.http.HttpSession;

import com.hchbht.model.TjHchbdbUser;

public interface UserService {
	
	/**
	 * 登录
	 */
	public Object login(String username, String password,HttpSession session);
	
	/**
	 * 注销
	 */
	public Object logout(HttpSession session);
	
	/**
	 * 添加用户
	 */
	public Object insertUser(TjHchbdbUser tjHchbdbUser);
	
	/**
	 * 删除用户
	 */
	public Object deleteUser(String id);
	
	/**
	 * 修改用户
	 */
	public Object updateUser(TjHchbdbUser tjHchbdbUser);
	
	/**
	 * 按ID查找某个用户
	 */
	public TjHchbdbUser queryUserById(String id);
	
	/**
	 * 查询所有的用户
	 */
	public Object queryALLUser();
	
	/**
	 * 查询所有的用户, Node
	 */
	public Object queryNodeUser();
	
	/**
	 * 添加用户、菜单关系
	 */
	public Object operationUserMenu(String userid, String s);
	
	/**
	 * 保存用户角色关系
	 */
	public Object operationUserRole(String userid, String s);
}
