package com.hchbht.service;


import com.hchbht.model.TjHchbdbCompanyInfo;

public interface ContrastService {
	/**
	 * 环比统计，今天和昨天的对比，VOC
	 */
	public Object contrastVOCMinutes(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，小时对比，VOC
	 */
	public Object contrastVOC(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，今天和昨天的对比，工况
	 */
	public Object contrastWorkMinutes(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，小时对比，工况
	 */
	public Object contrastWork(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，今天和昨天的对比，油烟
	 */
	public Object contrastLampMinutes(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，小时对比，油烟
	 */
	public Object contrastLamp(TjHchbdbCompanyInfo companyInfo);
}
