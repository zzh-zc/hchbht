package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.Equipment;
import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;
import com.hchbht.model.monitoring.WorkingConditionValue;

/**
 * 实时数据，每家企业单个的最新历史数据   分钟
 * @author Administrator
 *
 */
public interface HistoricalMinutesMapper {	
	//----------------------------实时数据，VOC 历史分钟数据------------------------------------------------
	/**
	 * voc 历史分钟，先根据条件查询，企业信息
	 */
	public List<TjHchbdbCompanyInfo> queryDataHistoricalMinutesVOC(TjHchbdbCompanyInfo companyInfo);
	/**
	 * voc 再根据设备eid，查询最新的历史分钟数据
	 */
	public List<AirHistoricalMinutesVOC> queryOnlyHistoricalMinutesVOC(String equipmentid);
	
	//---------------------------实时数据，油烟 历史分钟数据-------------------------------------------------
	/**
	 * 油烟  历史分钟数据，先根据条件查询，企业信息
	 */
	public List<TjHchbdbCompanyInfo> queryDataLampblackHistoricalMinutesValue(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 油烟，再根据eid,查询最新的历史分钟数据
	 */
	public List<LampblackHistoricalMinutesValue> queryOnlyLampblackHistoricalMinutesValue(String equipmentid);
	
	//---------------------------实时数据，工况，历史分钟数据-------------------------------------------------
	/**
	 * 工况  历史分钟数据，先根据条件查询，企业信息
	 */
	public List<TjHchbdbCompanyInfo> queryDataWorkingHistoricalMinutesValue(TjHchbdbCompanyInfo companyInfo);
	/**
	 * 工况，再根据eid,查询最新的历史分钟数据
	 */
	public List<WorkingHistoricalMinutesValue> queryOnlyWorkingHistoricalMinutesValue(String equipmentid);
	
	/**
	 * 查询二级数据
	 */
	public List<WorkingHistoricalMinutesValue> queryDataSecond(String equipmentid);
	
	/**
	 * 查询三级数据
	 */
	public List<WorkingHistoricalMinutesValue> queryDataThird(String equipmentid);
}
