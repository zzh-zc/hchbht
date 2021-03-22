package com.hchbht.controller;

import java.util.List;

import javax.annotation.Resource;

import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.service.HistoricalService2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.service.HistoricalService;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/historical")
@RestController
@Api(tags = "历史监测")
public class HistoricalController {
	@Resource
	private HistoricalService historicalService;//历史数据
	@Resource
	private HistoricalService2 historicalService2;//历史数据
	//--------------------------------------历史分钟数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，分钟	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "工业污染-voc-分钟" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryWasteHistoricalMinutesVOC")
	public Object queryWasteHistoricalMinutesVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		System.out.println("-------------------------------------");
		return historicalService.queryWasteHistoricalMinutesVOC(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "工业污染-voc-分钟" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryWasteHistoricalMinutesVOC2")
	public Object queryWasteHistoricalMinutesVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryWasteHistoricalMinutesVOC2(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 工业污染，工业污水，历史数据，分钟
	 */
	//public Object queryWasteHistoricalMinutesWater(PageInfo pageInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "工业污染-工况-分钟" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryWasteWorkingHistoricalMinutes")
	public Object queryWasteWorkingHistoricalMinutes(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryWasteWorkingHistoricalMinutes(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	工况
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "工业污染-工况-分钟" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryWasteWorkingHistoricalMinutes2")
	public Object queryWasteWorkingHistoricalMinutes2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryWasteWorkingHistoricalMinutes2(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 环境质量，气，油气，历史数据，分钟
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "环境质量-油烟-分钟" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryLampblackHistoricalMinutesGas")
	public Object queryLampblackHistoricalMinutesGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return  historicalService.queryLampblackHistoricalMinutesGas(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 环境质量，气，油气，历史数据，分钟
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "环境质量-油烟-分钟" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryLampblackHistoricalMinutesGas2")
	public Object queryLampblackHistoricalMinutesGas2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryLampblackHistoricalMinutesGas2(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 环境质量，气，历史数据
	 */
	//public Object queryEnvironmentalGas();
	
	/**
	 * 环境质量，水，历史数据
	 */
	//public Object queryEnvironmentalWater();
	
	//--------------------------------------历史小时数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，小时	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "工业污染-VOC-小时" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryWasteHistoricalHoursVOC")
	public Object queryWasteHistoricalHoursVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryWasteHistoricalHoursVOC(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 工业污染，工业废气，历史数据，小时	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "工业污染-VOC-小时" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryWasteHistoricalHoursVOC2")
	public Object queryWasteHistoricalHoursVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryWasteHistoricalHoursVOC2(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 工业污染，工业污水，历史数据，小时
	 */
	//public Object queryWasteHistoricalMinutesWater(PageInfo pageInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，小时	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "工业污染-工况-小时" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryWasteWorkingHistoricalHours")
	public Object queryWasteWorkingHistoricalHours(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryWasteWorkingHistoricalHours(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 工业污染，工业废气，历史数据，小时	工况
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "工业污染-工况-小时" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryWasteWorkingHistoricalHours2")
	public Object queryWasteWorkingHistoricalHours2(Integer curPage,Integer pageSize,  TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryWasteWorkingHistoricalHours2(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 环境质量，气，油气，历史数据，小时
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "环境质量-油烟-小时" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryLampblackHistoricalHoursGas")
	public Object queryLampblackHistoricalHoursGas(Integer curPage,Integer pageSize,  TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryLampblackHistoricalHoursGas(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 环境质量，气，油气，历史数据，小时
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "环境质量-油烟-小时" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryLampblackHistoricalHoursGas2")
	public Object queryLampblackHistoricalHoursGas2(Integer curPage,Integer pageSize,  TjHchbdbCompanyInfo companyInfo) {
		return historicalService.queryLampblackHistoricalHoursGas2(curPage,pageSize, companyInfo);
	}

	//--------------------------------------历史天数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，天	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "工业污染-VOC-天" +
			"实时监控，每家企业最新的历史数据Voc")
	@PostMapping("/queryWasteHistoricalDayVOC")
	public Object queryWasteHistoricalDayVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		System.out.println("-------------------------------------");
		return historicalService2.queryWasteHistoricalDayVOC(curPage,pageSize,companyInfo);
	}

	/**
	 * 工业污染，工业废气，历史数据，天	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "工业污染-VOC-天" +
			"实时监控，每家企业全部历史数据Voc")
	@PostMapping("/queryWasteHistoricalDayVOC2")
	public Object queryWasteHistoricalDayVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryWasteHistoricalDayVOC2(curPage,pageSize,companyInfo);
	}

	/**
	 * 工业污染，工业污水，历史数据，天
	 */
	//public Object queryWasteHistoricalMinutesWater(PageInfo pageInfo);

	/**
	 * 工业污染，工业废气，历史数据，天	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "工业污染-工况-天" +
			"实时监控，每家企业最新的历史数据工况")
	@PostMapping("/queryWasteWorkingHistoricalDay")
	public Object queryWasteWorkingHistoricalDay(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryWasteWorkingHistoricalDay(curPage,pageSize,companyInfo);
	}

	/**
	 * 工业污染，工业废气，历史数据，天	工况
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "工业污染-工况-天" +
			"实时监控，每家企业全部历史数据工况")
	@PostMapping("/queryWasteWorkingHistoricalDay2")
	public Object queryWasteWorkingHistoricalDay2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryWasteWorkingHistoricalDay2(curPage,pageSize,companyInfo);
	}

	/**
	 * 环境质量，气，油气，历史数据，天
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "环境质量-油烟-天" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryLampblackHistoricalDayGas")
	public Object queryLampblackHistoricalDayGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return  historicalService2.queryLampblackHistoricalDayGas(curPage,pageSize,companyInfo);
	}

	/**
	 * 环境质量，气，油气，历史数据，天
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "环境质量-油烟-天" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryLampblackHistoricalDayGas2")
	public Object queryLampblackHistoricalDayGas2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryLampblackHistoricalDayGas2(curPage,pageSize,companyInfo);
	}

	/**
	 * 环境质量，气，历史数据
	 */
	//public Object queryEnvironmentalGas();

	/**
	 * 环境质量，水，历史数据
	 */
	//public Object queryEnvironmentalWater();

	//--------------------------------------历史月数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，月	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "工业污染-VOC-月" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryWasteHistoricalMonthVOC")
	public Object queryWasteHistoricalMonthVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryWasteHistoricalMonthVOC(curPage,pageSize,companyInfo);
	}

	/**
	 * 工业污染，工业废气，历史数据，月	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "工业污染-VOC-月" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryWasteHistoricalMonthVOC2")
	public Object queryWasteHistoricalMonthVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryWasteHistoricalMonthVOC2(curPage,pageSize,companyInfo);
	}

	/**
	 * 工业污染，工业污水，历史数据，月
	 */
	//public Object queryWasteHistoricalMinutesWater(PageInfo pageInfo);

	/**
	 * 工业污染，工业废气，历史数据，月	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "工业污染-工况-月" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryWasteWorkingHistoricalMonth")
	public Object queryWasteWorkingHistoricalMonth(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryWasteWorkingHistoricalMonth(curPage,pageSize,companyInfo);
	}

	/**
	 * 工业污染，工业废气，历史数据，月	工况
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "工业污染-工况-月" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryWasteWorkingHistoricalMonth2")
	public Object queryWasteWorkingHistoricalMonth2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryWasteWorkingHistoricalMonth2(curPage,pageSize,companyInfo);
	}

	/**
	 * 环境质量，气，油气，历史数据，月
	 * 实时监控，每家企业最新的历史数据
	 */
	@ApiOperation(value = "环境质量-油烟-月" +
			"实时监控，每家企业最新的历史数据")
	@PostMapping("/queryLampblackHistoricalMonthGas")
	public Object queryLampblackHistoricalMonthGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryLampblackHistoricalMonthGas(curPage,pageSize,companyInfo);
	}

	/**
	 * 环境质量，气，油气，历史数据，月
	 * 实时监控，每家企业全部历史数据
	 */
	@ApiOperation(value = "环境质量-油烟-月" +
			"实时监控，每家企业全部历史数据")
	@PostMapping("/queryLampblackHistoricalMonthGas2")
	public Object queryLampblackHistoricalMonthGas2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return historicalService2.queryLampblackHistoricalMonthGas2(curPage,pageSize,companyInfo);
	}


	//-----------------------------------------导出报表------------------------------------------------
	/**
	 * voc， 报表
	 * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 
	 */
	@ApiOperation(value = "voc， 报表" +
			"bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 ")
	@PostMapping("/vocHQuery")
	public Object vocHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed) {
		if (bbtype == 1) {
			sd = sd.replace("T", " ");
			ed = ed.replace("T", " ");
		}		
		return historicalService.vocHQuery(curPage,pageSize, equipmentid, bbtype, sd, ed);
	}
	/**
	 * 工况， 报表
	 * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 
	 */
	@ApiOperation(value = "工况， 报表" +
			"bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 ")
	@PostMapping("/workHQuery")
	public Object workHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed) {
		if (bbtype == 1) {
			sd = sd.replace("T", " ");
			ed = ed.replace("T", " ");
		}	
		return historicalService.workHQuery(curPage,pageSize, equipmentid, bbtype, sd, ed);
	}
	/**
	 * 油烟， 报表
	 * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 
	 */
	@ApiOperation(value = "油烟， 报表" +
			"bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 ")
	@PostMapping("/lampHQuery")
	public Object lampHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed) {
		if (bbtype == 1) {
			sd = sd.replace("T", " ");
			ed = ed.replace("T", " ");
		}	
		return historicalService.lampHQuery(curPage,pageSize, equipmentid, bbtype, sd, ed);
	}
}
