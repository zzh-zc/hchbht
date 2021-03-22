package com.hchbht.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.model.WarnConditionLampblack;
import com.hchbht.service.WarnConditionLampblackService;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/warnconditionlampblack")
@RestController
@Api(tags = "预警条件---油烟")
public class WarnConditionLampblackController {
	@Resource
	private WarnConditionLampblackService service;
	/**
	 * 添加
	 */
	@PostMapping("/insert")
	@ApiOperation(value = "添加")
	public Object insert(WarnConditionLampblack warnConditionLampblack) {
		return service.insert(warnConditionLampblack);
	}
	
	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@ApiOperation(value = "删除")
	public Object delete(String id, String equipmentid) {
		return service.delete(id, equipmentid);
	}
	
	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改")
	public Object update(WarnConditionLampblack warnConditionLampblack) {
		return service.update(warnConditionLampblack);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	@PostMapping("/queryDataByCondition")
	@ApiOperation(value = "根据条件查询单个数据")
	public Object queryDataByCondition(WarnConditionLampblack warnConditionLampblack) {
		return service.queryDataByCondition(warnConditionLampblack);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	@PostMapping("/queryDataByConditions")
	@ApiOperation(value = "根据条件查询  list 数据")
	public Object queryDataByConditions(WarnConditionLampblack warnConditionLampblack) {
		return service.queryDataByConditions(warnConditionLampblack);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	@PostMapping("/queryDataByConditionsPage")
	@ApiOperation(value = "根据条件查询  Page 数据")
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, WarnConditionLampblack warnConditionLampblack) {
		return service.queryDataByConditionsPage(curPage,pageSize, warnConditionLampblack);
	}
}
