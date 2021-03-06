package com.hchbht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hchbht.model.Equipment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 设备
 * @author Administrator
 *
 */
@Repository
public interface EquipmentMapper extends Mapper<Equipment> {
	/**
	 * 根据条件查询，单一的数据
	 */
	public Equipment queryDataByCondition(Equipment equipment);
	
	/**
	 * 根据条件查询，list数据
	 */
	public List<Equipment> queryDataByConditions(Equipment equipment);
	
	/**
	 * count
	 */
	public Integer queryDataSize(Equipment equipment);
	
	/**
	 * 根据条件查询，list数据， 分页
	 */
	public List<Equipment> queryDataByConditionsPage(@Param(value = "equipment")Equipment equipment);
}
