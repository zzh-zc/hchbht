package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.WarnConditionVOC;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface WarnConditionVOCMapper {
	/**
	 * 添加
	 */
	public void insert(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 删除
	 */
	public void delete(String id);
	
	/**
	 * 修改
	 */
	public void update(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据条件查询单个数据
	 */
	public WarnConditionVOC queryDataByCondition(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public List<WarnConditionVOC> queryDataByConditions(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 统计数据多少
	 */
	public int datasize(WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public List<WarnConditionVOC> queryDataByConditionsPage(@Param(value = "startrow")int startrow,
			@Param(value = "endrow")int endrow, @Param(value = "w")WarnConditionVOC warnConditionVOC);
	
	/**
	 * 根据设备id查询相应的信息
	 * @return
	 */
	public WarnConditionVOC queryDataByEid(String equipmentid);
}
