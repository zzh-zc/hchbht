package com.hchbht.service;

import com.hchbht.model.WarnConditionVOC;

public interface WarnConditionVOCService {
	/**
	 * 添加
	 */
	public Object insert(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 删除
	 */
	public Object delete(String id, String equipmentid);
	
	/**
	 * 修改
	 */
	public Object update(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, WarnConditionVOC warnConditionVOC);
}
