package com.hchbht.service;

import com.github.pagehelper.PageInfo;
import com.hchbht.model.air.AirStation;

public interface AirStationService {
	/**
	 * 添加
	 */
	public Object insertAirStation(AirStation airStation);
	
	/**
	 * 删除
	 */
	public Object deleteAirStation(String id);
	
	/**
	 * 修改
	 */
	public Object updateAirStation(AirStation airStation);
	
	/**
	 * 根据id, 查找相应的空气污染因子
	 * @return
	 */
	public Object queryAirStationByApfId(String id);
	
	/**
	 * 查找所有的，分页
	 * @return
	 */
	public PageInfo<AirStation> queryAirStationPage(Integer curPage, Integer pageSize, AirStation airStation);
}
