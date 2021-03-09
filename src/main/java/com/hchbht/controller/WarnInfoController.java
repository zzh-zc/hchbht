package com.hchbht.controller;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;

import com.hchbht.service.WarnInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.model.WarnInfo;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "预警信息")
@RequestMapping("/warnInfo")
@RestController
public class WarnInfoController {
	@Autowired
	private WarnInfoService warnInfoService;
	/**
	 * 添加
	 */
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ApiOperation(value = "添加预警信息")
	public Object insert(WarnInfo warnInfo) {
		return warnInfoService.insert(warnInfo);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ApiOperation(value = "删除预警信息")
	public Object delete(String id) {
		return warnInfoService.delete(id);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ApiOperation(value = "修改预警信息")
	public Object update(WarnInfo warnInfo) {
		return warnInfoService.update(warnInfo);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	@RequestMapping(value = "/queryDataByCondition",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询单个数据")
	public Object queryDataByCondition(WarnInfo warnInfo) {
		return warnInfoService.queryDataByCondition(warnInfo);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	@RequestMapping(value = "/queryDataByConditions",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询  list 数据")
	public Object queryDataByConditions(WarnInfo warnInfo) {
		return warnInfoService.queryDataByConditions(warnInfo);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	@RequestMapping(value = "/queryDataByConditionsPage",method = RequestMethod.POST)
	@ApiOperation(value = "根据条件查询  Page 数据")
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize,WarnInfo warnInfo) {
		return warnInfoService.queryDataByConditionsPage(curPage,pageSize, warnInfo);
	}
	
	/**
	 * 统计预警未处理的条数
	 */
	@RequestMapping(value = "/queryDataSize",method = RequestMethod.POST)
	@ApiOperation(value = "统计预警未处理的条数")
	public Object queryDataSize() {
		return warnInfoService.queryDataSize();
	}
}
