package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.ibatis.annotations.Param;

import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;

public interface LampblackHistoricalHoursValueMapper {
	/**
	 * 添加
	 */
	public void insert(LampblackHistoricalHoursValue lampblackHistoricalHoursValue);
	
	/**
	 * 修改
	 */
	public void update(LampblackHistoricalHoursValue lampblackHistoricalHoursValue);
	
	/**
	 * 删除
	 */
	public void datele(String id);
	
	/**
	 * 根据条件查询，单一的数据
	 */
	public LampblackHistoricalHoursValue queryDataByCondition(LampblackHistoricalHoursValue lampblackHistoricalHoursValue);
	
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
	public List<LampblackHistoricalHoursValue> queryDataByConditionsPage(@Param(value = "companyInfo")TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 油烟小时数据
	 */
	public List<LampblackHistoricalHoursValue> queryLastDataLamp(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 实时矿工查询所有的工况企业
	 */
	public List<TjHchbdbCompanyInfo> queryWorkComapny(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 油烟 根据设备id，查询当前最新的小时数据
	 */
	public List<LampblackHistoricalHoursValue> queryLastDataByEquipmentid(String equipmentid);
	
	/**
	 * 报表数据
	 */
	public List<LampblackHistoricalHoursValue> queryBaoBiao(@Param(value = "bbtype")Integer bbtype,
			@Param(value = "equipmentid")String equipmentid, 
			@Param(value = "sd")String sd, @Param(value = "ed")String ed);
}
