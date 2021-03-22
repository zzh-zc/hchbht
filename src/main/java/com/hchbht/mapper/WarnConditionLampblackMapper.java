package com.hchbht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hchbht.model.WarnConditionLampblack;

public interface WarnConditionLampblackMapper {
	/**
	 * 添加
	 */
	public void insert(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 删除
	 */
	public void delete(String id);
	
	/**
	 * 修改
	 */
	public void update(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 根据条件查询单个数据
	 */
	public WarnConditionLampblack queryDataByCondition(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public List<WarnConditionLampblack> queryDataByConditions(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 统计数据多少
	 */
	public int datasize(WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public List<WarnConditionLampblack> queryDataByConditionsPage(@Param(value = "warnConditionLampblack")WarnConditionLampblack warnConditionLampblack);
	
	/**
	 * 根据设备id查询相应的信息
	 * @return
	 */
	public WarnConditionLampblack queryDataByEid(String equipmentid);
}
