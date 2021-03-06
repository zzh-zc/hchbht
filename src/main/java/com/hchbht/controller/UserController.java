package com.hchbht.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.hchbht.model.TjHchbdbUser;
import com.hchbht.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hchbht.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@Api(tags =  "用户管理")
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 登录
	 */
	@PostMapping("/login")
	@ApiOperation(value = "登录接口",
			notes = "username: 用户名\n"+
					"password: 密码")
	private Object login(String username, String password,HttpSession session) {
		return userService.login(username, password,session);
	}
	
	/**
	 * 注册
	 */
	@ApiOperation(value = "注册接口")
	@PostMapping("/register")
	private CommonResult<TjHchbdbUser> register(TjHchbdbUser tjHchbdbUser) {
		userService.insertUser(tjHchbdbUser);
		return CommonResult.success(tjHchbdbUser);
	}
	
	/**
	 * 退出
	 */
	@PostMapping("/logout")
	@ApiOperation(value = "退出登录")
	private Object logout(HttpSession session) {
		return userService.logout(session);
	}
	
	/**
	 * 查找所有的用户
	 */
	@PostMapping("/queryAllUser")
	@ApiOperation(value = "查询所有用户信息")
	private Object queryAllUser() {
		return userService.queryALLUser();	
	}
	
	/**
	 * 查找所有的用户，Node
	 */
	@PostMapping("/queryNodeUser")
	@ApiOperation(value = "查询所有用户信息2")
	private Object queryNodeUser() {
		return userService.queryNodeUser();	
	}
	
	/**
	 * 添加用户
	 */
	@PostMapping("/addUser")
	@ApiOperation(value = "添加用户")
	private Object addUser(TjHchbdbUser tjHchbdbUser) {
		return userService.insertUser(tjHchbdbUser);
	}
	
	/**
	 * 修改用户
	 */
	@PostMapping("/updateUser")
	@ApiOperation(value = "修改用户")
	public Object updateUser(TjHchbdbUser tjHchbdbUser) {
		return userService.updateUser(tjHchbdbUser);
	}
	
	/**
	 * 删除用户
	 */
	@PostMapping("/removeUser")
	@ApiOperation(value = "删除用户")
	public Object removeUser(String userid) {
		return userService.deleteUser(userid);
	}
	
	/**
	 * 添加、重新添加，用户、菜单关系
	 */
	@PostMapping("/operationUserMenu")
	@ApiOperation(value = "添加、重新添加，用户、菜单关系")
	public Object operationUserMenu(String userid, String s) {
		return userService.operationUserMenu(userid, s);
	}
	
	/**
	 * 添加、重新添加，用户、角色关系
	 */
	@PostMapping("/operationUserRole")
	@ApiOperation(value = "添加、重新添加，用户、角色关系")
	public Object operationUserRole(String userid, String s) {
		return userService.operationUserRole(userid, s);
	}
}
