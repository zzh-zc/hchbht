package com.hchbht.controller;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import com.hchbht.service.AirStationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.model.air.AirStation;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "空气站")
@RequestMapping("/airstation")
@RestController
public class AirStationController {
	@Autowired
	private AirStationService airStationService;
	
	/**
	 * 添加
	 */
	@RequestMapping(value = "/insertAirStation",method = RequestMethod.POST)
	@ApiOperation(value = "添加")
	public Object insertAirStation(AirStation airStation) {
		return airStationService.insertAirStation(airStation);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/deleteAirStation",method = RequestMethod.POST)
	@ApiOperation(value = "删除")
	public Object deleteAirStation(String id) {
		return airStationService.deleteAirStation(id);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/updateAirStation",method = RequestMethod.POST)
	@ApiOperation(value = "修改")
	public Object updateAirStation(AirStation airStation) {
		return airStationService.updateAirStation(airStation);
	}
	
	/**
	 * 根据id, 查找相应的空气污染因子
	 * @return
	 */
	@RequestMapping(value = "/queryAirStationById",method = RequestMethod.POST)
	@ApiOperation(value = "根据id, 查找相应的空气污染因子")
	public Object queryAirStationByApfId(String id) {
		return airStationService.queryAirStationByApfId(id);
	}
	
	/**
	 * 查找所有的，分页
	 * @return
	 */
	@RequestMapping(value = "/queryAirStationPage",method = RequestMethod.POST)
	@ApiOperation(value = "查找所有的，分页")
	public PageInfo<AirStation> queryAirStationPage(Integer curPage, Integer pageSize, AirStation airStation) {
		return airStationService.queryAirStationPage(curPage,pageSize, airStation);
	}
}
