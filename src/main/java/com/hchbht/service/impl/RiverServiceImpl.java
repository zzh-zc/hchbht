package com.hchbht.service.impl;

import java.util.List;
import java.util.UUID;


import com.hchbht.service.RiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.RiverMapper;
import com.hchbht.model.River;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RiverServiceImpl implements RiverService {
	@Autowired
	private RiverMapper riverMapper;
	
	/**
	 * 添加角色
	 */
	public Object insertRiver(River river) {
		river.setId(UUID.randomUUID().toString());
		riverMapper.insert(river);
		return new AjaxResult(true,"操作成功", Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改角色
	 */
	public Object updateRiver(River river) {
		riverMapper.updateByPrimaryKey(river);
		return new AjaxResult(true,"操作成功", Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 删除角色
	 */
	public Object deleteRiver(String id) {
		riverMapper.deleteByPrimaryKey(id);
		return new AjaxResult(true,"操作成功", Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 根据id查找角色
	 */
	public Object queryRiverById(String id) {
		River river = riverMapper.selectByPrimaryKey(id);
		return new AjaxResult(true,"操作成功", river);
	}
	
	/**
	 * 查询所有角色
	 */
	public Object queryALLRiver() {
		List<River> list = riverMapper.selectAll();
		return new AjaxResult(true,"操作成功", list);
	}
}
