package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface Monitoring3Mapper {
	/**
	 * voc实时数据
	 */
	public List<AirMonitoringVOC> queryLastDataVoc(@Param(value = "companyInfo") TjHchbdbCompanyInfo companyInfo);
	
}
