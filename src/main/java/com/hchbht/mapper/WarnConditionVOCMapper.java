package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.WarnConditionVOC;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface WarnConditionVOCMapper extends Mapper<WarnConditionVOC> {
	/**
	 * 根据条件查询单个数据
	 */
	public WarnConditionVOC queryDataByCondition(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public List<WarnConditionVOC> queryDataByConditions(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public List<WarnConditionVOC> queryDataByConditionsPage(@Param(value = "w")WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据设备id查询相应的信息
	 * @return
	 */
	public WarnConditionVOC queryDataByEid(String equipmentid);
}
