package com.hchbht.service;


import com.github.pagehelper.PageInfo;
import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.monitoring.AirMonitoringVOC;

public interface MonitoringService3 {
	/**
	 * voc实时数据
	 */
	public PageInfo<AirMonitoringVOC> queryLastDataVoc(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo);
	
}
