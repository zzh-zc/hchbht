package com.hchbht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hchbht.model.WarnConditionVOC;
import com.hchbht.model.WarnConditionWork;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface WarnConditionWorkMapper extends Mapper<WarnConditionWork> {
	/**
	 * 根据条件查询单个数据
	 */
	public WarnConditionWork queryDataByCondition(WarnConditionWork warnConditionWork);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public List<WarnConditionWork> queryDataByConditions(WarnConditionWork warnConditionWork);
	

	/**
	 * 根据条件查询  Page 数据
	 */
	public List<WarnConditionWork> queryDataByConditionsPage(@Param(value = "w")WarnConditionWork warnConditionWork);
	
	/**
	 * 根据设备id查询相应的信息
	 * @return
	 */
	public WarnConditionWork queryDataByEid(String equipmentid);
}
