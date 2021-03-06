package com.hchbht.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.CompanyInfoEquipmentMapper;
import com.hchbht.mapper.EquipmentMapper;
import com.hchbht.model.CompanyInfoEquipment;
import com.hchbht.model.Equipment;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.service.EquipmentService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService{
	@Autowired
	private EquipmentMapper equipmentMapper;
	@Autowired
	private CompanyInfoEquipmentMapper companyInfoEquipmentMapper;
	/**
	 * 添加
	 */
	public Object insert(Equipment equipment) {
		String eid = UUID.randomUUID().toString();
		equipment.setId(eid);
		equipmentMapper.insert(equipment);
		//作为联动，企业设备信息表跟新企业设备关系
		CompanyInfoEquipment ce = new CompanyInfoEquipment();
		ce.setId(UUID.randomUUID().toString());
		ce.setCompanyid(equipment.getCompanyid());
		ce.setEquipmentid(eid);
		companyInfoEquipmentMapper.insert(ce);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改
	 */
	public Object update(Equipment equipment) {
		equipmentMapper.updateByPrimaryKey(equipment);
		//如果启用这个设备，也同时修改企业信息表
		if (equipment.getStatus() == 0) {
			CompanyInfoEquipment ce = new CompanyInfoEquipment();
			ce.setEquipmentid(equipment.getId());
			ce.setStatus(0);
			companyInfoEquipmentMapper.updateByPrimaryKey(ce);
		}
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 删除
	 */
	public Object datele(String id) {
		equipmentMapper.deleteByPrimaryKey(id);
		//删除设备的同时，也把设备表业清空了
		CompanyInfoEquipment ce = new CompanyInfoEquipment();
		ce.setEquipmentid(id);
		companyInfoEquipmentMapper.deleteByPrimaryKey(ce);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 根据条件查询，单一的数据
	 */
	public Object queryDataByCondition(Equipment equipment) {
		Equipment e = equipmentMapper.queryDataByCondition(equipment);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, e);
	}
	
	/**
	 * 根据条件查询，list数据
	 */
	public Object queryDataByConditions(Equipment equipment) {
		List<Equipment> list = equipmentMapper.queryDataByConditions(equipment);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);
	}
	
	/**
	 * 根据条件查询，list数据， 分页
	 */
	public Object queryDataByConditionsPage(Integer curPage, Integer pageSize, Equipment equipment) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<Equipment> list = equipmentMapper.queryDataByConditionsPage(equipment);
		PageInfo<Equipment> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
