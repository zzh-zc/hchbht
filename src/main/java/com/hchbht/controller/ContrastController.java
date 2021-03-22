package com.hchbht.controller;

import javax.annotation.Resource;

import com.hchbht.model.TjHchbdbCompanyInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.service.ContrastService;
import org.springframework.web.bind.annotation.RestController;

/**
 * 环比统计 controller 
 * @author Administrator
 *
 */
@RequestMapping("/contrast")
@RestController
@Api(tags = "环比统计")
public class ContrastController {
	@Resource
	private ContrastService contrastService;
	
	/**
	 * 环比统计，今天和昨天的对比，VOC
	 * @return
	 */
	@PostMapping("/contrastVOCMinutes")
	@ApiOperation(value = "环比统计，今天和昨天的对比，VOC")
	public Object contrastVOCMinutes(TjHchbdbCompanyInfo companyInfo) {
		return contrastService.contrastVOCMinutes(companyInfo);
	}
	
	/**
	 * 环比统计，小时对比，VOC
	 * @return
	 */
	@PostMapping("/contrastVOC")
	@ApiOperation(value = "环比统计，小时对比，VOC")
	public Object contrastVOC(TjHchbdbCompanyInfo companyInfo) {
		return contrastService.contrastVOC(companyInfo);
	}
	
	/**
	 * 环比统计，今天和昨天的对比，工况
	 * @return
	 */
	@PostMapping("/contrastWorkMinutes")
	@ApiOperation(value = "环比统计，今天和昨天的对比，工况")
	public Object contrastWorkMinutes(TjHchbdbCompanyInfo companyInfo) {
		return contrastService.contrastWorkMinutes(companyInfo);
	}
	
	/**
	 * 环比统计，小时对比，工况
	 * @return
	 */
	@PostMapping("/contrastWork")
	@ApiOperation(value = "环比统计，小时对比，工况")
	public Object contrastWork(TjHchbdbCompanyInfo companyInfo) {
		return contrastService.contrastWork(companyInfo);
	}
	
	/**
	 * 环比统计，今天和昨天的对比，油烟
	 * @return
	 */
	@PostMapping("/contrastLampMinutes")
	@ApiOperation(value = "环比统计，今天和昨天的对比，油烟")
	public Object contrastLampMinutes(TjHchbdbCompanyInfo companyInfo) {
		return contrastService.contrastLampMinutes(companyInfo);
	}
	
	/**
	 * 环比统计，小时对比，油烟
	 * @return
	 */
	@PostMapping("/contrastLamp")
	@ApiOperation(value = "环比统计，小时对比，油烟")
	public Object contrastLamp(TjHchbdbCompanyInfo companyInfo) {
		return contrastService.contrastLamp(companyInfo);
	}
}
