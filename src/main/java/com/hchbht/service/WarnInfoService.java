package com.hchbht.service;

import com.hchbht.model.WarnInfo;

public interface WarnInfoService {
	/**
	 * 添加
	 */
	public Object insert(WarnInfo warnInfo);

	/**
	 * 删除
	 */
	public Object delete(String id);

	/**
	 * 修改
	 */
	public Object update(WarnInfo warnInfo);

	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(WarnInfo warnInfo);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(WarnInfo warnInfo);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, WarnInfo warnInfo);
	
	/**
	 * 统计预警未处理的条数
	 */
	public Object queryDataSize();
}
