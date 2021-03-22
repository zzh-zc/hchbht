package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.ibatis.annotations.Param;

import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.monitoring.AirMonitoringVOC;

public interface AirHistoricalHoursVOCMapper {
	/**
	 * 添加
	 */
	public void insert(AirHistoricalHoursVOC airHistoricalHoursVOC);
	
	/**
	 * 修改
	 */
	public void update(AirHistoricalHoursVOC airHistoricalHoursVOC);
	
	/**
	 * 删除
	 */
	public void datele(String id);
	
	/**
	 * 根据条件查询，单一的数据
	 */
	public AirHistoricalHoursVOC queryDataByCondition(AirHistoricalHoursVOC airHistoricalHoursVOC);
	
	/**
	 * 数据总量
	 */
	public Integer queryDataSize(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据条件查询，list数据
	 */
	//public List<AirHistoricalHoursVOC> queryDataByConditions(AirHistoricalHoursVOC airHistoricalHoursVOC);
	
	/**
	 * 根据条件查询，list数据，分页
	 */
	/*public Page<AirHistoricalVOC> queryDataByConditionsPage(AirMonitoringVOC airMonitoringVOC);*/
	public List<AirHistoricalHoursVOC> queryDataByConditionsPage(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * voc 历史小时数据
	 */
	public List<AirHistoricalHoursVOC> queryLastDataVoc(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 实时矿工查询所有的工况企业
	 */
	public List<TjHchbdbCompanyInfo> queryWorkComapny(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * voc 根据设备id，查询当前最新的小时数据
	 */
	public List<AirHistoricalHoursVOC> queryLastDataByEquipmentid(String equipmentid);
	
	/**
	 * 报表数据  
	 * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 
	 */
	public List<AirHistoricalHoursVOC> queryBaoBiao(@Param(value = "bbtype")Integer bbtype,
			@Param(value = "equipmentid")String equipmentid, @Param(value = "sd")String sd, 
			@Param(value = "ed")String ed);
}
