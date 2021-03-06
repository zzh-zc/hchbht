package com.hchbht.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.hchbht.model.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuMapper {
	/**
	 * 添加菜单
	 */
	public void insertMenu(Menu menu);
	
	/**
	 * 删除菜单
	 */
	public void deleteMenu(String id);
	
	/**
	 * 修改菜单
	 */
	public void updateMenu(Menu menu);
	
	/**
	 * 按ID查找某个菜单项
	 */
	public Menu selectMenuById(String id);
	
	/**
	 * 左栏专用
	 * 查找所有的菜单，先找父级的
	 */
	public List<Menu> queryFatherMenu();
	
	/**
	 * 左栏专用
	 * 再寻找父级相对应下的子级
	 */
	public List<Menu> queryChildMenu(String parentId);
	
	/**
	 * 查找所有枚举，分页
	 * @return
	 */
	public Page<Menu> queryAllMenuPage();
	
	/**
	 * 查找所有的枚举
	 */
	public List<Menu> queryAllMenu();
}
