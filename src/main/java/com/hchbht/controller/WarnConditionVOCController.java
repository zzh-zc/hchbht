package com.hchbht.controller;

import javax.annotation.Resource;

import com.hchbht.service.WarnConditionVOCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.model.WarnConditionVOC;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "VOC预警条件")
@RequestMapping("/warnconditionvoc")
@RestController
public class WarnConditionVOCController {
	@Autowired
	private WarnConditionVOCService warnConditionVOCService;
	/**
	 * 添加
	 */
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ApiOperation(value = "添加VOC预警条件")
	public Object insert(WarnConditionVOC warnConditionVOC) {
		return warnConditionVOCService.insert(warnConditionVOC);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ApiOperation(value = "删除VOC预警条件")
	public Object delete(String id, String equipmentid) {
		return warnConditionVOCService.delete(id, equipmentid);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ApiOperation(value = "修改VOC预警条件")
	public Object update(WarnConditionVOC warnConditionVOC) {
		return warnConditionVOCService.update(warnConditionVOC);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	@RequestMapping(value = "/queryDataByCondition",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询单个数据")
	public Object queryDataByCondition(WarnConditionVOC warnConditionVOC) {
		return warnConditionVOCService.queryDataByCondition(warnConditionVOC);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	@RequestMapping(value = "/queryDataByConditions",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询  list 数据")
	public Object queryDataByConditions(WarnConditionVOC warnConditionVOC) {
		return warnConditionVOCService.queryDataByConditions(warnConditionVOC);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	@RequestMapping(value = "/queryDataByConditionsPage",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询  Page 数据")
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize,WarnConditionVOC warnConditionVOC) {
		return warnConditionVOCService.queryDataByConditionsPage(curPage,pageSize,warnConditionVOC);
	}
}
