package com.hchbht.service;

import com.hchbht.model.WarnConditionLampblack;
import com.hchbht.model.WarnInfo;
import com.hchbht.model.historical.HistoryDrops;

public interface WarnConditionLampblackService {
	/**
	 * 添加
	 */
	public Object insert(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 删除
	 */
	public Object delete(String id, String equipmentid);
	
	/**
	 * 修改
	 */
	public Object update(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, WarnConditionLampblack warnConditionLampblack);
}
