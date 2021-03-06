package com.hchbht.service;


import com.hchbht.model.Equipment;

public interface EquipmentService {
	/**
	 * 添加
	 */
	public Object insert(Equipment equipment);
	
	/**
	 * 修改
	 */
	public Object update(Equipment equipment);
	
	/**
	 * 删除
	 */
	public Object datele(String id);
	
	/**
	 * 根据条件查询，单一的数据
	 */
	public Object queryDataByCondition(Equipment equipment);
	
	/**
	 * 根据条件查询，list数据
	 */
	public Object queryDataByConditions(Equipment equipment);
	
	/**
	 * 根据条件查询，list数据， 分页
	 */
	public Object queryDataByConditionsPage(Integer curPage, Integer pageSize, Equipment equipment);
}
