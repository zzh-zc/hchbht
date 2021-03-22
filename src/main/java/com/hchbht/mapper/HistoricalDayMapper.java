package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.ibatis.annotations.Param;

import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;

/**
 * 历史天数据
 * @author Administrator
 *
 */
public interface HistoricalDayMapper{
	
	/**
	 * 实时矿工查询所有的工况企业 voc
	 */
	public List<TjHchbdbCompanyInfo> queryComapnyVoc(TjHchbdbCompanyInfo companyInfo);
	/**
	 * voc 根据设备id，查询当前最新的分钟数据
	 */
	public List<AirHistoricalHoursVOC> queryLastDataByEquipmentidVoc(String equipmentid);
	/**
	 * 根据条件查询，list数据，分页
	 */
	public List<AirHistoricalHoursVOC> queryDataByConditionsPageVoc(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 实时矿工查询所有的工况企业 工况 work
	 */
	public List<TjHchbdbCompanyInfo> queryComapnyWork(TjHchbdbCompanyInfo companyInfo);
	/**
	 * 工况 根据设备id，查询当前最新的分钟数据
	 */
	public List<WorkingHistoricalHoursValue> queryLastDataByEquipmentidWork(String equipmentid);
	/**
	 * 根据条件查询，list数据，分页
	 */
	public List<WorkingHistoricalHoursValue> queryDataByConditionsPageWork(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 实时矿工查询所有的工况企业 油烟 lamp
	 */
	public List<TjHchbdbCompanyInfo> queryComapnyLamp(TjHchbdbCompanyInfo companyInfo);
	/**
	 * 油烟 根据设备id，查询当前最新的分钟数据
	 */
	public List<LampblackHistoricalHoursValue> queryLastDataByEquipmentidLamp(String equipmentid);
	/**
	 * 根据条件查询，list数据，分页
	 */
	public List<LampblackHistoricalHoursValue> queryDataByConditionsPageLamp(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
}
