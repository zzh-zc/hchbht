package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.Equipment;
import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;

/**
 * 实时数据，每家企业单个的最新历史数据   小时
 * @author Administrator
 *
 */
public interface HistoricalHoursMapper {	
	//----------------------------实时数据，VOC 历史分钟数据------------------------------------------------
	/**
	 * voc 实时数据监测，先根据条件查询，企业信息
	 */
	public List<TjHchbdbCompanyInfo> queryDataHistoricalHoursVOC(TjHchbdbCompanyInfo companyInfo);
	/**
	 * voc 再根据设备eid，查询最新的实时数据
	 */
	public List<AirHistoricalHoursVOC> queryOnlyHistoricalHoursVOC(String equipmentid);
	
	//---------------------------实时数据，油烟 历史分钟数据-------------------------------------------------
	/**
	 * 油烟 实时数据监测，先根据条件查询，企业信息
	 */
	public List<TjHchbdbCompanyInfo> queryDataLampblackHistoricalHoursValue(TjHchbdbCompanyInfo companyInfo);
	/**
	 * 油烟，再根据eid,查询最新的实时数据
	 */
	public List<LampblackHistoricalHoursValue> queryOnlyLampblackHistoricalHoursValue(String equipmentid);
	
	//---------------------------实时数据，工况，历史分钟数据-------------------------------------------------
	/**
	 * 工况  实时数据监测，先根据条件查询，企业信息
	 */
	public List<TjHchbdbCompanyInfo> queryDataWorkingHistoricalHoursValue(TjHchbdbCompanyInfo companyInfo);
	/**
	 * 工况，再根据eid,查询最新的实时数据
	 */
	public List<WorkingHistoricalHoursValue> queryOnlyWorkingHistoricalHoursValue(String equipmentid);
	
	/**
	 * 查询二级数据
	 */
	public List<WorkingHistoricalHoursValue> queryDataSecond(String equipmentid);
	/**
	 * 查询三级数据
	 */
	public List<WorkingHistoricalHoursValue> queryDataThird(String equipmentid);
}
