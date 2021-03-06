package com.hchbht.service;

import com.hchbht.model.air.AirStationTestingData;

public interface AirStationTestingDataService {
	/**
	 * 查找所有的，分页
	 * @return
	 */
	public Object queryAirStationPage(Integer curPage, Integer pageSize, AirStationTestingData airStationTestingData);
	
	public Object airQuery(Integer curPage, Integer pageSize, String stationCode, Integer bbtype, String sd, String ed);
}
