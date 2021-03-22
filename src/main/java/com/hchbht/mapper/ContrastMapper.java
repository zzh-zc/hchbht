package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;

/**
 * 环比统计
 */
public interface ContrastMapper {
	
	/**
	 * 环比 VOC 数据
	 */
	public List<AirHistoricalMinutesVOC> contrastDataVOCMinutes(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比 VOC 数据
	 */
	public List<AirHistoricalHoursVOC> contrastDataVOC(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，今天和昨天的对比，工况
	 */
	public List<WorkingHistoricalMinutesValue> contrastWorkMinutes(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，小时对比，工况
	 */
	public List<WorkingHistoricalHoursValue> contrastWork(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，今天和昨天的对比，油烟
	 */
	public List<LampblackHistoricalMinutesValue> contrastLampMinutes(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 环比统计，小时对比，油烟
	 */
	public List<LampblackHistoricalHoursValue> contrastLamp(TjHchbdbCompanyInfo companyInfo);
}
