package com.hchbht.service;

import com.hchbht.model.WarnConditionWork;
public interface WarnConditionWorkService {
	/**
	 * 添加
	 */
	public Object insert(WarnConditionWork warnConditionWork);
	
	/**
	 * 删除
	 */
	public Object delete(String id, String equipmentid);
	
	/**
	 * 修改
	 */
	public Object update(WarnConditionWork warnConditionWork);
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(WarnConditionWork warnConditionWork);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(WarnConditionWork warnConditionWork);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize,WarnConditionWork warnConditionWork);
}
