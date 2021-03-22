package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.ibatis.annotations.Param;

import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;

public interface AirHistoricalMinutesVOCMapper {
	/**
	 * 添加
	 */
	public void insert(AirHistoricalMinutesVOC airHistoricalMinutesVOC);
	
	/**
	 * 修改
	 */
	public void update(AirHistoricalMinutesVOC airHistoricalMinutesVOC);
	
	/**
	 * 删除
	 */
	public void datele(String id);
	
	/**
	 * 根据条件查询，单一的数据
	 */
	public AirHistoricalMinutesVOC queryDataByCondition(AirHistoricalMinutesVOC airHistoricalMinutesVOC);
	
	/**
	 * 数据总量
	 */
	public Integer queryDataSize(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据条件查询，list数据
	 */
	//public List<AirHistoricalMinutesVOC> queryDataByConditions(AirHistoricalMinutesVOC airHistoricalMinutesVOC);
	
	/**
	 * 根据条件查询，list数据，分页
	 */
	/*public Page<AirHistoricalMinutesVOC> queryDataByConditionsPage(AirMonitoringVOC airMonitoringVOC);*/
	public List<AirHistoricalMinutesVOC> queryDataByConditionsPage(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * voc 历史分钟数据
	 */
	public List<AirHistoricalMinutesVOC> queryLastDataVoc(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 实时矿工查询所有的工况企业
	 */
	public List<TjHchbdbCompanyInfo> queryWorkComapny(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * voc 根据设备id，查询当前最新的分钟数据
	 */
	public List<AirHistoricalMinutesVOC> queryLastDataByEquipmentid(String equipmentid);
	
	/**
	 * 报表数据  
	 */
	public List<AirHistoricalMinutesVOC> queryBaoBiao(@Param(value = "equipmentid")String equipmentid, 
			@Param(value = "sd")String sd, @Param(value = "ed")String ed);
}
