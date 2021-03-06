package com.hchbht.service;

import com.hchbht.model.River;

public interface RiverService {
	/**
	 * 添加角色
	 */
	public Object insertRiver(River river);
	
	/**
	 * 修改角色
	 */
	public Object updateRiver(River river);
	
	/**
	 * 删除角色
	 */
	public Object deleteRiver(String id);
	
	/**
	 * 根据id查找角色
	 */
	public Object queryRiverById(String id);
	
	/**
	 * 查询所有角色
	 */
	public Object queryALLRiver();
}
