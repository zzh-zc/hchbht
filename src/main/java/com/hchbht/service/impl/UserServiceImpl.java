package com.hchbht.service.impl;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.hchbht.model.*;
import com.hchbht.result.CommonResult;
import com.hchbht.utils.vo.Node;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.hchbht.mapper.MenuMapper;
import com.hchbht.mapper.RoleMapper;
import com.hchbht.mapper.UserMapper;
import com.hchbht.mapper.UserMenuMapper;
import com.hchbht.mapper.UserRoleMapper;
import com.hchbht.model.TjHchbdbUser;
import com.hchbht.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private UserMenuMapper userMenuMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	@Resource
	private MenuMapper menuMapper;
	
	/**
	 * 登录
	 */
	public Object login(String username, String password,HttpSession session) {
		TjHchbdbUser tjHchbdbUser = new TjHchbdbUser();
		//MD5 加密密码
		tjHchbdbUser.setUsername(username);
		tjHchbdbUser.setPassword(DigestUtils.md5DigestAsHex(DigestUtils.md5DigestAsHex(password.getBytes()).getBytes()));
		//admin密码前端MD5加密之后  21232f297a57a5a743894a0e4a801fc3
		//后端MD5加密之后c3284d0f94606de1fd2af172aba15bf3
		try {
			TjHchbdbUser us = userMapper.queryUserByNP(tjHchbdbUser);
			if (us != null) {
				Role role = roleMapper.queryRoleByUserId(us.getId());
				if (role != null && ("admin".equals(role.getRolename()) || "super".equals(role.getRolename()))) {
					//查询用户的menu
					session.setAttribute("user",us);
					return CommonResult.success(us,"登录成功");
				} else {
					return CommonResult.failed("权限不够");
				}
			} else {
				return CommonResult.failed("用户名或者密码不正确");
			}
		} catch (Exception e) {
			return CommonResult.failed("系统维护中...");
		}
	}
	
	/**
	 * 注销
	 */
	public Object logout(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			session.removeAttribute("user");
			
			map.put("success", true);
			map.put("msg", "退出成功！");
		} catch (Exception e) {
			map.put("status", false);
			map.put("msg", "系统维护中...");
		}
		return map;
	}
	
	/**
	 * 添加用户
	 */
	public Object insertUser(TjHchbdbUser tjHchbdbUser) {
		try {
			tjHchbdbUser.setId(UUID.randomUUID().toString());
			//MD5 加密密码
			String pass = DigestUtils.md5DigestAsHex(tjHchbdbUser.getPassword().getBytes());
			tjHchbdbUser.setPassword(DigestUtils.md5DigestAsHex(pass.getBytes()));
			userMapper.insert(tjHchbdbUser);
			return CommonResult.success(tjHchbdbUser);
		} catch (Exception e) {
			return CommonResult.failed("系统维护中...");
		}
	}
	
	/**
	 * 删除用户
	 */
	public Object deleteUser(String id) { 
		try {
			int i = userMapper.deleteByPrimaryKey(id);
			if(i==0){
				return CommonResult.failed("不存在该用户");
			}else{
				return CommonResult.success();
			}
		} catch (Exception e) {
			return CommonResult.failed("系统维护中...");
		}
	}
	
	/**
	 * 修改用户
	 */
	public Object updateUser(TjHchbdbUser tjHchbdbUser) {
		try {
			userMapper.updateByPrimaryKey(tjHchbdbUser);
			return CommonResult.success();
		} catch (Exception e) {
			return CommonResult.failed("系统维护中...");
		}
	}
	
	/**
	 * 按ID查找某个用户，菜单项
	 */
	public TjHchbdbUser queryUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 查询所有的用户
	 */
	public Object queryALLUser() {
		try {
			List<TjHchbdbUser> list = userMapper.selectAll();
			return CommonResult.success(list);
		} catch (Exception e) {
			return CommonResult.failed("系统维护中...");
		}
	}
	
	/**
	 * 查询所有的用户, Node
	 */
	public Object queryNodeUser() {
		try {
			List<TjHchbdbUser> list = userMapper.selectAll();
			List<Node> f = new ArrayList<Node>();
			
			for (TjHchbdbUser tjHchbdbUser : list) {
				Node node = new Node();
				node.setId(tjHchbdbUser.getId());
				node.setText(tjHchbdbUser.getUsername());
				f.add(node);
			}
			return CommonResult.success(f);
		} catch (Exception e) {
			return CommonResult.failed("系统维护中...");
		}
	}
	
	/**
	 * 添加用户、菜单关系
	 */
	public Object operationUserMenu(String userid, String s) {
		try {
			if (s != null && s != "") {
				//先删掉之前的用户、菜单关系
				userMenuMapper.deleteUserMenuByUserId(userid);
				
				String[] menuids = s.split(",");
				//循环添加
				for (int i = 0; i < menuids.length; i++) {
					UserMenu userMenu = new UserMenu(UUID.randomUUID().toString(), userid, menuids[i], 1);
					userMenuMapper.insertUserMenu(userMenu);
				}
				return CommonResult.success();
			} else {
				return CommonResult.failed("请选择菜单项");
			}
			
		} catch (Exception e) {
			return CommonResult.failed("系统维护中...");
		}
	}
	
	/**
	 * 保存用户角色关系
	 */
	public Object operationUserRole(String userid, String s) {
		try {
			if (s != null && s != "") {
				//先删掉之前的用户、角色关系
				userRoleMapper.deleteUserRoleByUserId(userid);
				
				String[] roles = s.split(",");
				for (int i = 0; i < roles.length; i++) {
					UserRole ur = new UserRole(UUID.randomUUID().toString(), userid, roles[i], 1);
					userRoleMapper.insertUserRole(ur);
				}
				return CommonResult.success();
			} else {
				return CommonResult.failed("请选择角色项");
			}
		} catch (Exception e) {
			return CommonResult.failed("系统维护中...");
		}
	}
}
