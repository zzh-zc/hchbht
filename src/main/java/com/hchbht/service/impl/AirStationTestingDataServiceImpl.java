package com.hchbht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.AirStationTestingDataMapper;
import com.hchbht.model.air.AirStationTestingData;
import com.hchbht.service.AirStationTestingDataService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirStationTestingDataServiceImpl implements AirStationTestingDataService {
	@Resource
	private AirStationTestingDataMapper airStationTestingDataMapper;
	
	/**
	 * 查找所有的，实时，分页
	 * @return
	 */
	public Object queryAirStationPage(Integer curPage, Integer pageSize, AirStationTestingData airStationTestingData) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirStationTestingData> list =  airStationTestingDataMapper.queryLastDataKQZ(airStationTestingData);
		PageInfo<AirStationTestingData> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	public Object airQuery(Integer curPage, Integer pageSize, String stationCode, Integer bbtype, String sd, String ed) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		if (bbtype == 1) {
			sd = sd.replace("T", " ");
			ed = ed.replace("T", " ");
		}	
		List<AirStationTestingData> list = airStationTestingDataMapper.queryBaoBiao(stationCode, bbtype, sd, ed);
		PageInfo<AirStationTestingData> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
