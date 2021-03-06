package com.hchbht.controller;

import com.github.pagehelper.PageInfo;
import com.hchbht.model.Menu;
import com.hchbht.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RequestMapping("/menu")
@Controller
public class MenuController {
	
	@Resource
	private MenuService menuService;
	
	/**
	 * 查看菜单，左栏
	 */
	@RequestMapping("/checkMenu")
	@ResponseBody
	public Object checkMenu(HttpSession session) {
		return menuService.selectAllMenu(session);
	}
	
	/**
	 * 查看菜单列表，菜单管理list数据，分页
	 */
	@RequestMapping("/queryALLMenuPage")
	@ResponseBody
	public Object queryALLMenuPage(PageInfo pageInfo) {
		return menuService.queryALLMenuPage(pageInfo);
	}
	
	/**
	 * 查看菜单列表，菜单管理list数据
	 */
	@RequestMapping("/queryAllMenu")
	@ResponseBody
	public Object queryALLMenu() {
		return menuService.queryAllMenu();
	}
	
	/**
	 * 查看菜单列表,Node
	 */
	@RequestMapping("/queryNodeMenu")
	@ResponseBody
	public Object queryNodeMenu() {
		return menuService.queryNodeMenu();
	}
	
	/**
	 * 查看跟着个用户有关的菜单
	 */
	@RequestMapping("/queryTheUserMenu")
	@ResponseBody
	public Object queryTheUserMenu(String userid) {
		return menuService.queryTheUserMenu(userid);
	}
	
	/**
	 * 添加菜单
	 */
	@RequestMapping("/addMenu")
	@ResponseBody
	public Object addMenu(Menu menu) {
		return menuService.insertMenu(menu);
	}
	
	/**
	 * 删除菜单
	 */
	@RequestMapping("/removeMenu")
	@ResponseBody
	public Object removeMenu(String menuid) {
		return menuService.deleteMenu(menuid);
	}
	
	/**
	 * 修改菜单
	 */
	@RequestMapping("/updateMenu")
	@ResponseBody
	public Object updateMenu(Menu menu) {
		return menuService.updateMenu(menu);
	}
}
