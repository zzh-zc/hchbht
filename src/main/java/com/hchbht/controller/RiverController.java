package com.hchbht.controller;


import com.hchbht.service.RiverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hchbht.model.River;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "河流信息操作")
@RequestMapping("/river")
@RestController
public class RiverController {
	@Autowired
	private RiverService riverService;
	/**
	 * 添加角色
	 */
	@ApiOperation(value = "添加河流")
	@RequestMapping(value = "/insertRiver",method = RequestMethod.POST)
	public Object insertRiver(River river) {
		return riverService.insertRiver(river);
	}
	
	/**
	 * 修改角色
	 */
	@RequestMapping(value = "/updateRiver",method = RequestMethod.POST)
	@ApiOperation(value = "修改河流")
	public Object updateRiver(River river) {
		return riverService.updateRiver(river);
	}
	
	/**
	 * 删除角色
	 */
	@RequestMapping(value = "/deleteRiver",method = RequestMethod.POST)
	@ApiOperation(value = "删除河流")
	public Object deleteRiver(String id) {
		return riverService.deleteRiver(id);
	}
	
	/**
	 * 根据id查找角色
	 */
	@RequestMapping(value = "/queryRiverById",method = RequestMethod.POST)
	@ApiOperation(value = "根据id查找河流")
	public Object queryRiverById(String id) {
		return riverService.queryRiverById(id);
	}
	
	/**
	 * 查询所有角色
	 */
	@RequestMapping(value = "/queryALLRiver",method = RequestMethod.POST)
	@ApiOperation(value = "查询所有河流")
	public Object queryALLRiver() {
		return riverService.queryALLRiver();
	}
}
