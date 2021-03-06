package com.hchbht.controller;

import java.util.List;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.model.air.AirStationTestingData;
import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.service.AirStationTestingDataService;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "空气站实时数据")
@RequestMapping("/airstationtestingdata")
@RestController
public class AirStationTestingDataController {
	@Resource
	private AirStationTestingDataService airStationTestingDataService;
	
	/**
	 * 查找所有的，实时，分页
	 * @return
	 */
	@RequestMapping(value = "/queryTestingDataPage",method = RequestMethod.POST)
	@ApiOperation(value = "查找所有的，实时，分页")
	public Object queryAirStationPage(Integer curPage, Integer pageSize, AirStationTestingData airStationTestingData) {
		return airStationTestingDataService.queryAirStationPage(curPage,pageSize, airStationTestingData);
	}
	//-----------------------------------------导出报表------------------------------------------------
	/**
	 * voc， 报表
	 * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 
	 */
	@RequestMapping(value = "/airQuery",method = RequestMethod.POST)
	@ApiOperation(value = "* voc， 报表\n" +
			"\t * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 ")
	public Object airQuery(Integer curPage, Integer pageSize, String stationCode, Integer bbtype, String sd, String ed) {
		return airStationTestingDataService.airQuery(curPage,pageSize, stationCode, bbtype, sd, ed);
	}
}
