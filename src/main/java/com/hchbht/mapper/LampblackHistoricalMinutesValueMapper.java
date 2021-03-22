package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.ibatis.annotations.Param;

import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.monitoring.LampblackMonitoringValue;

public interface LampblackHistoricalMinutesValueMapper {
	/**
	 * 添加
	 */
	public void insert(LampblackHistoricalMinutesValue lampblackHistoricalValue);
	
	/**
	 * 修改
	 */
	public void update(LampblackHistoricalMinutesValue lampblackHistoricalValue);
	
	/**
	 * 删除
	 */
	public void datele(String id);
	
	/**
	 * 根据条件查询，单一的数据
	 */
	public LampblackHistoricalMinutesValue queryDataByCondition(LampblackHistoricalMinutesValue lampblackHistoricalValue);
	
	/**
	 * 数据总量
	 */
	public Integer queryDataSize(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据条件查询，list数据， 分页
	 */
	/*public Page<AirMonitoringValue> queryDataByConditionsPage(@Param(value = "PageNum")int PageNum, @Param(value = "PageNum")int pageSize, 
			@Param(value = "id")String id, @Param(value = "equipmentid")String equipmentid, @Param(value = "type") String type,
			@Param(value = "monitoringtime")Date monitoringtime);*/
	public List<LampblackHistoricalMinutesValue> queryDataByConditionsPage(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 油烟分钟数据
	 */
	public List<LampblackHistoricalMinutesValue> queryLastDataLamp(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 实时矿工查询所有的工况企业
	 */
	public List<TjHchbdbCompanyInfo> queryWorkComapny(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 油烟 根据设备id，查询当前最新的分钟数据
	 */
	public List<LampblackHistoricalMinutesValue> queryLastDataByEquipmentid(String equipmentid);
	
	/**
	 * 数据报表
	 */
	public List<LampblackHistoricalMinutesValue> queryBaoBiao(@Param(value = "equipmentid")String equipmentid, 
			@Param(value = "sd")String sd, @Param(value = "ed")String ed);
}
