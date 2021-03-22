package com.hchbht.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hchbht.model.historical.HistoryDrops;
import com.hchbht.service.HistoryDropsService;
import org.springframework.web.bind.annotation.RestController;

/**
 * 历史掉线
 * @author Administrator
 *
 */
@RequestMapping("/historydrops")
@RestController
@Api(tags = "历史掉线")
public class HistoryDropsController {
	@Resource
	private HistoryDropsService warnDropsService;
	/**
	 * 添加
	 */
	@PostMapping("/insert")
	@ApiOperation(value = "添加")
	public Object insert(HistoryDrops warnDrops) {
		return warnDropsService.insert(warnDrops);
	}
	
	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@ApiOperation(value = "删除")
	public Object delete(String id) {
		return warnDropsService.delete(id);
	}
	
	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改")
	public Object update(HistoryDrops warnDrops) {
		return warnDropsService.update(warnDrops);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	@PostMapping("/queryDataByCondition")
	@ApiOperation(value = "根据条件查询单个数据")
	public Object queryDataByCondition(HistoryDrops warnDrops) {
		return warnDropsService.queryDataByCondition(warnDrops);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	@PostMapping("/queryDataByConditions")
	@ApiOperation(value = "根据条件查询  list 数据")
	public Object queryDataByConditions(HistoryDrops warnDrops) {
		return warnDropsService.queryDataByConditions(warnDrops);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	@PostMapping("/queryDataByConditionsPage")
	@ApiOperation(value = "根据条件查询  Page 数据")
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, HistoryDrops warnDrops) {
		return warnDropsService.queryDataByConditionsPage(curPage,pageSize, warnDrops);
	}
}
