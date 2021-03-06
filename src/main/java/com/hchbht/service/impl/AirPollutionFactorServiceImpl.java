package com.hchbht.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hchbht.mapper.AirPollutionFactorMapper;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import org.springframework.stereotype.Service;

import com.hchbht.model.AirPollutionFactor;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.service.AirPollutionFactorService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirPollutionFactorServiceImpl implements AirPollutionFactorService{
	@Resource
	private AirPollutionFactorMapper airPollutionFactorMapper;
	/**
	 * 添加
	 */
	public Object insertAirPollutionFactor(AirPollutionFactor airPollutionFactor) {
		airPollutionFactor.setId(UUID.randomUUID().toString());
		airPollutionFactorMapper.insert(airPollutionFactor);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 删除
	 */
	public Object deleteAirPollutionFactor(String apfid) {
		airPollutionFactorMapper.deleteByPrimaryKey(apfid);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改
	 */
	public Object updateAirPollutionFactor(AirPollutionFactor airPollutionFactor) {
		airPollutionFactorMapper.updateByPrimaryKey(airPollutionFactor);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 根据id, 查找相应的空气污染因子
	 * @return
	 */
	public Object queryAirPollutionFactorByApfId(String id) {
		AirPollutionFactor list = airPollutionFactorMapper.selectByPrimaryKey(id);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);
	}
	
	/**
	 * 查找所有的，分页
	 * @return
	 */
	public PageInfo<AirPollutionFactor> queryAirPollutionFactorPage(Integer curPage, Integer pageSize, AirPollutionFactor airPollutionFactor) {
		//设置分页器
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirPollutionFactor> list = airPollutionFactorMapper.select(airPollutionFactor);
		PageInfo<AirPollutionFactor> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
