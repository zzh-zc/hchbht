package com.hchbht.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hchbht.mapper.Monitoring3Mapper;
import com.hchbht.mapper.WarnConditionVOCMapper;
import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.WarnConditionVOC;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hchbht.cache.RedisCacheUtils;
import com.hchbht.service.MonitoringService3;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService3Impl implements MonitoringService3 {
	@Autowired
	private Monitoring3Mapper monitoring3Mapper;
	@Autowired
	protected RedisCacheUtils redisCacheUtils;
	@Autowired
	private WarnConditionVOCMapper warnConditionVOCMapper;

	/**
	 * voc实时数据
	 */
	public PageInfo<AirMonitoringVOC> queryLastDataVoc(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//设置分页器
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirMonitoringVOC> list = monitoring3Mapper.queryLastDataVoc(companyInfo);
		//因子检测
		List<AirMonitoringVOC> alist = getIsListVoc(list);
		PageInfo<AirMonitoringVOC> pageInfo = new PageInfo<>(alist);
		return pageInfo;
	}


	//-----------------------------------------------------------------------------------------------------------
	//判断检测因子是否正常
	public List<AirMonitoringVOC> getIsListVoc(List<AirMonitoringVOC> list) {
		List<AirMonitoringVOC> alist = new ArrayList<AirMonitoringVOC>();
		//循环判断
		for (AirMonitoringVOC voc : list) {
			String equipmentid = voc.getEquipmentid();
			//获取Redis中存储的标准
			WarnConditionVOC warn  = warnConditionVOCMapper.queryDataByEid(equipmentid);
			if(warn!=null){
				voc = getResultsVOC(voc, warn);
			}
			alist.add(voc);
		}
		return alist;
	}

	//woc 对比
	public AirMonitoringVOC getResultsVOC(AirMonitoringVOC voc, WarnConditionVOC warn) {
		//碳氢化合物
		if (StringUtils.isNotBlank(voc.getHydrocarbon()) && !"null".equals(voc.getHydrocarbon()) && Double.valueOf(voc.getHydrocarbon()) >= Double.valueOf(warn.getHydrocarbon())) {
			voc.setIshydrocarbon(0);
		}
		//烟气流速
		if (StringUtils.isNotBlank(voc.getRate()) && !"null".equals(voc.getRate()) &&  Double.valueOf(voc.getRate()) >= Double.valueOf(warn.getRate())) {
			voc.setIsrate(0);
		}
		//烟气温度
		if (StringUtils.isNotBlank(voc.getTemperature()) && !"null".equals(voc.getTemperature()) &&  Double.valueOf(voc.getTemperature()) >= Double.valueOf(warn.getTemperature())) {
			voc.setIstemperature(0);
		}
		//烟气压力
		if (StringUtils.isNotBlank(voc.getPressure()) && !"null".equals(voc.getPressure()) &&  Double.valueOf(voc.getPressure()) >= Double.valueOf(warn.getPressure())) {
			voc.setIspressure(0);
		}
		//烟气湿度
		if (StringUtils.isNotBlank(voc.getHumidity()) && !"null".equals(voc.getHumidity()) &&  Double.valueOf(voc.getHumidity()) >= Double.valueOf(warn.getHumidity())) {
			voc.setIshumidity(0);
		}
		//废气总量
		if (StringUtils.isNotBlank(voc.getWastegas()) && !"null".equals(voc.getWastegas()) &&  Double.valueOf(voc.getWastegas()) >= Double.valueOf(warn.getWastegas())) {
			voc.setIswastegas(0);
		}
		return voc;
	}
}