package com.hchbht.service;

import com.github.pagehelper.PageInfo;
import com.hchbht.model.TjHchbdbCompanyInfo;

public interface CompanyInfoService {
	/**
	 * 添加单位
	 */
	public Object insertCompanyInfo(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 修改单位
	 */
	public Object updateCompanyInfo(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 删除单位
	 */
	public Object deleteCompanyInfo(String id);
	
	/**
	 * 查询有多少家企业
	 */
	public Object queryDataSize(int companytype);
	
	/**
	 * 查询所有单位信息
	 */
	public PageInfo<TjHchbdbCompanyInfo> queryALLCompanyInfoPage(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据条件查询，唯一的单位信息
	 */
	public Object queryCompanyInfoByCondition(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据条件查询，单位信息，list
	 */
	public Object queryCompanyInfoByConditions(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据条件查询，唯一的单位信息 , 实时工况使用
	 */
	public Object queryCompanyInfoByConditionGK(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据条件查询，单位信息，list 实时工况使用
	 */
	public Object queryCompanyInfoByConditionsGK(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据条件查询，单位信息，list，添加设备选择所属企业项使用
	 */
	public Object queryALLCompanyInfo(TjHchbdbCompanyInfo companyInfo);
}
