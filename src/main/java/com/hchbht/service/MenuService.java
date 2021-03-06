package com.hchbht.service;

import com.github.pagehelper.PageInfo;
import com.hchbht.model.Menu;

import javax.servlet.http.HttpSession;

public interface MenuService {
	
	/**
	 * 查看菜单，左栏
	 */
	public Object selectAllMenu(HttpSession session);
	
	/**
	 * 查看菜单列表，菜单管理list数据，分页
	 */
	public PageInfo queryALLMenuPage(PageInfo pageInfo);
	
	/**
	 * 查看菜单列表，菜单管理list数据
	 */
	public Object queryAllMenu();
	
	/**
	 * 查看菜单列表，node
	 */
	public Object queryNodeMenu();
	
	/**
	 * 查看跟着个用户有关的菜单
	 */
	public Object queryTheUserMenu(String userid);
	
	/**
	 * 添加菜单
	 */
	public Object insertMenu(Menu menu);
	
	/**
	 * 删除菜单
	 */
	public Object deleteMenu(String id);
	
	/**
	 * 修改菜单
	 */
	public Object updateMenu(Menu menu);
	
	/**
	 * 根据id查找菜单
	 */
	public Menu queryMenuById(String id);
}
