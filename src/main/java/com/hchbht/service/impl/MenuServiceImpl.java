package com.hchbht.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hchbht.mapper.MenuMapper;
import com.hchbht.mapper.UserMenuMapper;
import com.hchbht.model.Menu;
import com.hchbht.model.TjHchbdbUser;
import com.hchbht.model.UserMenu;
import com.hchbht.service.MenuService;
import com.hchbht.utils.vo.Node;
import com.hchbht.utils.vo.NodeState;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuMapper menuMapper;
	@Resource
	private UserMenuMapper userMenuMapper;
	
	/**
	 * 查看菜单，左栏
	 */
	public Object selectAllMenu(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {			
			//创建一个菜单链表
			List<Menu> l = new ArrayList<Menu>();
			//获取全部菜单链表
			List<Menu> list = menuMapper.queryAllMenu();
			//获取session中储存的User
			TjHchbdbUser user = (TjHchbdbUser) session.getAttribute("user");
			//获得跟User相关联的菜单信息
			List<UserMenu> ls = userMenuMapper.queryUserMenuByUserId(user.getId());
			
			//找出和该用户相关的菜单信息
			for (UserMenu um : ls) {
				for (Menu m : list) {
					if (m.getId().equals(um.getMenuid())) {
						l.add(m);
					}
				}
			}
			//一级菜单
			//多条件排序使用：thenComparing
			//　 降序排序使用：reversed()
			List<Menu> menus = (l.stream().filter(p -> StringUtils.isBlank(p.getParentId())).collect(Collectors.toList()))
					.stream().sorted(Comparator.comparing(Menu::getSort)).collect(Collectors.toList());
			List<Menu> menus1 = l.stream().filter(p -> StringUtils.isNotBlank(p.getParentId())&& p.getStatus()==1).collect(Collectors.toList());

			menus.parallelStream().forEach(m -> {
				setChild(m, menus1);
			});
			map.put("success", true);
			map.put("data", l);
			map.put("msg", null);
		} catch (Exception e) {
			map.put("success", false);
			map.put("data", null);
			map.put("msg", "数据加载中...");
		}
		return map;
	}

	/**
	 * 查看菜单列表，菜单管理list数据，分页
	 */
	public PageInfo queryALLMenuPage(PageInfo pageInfo) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		Page<Menu> list = menuMapper.queryAllMenuPage();
		pageInfo.setList(list);
		return pageInfo;
	}
	
	/**
	 * 查看菜单列表，菜单管理list数据
	 */
	public Object queryAllMenu() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {	
			List<Menu> list = menuMapper.queryAllMenu();
			
			map.put("success", true);
			map.put("data", list);
			map.put("msg", null);
		} catch (Exception e) {
			map.put("success", false);
			map.put("data", null);
			map.put("msg", "数据加载中...");
		}
		return map;
	}
	
	/**
	 * 查看菜单列表，node
	 */
	public Object queryNodeMenu() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Menu> list = menuMapper.queryFatherMenu();
			
			List<Node> f = new ArrayList<Node>();
			for (Menu menu : list) {
				//父级
				Node t = new Node();
				t.setId(menu.getId());
				t.setText(menu.getMenuName());
				t.setState(new NodeState(false, false, true, false));
				
				List<Node> c = new ArrayList<Node>();
				//判断特性
				if (menu.getChilds() != null) {
					//子级
					for (Menu m : menu.getChilds()) {
						Node tt = new Node();
						tt.setId(m.getId());
						tt.setText(m.getMenuName());
						tt.setNodes(null);
						tt.setState(new NodeState(false, false, true, false));
						c.add(tt);
					}
					t.setNodes(c);
				} else {
					t.setNodes(null);
				}
				f.add(t);
			}
			
			map.put("success", true);
			map.put("data", f);
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "系统维护中...");
		}
		return map;
	}
	
	/**
	 * 查看跟着个用户有关的菜单
	 */
	public Object queryTheUserMenu(String userid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//获取全部菜单链表
			List<Menu> list = menuMapper.queryAllMenu();
			//获得跟User相关联的菜单信息
			List<UserMenu> ls = userMenuMapper.queryUserMenuByUserId(userid);
			
			//修改菜单对象和用户相关联的ishave状态，表示这个菜单该用户拥有它
			for (UserMenu um : ls) {
				for (Menu m : list) {
					if (m.getId().equals(um.getMenuid())) {
						m.setIshave(true);
					}
				}
			}
			//改造一下结构
			list = FCMenu(list);
			//转变一下对象结构，由menu转换成node
			List<Node> f = new ArrayList<Node>();
			for (Menu menu : list) {
				//父级
				Node t = new Node();
				t.setId(menu.getId());
				t.setText(menu.getMenuName());
				
				if (menu.isIshave()) {
					t.setState(new NodeState(true, false, true, false));
				} else {
					t.setState(new NodeState(false, false, true, false));
				}
				
				List<Node> c = new ArrayList<Node>();
				//判断特性
				if (menu.getChilds() != null) {
					//子级
					for (Menu m : menu.getChilds()) {
						Node tt = new Node();
						tt.setId(m.getId());
						tt.setText(m.getMenuName());
						tt.setNodes(null);
						if (m.isIshave()) {
							tt.setState(new NodeState(true, false, true, false));
						} else {
							tt.setState(new NodeState(false, false, true, false));
						}
						
						c.add(tt);
					}
					t.setNodes(c);
				} else {
					t.setNodes(null);
				}
				f.add(t);
			}
			
			map.put("success", true);
			map.put("data", f);
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "系统维护中...");
		}
		return map;
	}
	
	/**
	 * 添加菜单
	 */
	public Object insertMenu(Menu menu) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			menu.setId(UUID.randomUUID().toString());
			if (menu.getParentId() == null || menu.getParentId() == "") {
				menu.setIcon("icon-folder-open");
			}
			
			//生成日期对象  
			Date current_date = new Date();  
			//设置日期格式化样式为：yyyy-MM-dd  
			SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			//格式化当前日期  
			String d = SimpleDateFormat.format(current_date.getTime()); 
			
			System.out.println(d);
			
			Date dd = null;
			try {
				dd = SimpleDateFormat.parse(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			menu.setLastOperatingTime(dd);
			
			menuMapper.insertMenu(menu);
			
			map.put("success", true);
			map.put("msg", "添加成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "系统维护中...");
		}
		return map;
	}
	
	/**
	 * 删除菜单
	 */
	public Object deleteMenu(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			menuMapper.deleteMenu(id);
			
			map.put("success", true);
			map.put("msg", "删除成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "系统维护中...");
		}
		return map;
	}
	
	/**
	 * 修改菜单
	 */
	public Object updateMenu(Menu menu) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			System.out.println("menu : " + menu.toString());
			menuMapper.updateMenu(menu);
			
			map.put("success", true);
			map.put("msg", "修改成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "系统维护中...");
		}
		return map;
	}
	
	/**
	 * 根据id查找菜单
	 */
	public Menu queryMenuById(String id) {
		return menuMapper.selectMenuById(id);
	}

	//转换链表menu结构，由单纯的list转换成父子级结构
	public List<Menu> FCMenu(List<Menu> list) {
		List<Menu> l = new ArrayList<Menu>();

		//存父级
		for(int i = 0; i < list.size(); i++) {
			Menu menu = list.get(i);
			if (menu.getParentId().length() == 0) {
				l.add(menu);
			}
		}

		//存子级
		for (Menu menu : l) {
			List<Menu> l2 = new ArrayList<Menu>();
			for(Menu m : list) {
				if (menu.getId().equals(m.getParentId())) {
					l2.add(m);
				}
			}
			menu.setChilds(l2);
		}

		return l;
	}

	//排序list，根据sort排序
	public List<Menu> SortMenu(List<Menu> list) {
        //先排序父级
		Collections.sort(list, new Comparator<Menu>() {
            public int compare(Menu arg0, Menu arg1) {
                int n = arg0.getSort();
                int m = arg1.getSort();
                return n - m;
            }
        });

		//再排序子级
        for (Menu menu : list) {
        	Collections.sort(menu.getChilds(), new Comparator<Menu>() {
                public int compare(Menu arg0, Menu arg1) {
                    int n = arg0.getSort();
                    int m = arg1.getSort();
                    return n - m;
                }
            });
		}
		return list;
	}

	/**
	 * 设置子元素
	 * @param m
	 * @param menus1
	 */
	private void setChild(Menu m, List<Menu> menus1) {
		List<Menu> child = (menus1.stream().filter(a -> a.getParentId().equals(m.getId())).collect(Collectors.toList()))
				.stream().sorted(Comparator.comparing(Menu::getSort)).collect(Collectors.toList());
		m.setChilds(child);
		if (child!=null && !child.isEmpty()) {
			child.parallelStream().forEach(c -> {
				//递归设置子元素，多级菜单支持
				setChild(c, menus1);
			});
		}
	}
}
