package com.hchbht.mapper;

import com.hchbht.model.TjHchbdbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<TjHchbdbUser> {
//	/**
//	 * 添加用户
//	 */
//	public void insertUser(User user);
//
//	/**
//	 * 删除用户
//	 */
//	public void deleteUser(String id);
//
//	/**
//	 * 修改用户
//	 */
//	public void updateUser(User user);
//
//	/**
//	 * 按ID查找某个用户菜单
//	 */
//	public User queryUserById(String id);
	
	/**
	 * 按username和password查找某个用户
	 */
	public TjHchbdbUser queryUserByNP(TjHchbdbUser tjHchbdbUser);
	
	/**
	 * 查询所有的用户
	 * @return
	 */
//	public List<User> queryALLUser();
}
