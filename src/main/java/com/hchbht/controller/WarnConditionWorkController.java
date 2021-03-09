package com.hchbht.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.model.WarnConditionWork;
import com.hchbht.service.WarnConditionWorkService;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工况预警条件")
@RequestMapping("/warnconditionwork")
@RestController
public class WarnConditionWorkController {
	@Autowired
	private WarnConditionWorkService service;
	/**
	 * 添加
	 */
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ApiOperation(value = "添加工况预警条件")
	public Object insert(WarnConditionWork warnConditionWork) {
		return service.insert(warnConditionWork);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ApiOperation(value = "删除工况预警条件")
	public Object delete(String id, String equipmentid) {
		return service.delete(id, equipmentid);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ApiOperation(value = "修改工况预警条件")
	public Object update(WarnConditionWork warnConditionWork) {
		return service.update(warnConditionWork);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	@RequestMapping(value = "/queryDataByCondition",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询单个数据")
	public Object queryDataByCondition(WarnConditionWork warnConditionWork) {
		return service.queryDataByCondition(warnConditionWork);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	@RequestMapping(value = "/queryDataByConditions",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询  list 数据")
	public Object queryDataByConditions(WarnConditionWork warnConditionWork) {
		return service.queryDataByConditions(warnConditionWork);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	@RequestMapping(value = "/queryDataByConditionsPage",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询  Page 数据")
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize,WarnConditionWork warnConditionWork) {
		return service.queryDataByConditionsPage(curPage,pageSize, warnConditionWork);
	}
}
