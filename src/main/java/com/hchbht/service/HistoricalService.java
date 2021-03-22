package com.hchbht.service;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import com.hchbht.model.monitoring.LampblackMonitoringValue;
import com.hchbht.model.monitoring.WorkingConditionValue;

public interface HistoricalService {
	//--------------------------------------历史分钟数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，分钟	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteHistoricalMinutesVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteHistoricalMinutesVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业污水，历史数据，分钟
	 */
	//public Object queryWasteHistoricalMinutesWater(PageInfo pageInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteWorkingHistoricalMinutes(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	工况
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteWorkingHistoricalMinutes2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，油气，历史数据，分钟
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryLampblackHistoricalMinutesGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，油气，历史数据，分钟
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryLampblackHistoricalMinutesGas2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，历史数据
	 */
	//public Object queryEnvironmentalGas();
	
	/**
	 * 环境质量，水，历史数据
	 */
	//public Object queryEnvironmentalWater();
	
	//--------------------------------------历史小时数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，小时	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteHistoricalHoursVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，小时	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteHistoricalHoursVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业污水，历史数据，小时
	 */
	//public Object queryWasteHistoricalMinutesWater(PageInfo pageInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，小时	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteWorkingHistoricalHours(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，小时	工况
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteWorkingHistoricalHours2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，油气，历史数据，小时
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryLampblackHistoricalHoursGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，油气，历史数据，小时
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryLampblackHistoricalHoursGas2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，历史数据
	 */
	//public Object queryEnvironmentalGas();
	
	/**
	 * 环境质量，水，历史数据
	 */
	//public Object queryEnvironmentalWater();
	//-------------------------------------------导出报表数据----------------------------------------------
	/**
	 * voc,报表
	 */
	public Object vocHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed);
	/**
	 * 工况,报表
	 */
	public Object workHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed);
	/**
	 * 油烟,报表
	 */
	public Object lampHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed);
}
