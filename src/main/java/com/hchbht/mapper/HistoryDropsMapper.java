package com.hchbht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.hchbht.model.historical.HistoryDrops;
import tk.mybatis.mapper.common.Mapper;

public interface HistoryDropsMapper extends Mapper<HistoryDrops> {
	/**
	 * 根据条件查询单个数据
	 */
	public HistoryDrops queryDataByCondition(HistoryDrops historyDrops);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public List<HistoryDrops> queryDataByConditions(HistoryDrops historyDrops);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public List<HistoryDrops> queryDataByConditionsPage(HistoryDrops historyDrops);
}
