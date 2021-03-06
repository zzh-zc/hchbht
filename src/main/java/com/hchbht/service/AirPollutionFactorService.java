package com.hchbht.service;

import com.github.pagehelper.PageInfo;
import com.hchbht.model.AirPollutionFactor;

public interface AirPollutionFactorService {
	/**
	 * 添加
	 */
	public Object insertAirPollutionFactor(AirPollutionFactor airPollutionFactor);
	
	/**
	 * 删除
	 */
	public Object deleteAirPollutionFactor(String apfid);
	
	/**
	 * 修改
	 */
	public Object updateAirPollutionFactor(AirPollutionFactor airPollutionFactor);
	
	/**
	 * 根据id, 查找相应的空气污染因子
	 * @return
	 */
	public Object queryAirPollutionFactorByApfId(String id);
	
	/**
	 * 查找所有的，分页
	 * @return
	 */
	public PageInfo<AirPollutionFactor> queryAirPollutionFactorPage(Integer curPage, Integer pageSize, AirPollutionFactor airPollutionFactor);
}
