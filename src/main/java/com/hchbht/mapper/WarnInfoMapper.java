package com.hchbht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hchbht.model.WarnInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface WarnInfoMapper extends Mapper<WarnInfo> {
	/**
	 * 根据条件查询单个数据
	 */
	public WarnInfo queryDataByCondition(WarnInfo warnInfo);
	
	/**
	 * 根据条件查询  list 数据
	 */
	public List<WarnInfo> queryDataByConditions(WarnInfo warnInfo);
	
	/**
	 * 根据条件查询  Page 数据长度
	 */
//	public int datasize(WarnInfo warnInfo);
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public List<WarnInfo> queryDataByConditionsPage(@Param(value = "w")WarnInfo warnInfo);
	
	/**
	 * 统计预警未处理的条数
	 */
	public int queryDataSize();
}
