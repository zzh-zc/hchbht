package com.hchbht.controller;

import javax.annotation.Resource;

import com.hchbht.service.CompanyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.hchbht.model.TjHchbdbCompanyInfo;

@Api(tags = "企业信息")
@RequestMapping("/companyInfo")
@RestController
public class CompanyInfoController {
	@Resource
	private CompanyInfoService companyInfoService;
	
	/**
	 * 添加单位
	 */
	@ApiOperation(value = "添加单位")
	@RequestMapping(value = "/insertCompanyInfo",method = RequestMethod.POST)
	public Object insertCompanyInfo(TjHchbdbCompanyInfo companyInfo) {
		return companyInfoService.insertCompanyInfo(companyInfo);
	}
	
	/**
	 * 修改单位
	 */
	@ApiOperation(value = "修改单位")
	@RequestMapping(value = "/updateCompanyInfo",method = RequestMethod.POST)
	public Object updateCompanyInfo(TjHchbdbCompanyInfo companyInfo) {
		return companyInfoService.updateCompanyInfo(companyInfo);
	}
	
	/**
	 * 删除单位
	 */
	@ApiOperation(value = "删除单位")
	@RequestMapping(value = "/deleteCompanyInfo",method = RequestMethod.POST)
	public Object deleteCompanyInfo(String id) {
		return companyInfoService.deleteCompanyInfo(id);
	}
	
	/**
	 * 查询有多少家企业
	 */
	@ApiOperation(value = "查询有多少家企业")
	@RequestMapping(value = "/queryDataSize",method = RequestMethod.POST)
	public Object queryDataSize(int companytype) {
		return companyInfoService.queryDataSize(companytype);
	}
	
	/**
	 * 查询所有单位信息
	 */
	@ApiOperation(value = "查询所有单位信息",notes = "curPage: 页码（可空，和pageSize一起传值才有用）\n"+
			"pageSize: 页大小（可空，和curPage一起传值才有用）")
	@RequestMapping(value = "/queryALLCompanyInfoPage",method = RequestMethod.POST)
	public Object queryALLCompanyInfoPage(@RequestParam(value = "curPage",required = false,defaultValue = "1") Integer curPage,
										  @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		return companyInfoService.queryALLCompanyInfoPage(curPage,pageSize, companyInfo);
	}
	
	/**
	 * 根据条件查询，唯一的单位信息
	 */
	@ApiOperation(value = "根据条件查询，唯一的单位信息")
	@RequestMapping(value = "/queryCompanyInfoByCondition",method = RequestMethod.POST)
	public Object queryCompanyInfoByCondition(TjHchbdbCompanyInfo companyInfo) {
		return companyInfoService.queryCompanyInfoByCondition(companyInfo);
	}
	
	/**
	 * 根据条件查询，单位信息，list，加设备产生的浓度
	 */
	@ApiOperation(value = "根据条件查询，单位信息，list，加设备产生的浓度")
	@RequestMapping(value = "/queryCompanyInfoByConditions",method = RequestMethod.POST)
	public Object queryCompanyInfoByConditions(TjHchbdbCompanyInfo companyInfo) {
		return companyInfoService.queryCompanyInfoByConditions(companyInfo);
	}
	
	/**
	 * 根据条件查询，唯一的单位信息 实施工况页面使用
	 */
	@ApiOperation(value = "根据条件查询，唯一的单位信息 实时工况页面使用")
	@RequestMapping(value = "/queryCompanyInfoByConditionGK",method = RequestMethod.POST)
	public Object queryCompanyInfoByConditionGK(TjHchbdbCompanyInfo companyInfo) {
		return companyInfoService.queryCompanyInfoByConditionGK(companyInfo);
	}
	
	/**
	 * 根据条件查询，单位信息，list，实施工况页面使用
	 */
	@ApiOperation(value = "根据条件查询，单位信息，list，实时工况页面使用")
	@RequestMapping(value = "/queryCompanyInfoByConditionsGK",method = RequestMethod.POST)
	public Object queryCompanyInfoByConditionsGK(TjHchbdbCompanyInfo companyInfo) {
		return companyInfoService.queryCompanyInfoByConditionsGK(companyInfo);
	}
	
	/**
	 * 根据条件查询，单位信息，list，添加设备选择所属企业项使用
	 */
	@ApiOperation(value = "根据条件查询，单位信息，list，添加设备选择所属企业项使用")
	@RequestMapping(value = "/queryALLCompanyInfo",method = RequestMethod.POST)
	public Object queryALLCompanyInfo(TjHchbdbCompanyInfo companyInfo) {
		return companyInfoService.queryALLCompanyInfo(companyInfo);
	}
}
