package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.ibatis.annotations.Param;

import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;
import com.hchbht.model.monitoring.WorkingConditionValue;

public interface WorkingHistoricalMinutesValueMapper {
	/**
	 * 添加
	 */
	public void insert(WorkingHistoricalMinutesValue workingHistoricalValue);
	
	/**
	 * 修改
	 */
	public void update(WorkingHistoricalMinutesValue workingHistoricalValue);
	
	/**
	 * 删除
	 */
	public void datele(String id);
	
	/**
	 * 根据条件查询，单一的数据
	 */
	public WorkingHistoricalMinutesValue queryDataByCondition(WorkingHistoricalMinutesValue workingHistoricalValue);
	
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
	public List<WorkingHistoricalMinutesValue> queryDataByConditionsPage(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 矿工查询所有的工况企业
	 */
	public List<TjHchbdbCompanyInfo> queryWorkComapny(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工况 根据设备id，查询当前最新的分钟数据
	 */
	public List<WorkingHistoricalMinutesValue> queryLastDataByEquipmentid(String equipmentid);
	
	/**
	 * 工况分钟数据
	 */
	public List<WorkingHistoricalMinutesValue> queryLastDataWork(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 数据报表
	 */
	public List<WorkingHistoricalMinutesValue> queryBaoBiao(@Param(value = "equipmentid")String equipmentid, 
			@Param(value = "sd")String sd, @Param(value = "ed")String ed);
	
	/**
	 * 查询一级数据
	 */
	public List<WorkingHistoricalMinutesValue> queryDataFirst(String equipmentid);
	
	/**
	 * 查询二级数据
	 */
	public List<WorkingHistoricalMinutesValue> queryDataSecond(String equipmentid);
	
	/**
	 * 查询三级数据
	 */
	public List<WorkingHistoricalMinutesValue> queryDataThird(String equipmentid);
}
