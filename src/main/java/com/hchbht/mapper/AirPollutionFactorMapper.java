package com.hchbht.mapper;

import java.util.List;
import java.util.Map;

import com.hchbht.model.AirPollutionFactor;
import tk.mybatis.mapper.common.Mapper;

public interface AirPollutionFactorMapper extends Mapper<AirPollutionFactor> {
	/**
	 * 根据条件查找相应的空气污染因子
	 * @return
	 */
	public List<AirPollutionFactor> queryAirPollutionFactorByConditions(AirPollutionFactor airPollutionFactor);
	
	/**
	 * 查找所有的，分页
	 * @return
	 */
	public List<AirPollutionFactor> queryAirPollutionFactorPage(AirPollutionFactor airPollutionFactor);
}
