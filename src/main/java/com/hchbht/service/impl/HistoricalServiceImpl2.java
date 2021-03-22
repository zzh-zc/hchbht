package com.hchbht.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hchbht.model.TjHchbdbCompanyInfo;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.CompanyInfoMapper;
import com.hchbht.mapper.HistoricalDayMapper;
import com.hchbht.mapper.HistoricalHoursMapper;
import com.hchbht.mapper.HistoricalMinutesMapper;
import com.hchbht.mapper.HistoricalMonthMapper;
import com.hchbht.mapper.LampblackHistoricalHoursValueMapper;
import com.hchbht.model.Equipment;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import com.hchbht.model.monitoring.LampblackMonitoringValue;
import com.hchbht.model.monitoring.WorkingConditionValue;
import com.hchbht.service.HistoricalService2;

@Service
public class HistoricalServiceImpl2 implements HistoricalService2 {
	@Resource
	private HistoricalDayMapper historicalDayMapper;		//历史天数据，每家企业单个的  历史 天 数据
	@Resource
	private HistoricalMonthMapper historicalMonthMapper;	//历史月数据，每家企业单个的 历史 月 数据
	
	//--------------------------------------历史天数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，天	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteHistoricalDayVOC(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(1);
		List<TjHchbdbCompanyInfo> list = historicalDayMapper.queryComapnyVoc(companyInfo);
		//更换内容
		List<AirHistoricalHoursVOC> alist = getListVoc(list);
		PageInfo<AirHistoricalHoursVOC> pageInfo = new PageInfo<>(alist);
		return pageInfo;
		//return airHistoricalMinutesVOCMapper.queryLastDataVoc(companyInfo);
	}
	
	/**
	 * 工业污染，工业废气，历史数据，天	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteHistoricalDayVOC2(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirHistoricalHoursVOC> list = historicalDayMapper.queryDataByConditionsPageVoc(companyInfo);
		PageInfo<AirHistoricalHoursVOC> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	/**
	 * 工业污染，工业废气，历史数据，天	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteWorkingHistoricalDay(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//return workingHistoricalMinutesValueMapper.queryLastDataWork(companyInfo);
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(2);
		List<TjHchbdbCompanyInfo> list = historicalDayMapper.queryComapnyWork(companyInfo);
		//更换内容
		List<WorkingHistoricalHoursValue> alist = getListWork(list);
		PageInfo<WorkingHistoricalHoursValue> pageInfo =  new PageInfo<>(alist);
		return pageInfo;
	}
	
	/**
	 * 工业污染，工业废气，历史数据，天	工况
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteWorkingHistoricalDay2(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//从数据库中查询
		List<WorkingHistoricalHoursValue> list = historicalDayMapper.queryDataByConditionsPageWork(companyInfo);
		
		PageInfo<WorkingHistoricalHoursValue> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	/**
	 * 环境质量，气，油气，历史数据，天
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryLampblackHistoricalDayGas(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(3);
		List<TjHchbdbCompanyInfo> list = historicalDayMapper.queryComapnyLamp(companyInfo);
		//更换内容
		List<LampblackHistoricalHoursValue> alist = getListLamp(list);	

		PageInfo<LampblackHistoricalHoursValue> pageInfo = new PageInfo<>(alist);
		return pageInfo;
		//return lampblackHistoricalMinutesValueMapper.queryLastDataLamp(companyInfo);
	}
	
	/**
	 * 环境质量，气，油气，历史数据，天
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryLampblackHistoricalDayGas2(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<LampblackHistoricalHoursValue> list = historicalDayMapper.queryDataByConditionsPageLamp(companyInfo);
		PageInfo<LampblackHistoricalHoursValue> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}
	
	//--------------------------------------历史月数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，月	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteHistoricalMonthVOC(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(1);
		List<TjHchbdbCompanyInfo> list = historicalMonthMapper.queryComapnyVoc(companyInfo);
		//更换内容
		List<AirHistoricalHoursVOC> alist = getListVoc(list);
		//针对更换后的内容分页
		PageInfo<AirHistoricalHoursVOC> pageInfo =  new PageInfo<>(alist);
		return pageInfo;
		//return airHistoricalHoursVOCMapper.queryLastDataVoc(companyInfo);
	}
	
	/**
	 * 工业污染，工业废气，历史数据，月	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteHistoricalMonthVOC2(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirHistoricalHoursVOC> list = historicalMonthMapper.queryDataByConditionsPageVoc(companyInfo);
		PageInfo<AirHistoricalHoursVOC> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	/**
	 * 工业污染，工业废气，历史数据，月	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteWorkingHistoricalMonth(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//return workingHistoricalHoursValueMapper.queryLastDataWork(companyInfo);
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(2);
		List<TjHchbdbCompanyInfo> list = historicalMonthMapper.queryComapnyWork(companyInfo);
		//更换内容
		List<WorkingHistoricalHoursValue> alist = getListWork(list);
		PageInfo<WorkingHistoricalHoursValue> pageInfo = new PageInfo<>(alist);
		return pageInfo;
		
	}
	
	/**
	 * 工业污染，工业废气，历史数据，月	工况
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteWorkingHistoricalMonth2(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//从数据库中查询
		List<WorkingHistoricalHoursValue> list = historicalMonthMapper.queryDataByConditionsPageWork(companyInfo);
		
		PageInfo<WorkingHistoricalHoursValue> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	/**
	 * 环境质量，气，油气，历史数据，月
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryLampblackHistoricalMonthGas(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(3);
		List<TjHchbdbCompanyInfo> list = historicalMonthMapper.queryComapnyLamp(companyInfo);
		//更换内容
		List<LampblackHistoricalHoursValue> alist = getListLamp(list);
		//针对更换后的内容分页
		PageInfo<LampblackHistoricalHoursValue> pageInfo = new PageInfo<>(alist);
		return pageInfo;
		//return lampblackHistoricalHoursValueMapper.queryLastDataLamp(companyInfo);
	}
	
	/**
	 * 环境质量，气，油气，历史数据，月
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryLampblackHistoricalMonthGas2(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		
		List<LampblackHistoricalHoursValue> list = historicalMonthMapper.queryDataByConditionsPageLamp(companyInfo);
		PageInfo<LampblackHistoricalHoursValue> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	//----------------------------------------------------类型转换-----------------------------------------------
	//内容替换，voc 月
	public List<AirHistoricalHoursVOC> getListVoc(List<TjHchbdbCompanyInfo> list) {
		List<AirHistoricalHoursVOC> alist = new ArrayList<AirHistoricalHoursVOC>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getHvoc());
		}
		return alist;
	}
	//内容替换，工况
	public List<WorkingHistoricalHoursValue> getListWork(List<TjHchbdbCompanyInfo> list) {
		List<WorkingHistoricalHoursValue> alist = new ArrayList<WorkingHistoricalHoursValue>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getHwork());
		}
		return alist;
	}
	//内容替换，油烟
	public List<LampblackHistoricalHoursValue> getListLamp(List<TjHchbdbCompanyInfo> list) {
		List<LampblackHistoricalHoursValue> alist = new ArrayList<LampblackHistoricalHoursValue>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getHlamp());
		}
		return alist;
	}
}
