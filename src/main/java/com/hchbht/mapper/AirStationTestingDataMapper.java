package com.hchbht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hchbht.model.air.AirStationTestingData;
import tk.mybatis.mapper.common.Mapper;

/**
 * 空气站数据检测
 * @author Administrator
 *
 */
public interface AirStationTestingDataMapper extends Mapper<AirStationTestingData> {
	
	public List<AirStationTestingData> queryLastDataKQZ(@Param(value = "air")AirStationTestingData airStationTestingData);
	
	/**
	 * 报表数据  
	 */
	public List<AirStationTestingData> queryBaoBiao(@Param(value = "stationCode")String stationCode, 
			@Param(value = "bbtype")Integer bbtype, @Param(value = "sd")String sd, @Param(value = "ed")String ed);
}
