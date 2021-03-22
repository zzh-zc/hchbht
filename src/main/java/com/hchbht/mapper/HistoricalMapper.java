package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.ibatis.annotations.Param;

import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;

public interface HistoricalMapper {
	/**
	 * voc历史数据，分钟
	 */
	public List<AirHistoricalMinutesVOC> queryLastDataVocM(@Param(value = "companyInfo") TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工况历史数据，分钟
	 */
	public List<WorkingHistoricalMinutesValue> queryLastDataWorkM(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 油烟历史数据，分钟
	 */
	public List<LampblackHistoricalMinutesValue> queryLastDataLampM(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	//-----------------------------------------------------------------------------------------------------------------
	/**
	 * voc历史数据，分钟
	 */
	public List<AirHistoricalHoursVOC> queryLastDataVocH(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工况历史数据，分钟
	 */
	public List<WorkingHistoricalHoursValue> queryLastDataWorkH(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 油烟历史数据，分钟
	 */
	public List<LampblackHistoricalHoursValue> queryLastDataLampH(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
}
