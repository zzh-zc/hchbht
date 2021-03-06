package com.hchbht.controller;


import com.github.pagehelper.PageInfo;
import com.hchbht.service.AirPollutionFactorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hchbht.model.AirPollutionFactor;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "空气污染因子")
@RequestMapping("/apf")
@RestController
public class AirPollutionFactorController {
	@Autowired
	private AirPollutionFactorService airPollutionFactorService;
	
	/**
	 * 添加
	 */
	@RequestMapping(value = "/insertAirPollutionFactor",method = RequestMethod.POST)
	@ApiOperation(value = "添加")
	public Object insertAirPollutionFactor(AirPollutionFactor airPollutionFactor) {
		return airPollutionFactorService.insertAirPollutionFactor(airPollutionFactor);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/deleteAirPollutionFactor",method = RequestMethod.POST)
	@ApiOperation(value = "删除")
	public Object deleteAirPollutionFactor(String id) {
		return airPollutionFactorService.deleteAirPollutionFactor(id);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/updateAirPollutionFactor",method = RequestMethod.POST)
	@ApiOperation(value = "修改")
	public Object updateAirPollutionFactor(AirPollutionFactor airPollutionFactor) {
		return airPollutionFactorService.updateAirPollutionFactor(airPollutionFactor);
	}
	
	/**
	 * 根据id, 查找相应的空气污染因子
	 * @return
	 */
	@RequestMapping(value = "/queryAirPollutionFactorByApfId",method = RequestMethod.POST)
	@ApiOperation(value = "根据id, 查找相应的空气污染因子")
	public Object queryAirPollutionFactorByApfId(String apfid) {
		return airPollutionFactorService.queryAirPollutionFactorByApfId(apfid);
	}
	
	/**
	 * 查找所有的，分页
	 * @return
	 */
	@RequestMapping(value = "/queryAirPollutionFactorPage",method = RequestMethod.POST)
	@ApiOperation(value = "查找所有的，分页")
	public PageInfo<AirPollutionFactor> queryAirPollutionFactorPage(Integer curPage, Integer pageSize , AirPollutionFactor airPollutionFactor) {
		return airPollutionFactorService.queryAirPollutionFactorPage(curPage,pageSize, airPollutionFactor);
	}
}
