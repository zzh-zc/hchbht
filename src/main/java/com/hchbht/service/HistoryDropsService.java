package com.hchbht.service;

import com.hchbht.model.historical.HistoryDrops;

public interface HistoryDropsService {
	/**
	 * 添加
	 */
	public Object insert(HistoryDrops historyDrops);
	
	/**
	 * 删除
	 */
	public Object delete(String id);
	
	/**
	 * 修改
	 */
	public Object update(HistoryDrops historyDrops);
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(HistoryDrops historyDrops);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(HistoryDrops historyDrops);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, HistoryDrops historyDrops);
}
