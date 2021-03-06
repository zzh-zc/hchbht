package com.hchbht.controller;


import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.model.Equipment;
import com.hchbht.service.EquipmentService;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "设备表")
@RequestMapping("/equipment")
@RestController
public class EquipmentController {
	@Autowired
	private EquipmentService equipmentService;
	
	/**
	 * 添加设备
	 */
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ApiOperation(value = "添加设备")
	public Object insert(Equipment equipment) {
		return equipmentService.insert(equipment);
	}
	
	/**
	 * 修改设备
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ApiOperation(value = "修改设备")
	public Object update(Equipment equipment) {
		return equipmentService.update(equipment);
	}
	
	/**
	 * 删除设备
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ApiOperation(value = "删除设备")
	public Object delete(String id) {
		return equipmentService.datele(id);
	}
	
	/**
	 * 根据条件查询，单一的数据
	 */
	@RequestMapping(value = "/queryDataByCondition",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询，单一的数据")
	public Object queryDataByCondition(Equipment equipment) {
		return equipmentService.queryDataByCondition(equipment);
	}
	
	/**
	 * 根据条件查询，list数据
	 */
	@RequestMapping(value = "/queryDataByConditions",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询，list数据")
	public Object queryDataByConditions(Equipment equipment) {
		return equipmentService.queryDataByConditions(equipment);
	}
	
	/**
	 * 根据条件查询，list数据， 分页
	 */
	@RequestMapping(value = "/queryDataByConditionsPage",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询，list数据， 分页")
	public Object queryDataByConditionsPage(Integer curPage, Integer pageSize, Equipment equipment) {
		return equipmentService.queryDataByConditionsPage(curPage,pageSize, equipment);
	}
}
