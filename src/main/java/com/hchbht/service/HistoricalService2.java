package com.hchbht.service;


import com.hchbht.model.TjHchbdbCompanyInfo;

public interface HistoricalService2 {
	//--------------------------------------历史天数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，分钟	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteHistoricalDayVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteHistoricalDayVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业污水，历史数据，分钟
	 */
	//public Object queryWasteHistoricalDayWater(PageInfo pageInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteWorkingHistoricalDay(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	工况
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteWorkingHistoricalDay2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，油气，历史数据，分钟
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryLampblackHistoricalDayGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，油气，历史数据，分钟
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryLampblackHistoricalDayGas2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
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
	 * 工业污染，工业废气，历史数据，小时	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteHistoricalMonthVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，小时	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteHistoricalMonthVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业污水，历史数据，小时
	 */
	//public Object queryWasteHistoricalDayWater(PageInfo pageInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，小时	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteWorkingHistoricalMonth(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 工业污染，工业废气，历史数据，小时	工况
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteWorkingHistoricalMonth2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，油气，历史数据，小时
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryLampblackHistoricalMonthGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，油气，历史数据，小时
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryLampblackHistoricalMonthGas2(Integer curPage,Integer pageSize,  TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环境质量，气，历史数据
	 */
	//public Object queryEnvironmentalGas();
	
	/**
	 * 环境质量，水，历史数据
	 */
	//public Object queryEnvironmentalWater();
}
