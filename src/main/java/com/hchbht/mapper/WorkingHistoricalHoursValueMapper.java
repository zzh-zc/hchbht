package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.ibatis.annotations.Param;

import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;

public interface WorkingHistoricalHoursValueMapper {
	/**
	 * 添加
	 */
	public void insert(WorkingHistoricalHoursValue workingHistoricalHoursValue);
	
	/**
	 * 修改
	 */
	public void update(WorkingHistoricalHoursValue workingHistoricalHoursValue);
	
	/**
	 * 删除
	 */
	public void datele(String id);
	
	/**
	 * 根据条件查询，单一的数据
	 */
	public WorkingHistoricalHoursValue queryDataByCondition(WorkingHistoricalHoursValue workingHistoricalHoursValue);
	
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
	public List<WorkingHistoricalHoursValue> queryDataByConditionsPage(@Param(value = "companyInfo") TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 矿工查询所有的工况企业
	 */
	public List<TjHchbdbCompanyInfo> queryWorkComapny(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工况 根据设备id，查询当前最新的小时数据
	 */
	public List<WorkingHistoricalHoursValue> queryLastDataByEquipmentid(String equipmentid);
	
	/**
	 * 报表数据
	 */
	public List<WorkingHistoricalHoursValue> queryBaoBiao(@Param(value = "bbtype")Integer bbtype,
			@Param(value = "equipmentid")String equipmentid, 
			@Param(value = "sd")String sd, @Param(value = "ed")String ed);
	
	/**
	 * 工况分钟数据
	 */
	public List<WorkingHistoricalHoursValue> queryLastDataWork(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 查询一级数据
	 */
	public List<WorkingHistoricalHoursValue> queryDataFirst(String equipmentid);
	
	/**
	 * 查询二级数据
	 */
	public List<WorkingHistoricalHoursValue> queryDataSecond(String equipmentid);
	
	/**
	 * 查询三级数据
	 */
	public List<WorkingHistoricalHoursValue> queryDataThird(String equipmentid);
}
