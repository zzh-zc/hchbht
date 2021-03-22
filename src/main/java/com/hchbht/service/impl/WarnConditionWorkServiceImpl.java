package com.hchbht.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hchbht.cache.RedisCacheUtils;
import com.hchbht.mapper.WarnConditionWorkMapper;
import com.hchbht.model.WarnConditionVOC;
import com.hchbht.model.WarnConditionWork;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.service.WarnConditionWorkService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WarnConditionWorkServiceImpl implements WarnConditionWorkService {
	@Autowired
	private WarnConditionWorkMapper warnConditionWorkMapper;
	@Autowired
    protected RedisCacheUtils redisCacheUtils;
	
	/**
	 * 添加
	 */
	public Object insert(WarnConditionWork warnConditionWork) {
		String equipmentid = warnConditionWork.getEquipmentid();
		//是否不为空，1： 是， 不为空；0： 否， 为空
		if (StringUtils.isNotEmpty(equipmentid)) {
			warnConditionWork.setId(UUID.randomUUID().toString());
			warnConditionWorkMapper.insert(warnConditionWork);
			//添加成功了之后把新添加的存在Redis
//				WarnConditionWork work = warnConditionWorkMapper.queryDataByEid(equipmentid);
//				redisCacheUtils.setCacheObject(equipmentid, work);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
		} else {
			return new AjaxResult(true, "设备id不能为空");
		}
	}
	
	/**
	 * 删除
	 */
	public Object delete(String id, String equipmentid) {
		warnConditionWorkMapper.deleteByPrimaryKey(id);
		//相对用的Redis也要删除
//		redisCacheUtils.delete(equipmentid);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改
	 */
	public Object update(WarnConditionWork warnConditionWork) {
		warnConditionWorkMapper.updateByPrimaryKey(warnConditionWork);
		String equipmentid = warnConditionWork.getEquipmentid();
//			redisCacheUtils.delete(equipmentid);
//			redisCacheUtils.setCacheObject(equipmentid, warnConditionWork);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(WarnConditionWork warnConditionWork) {
		WarnConditionWork w = warnConditionWorkMapper.queryDataByCondition(warnConditionWork);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, w);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(WarnConditionWork warnConditionWork) {
		List<WarnConditionWork> list = warnConditionWorkMapper.queryDataByConditions(warnConditionWork);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize,WarnConditionWork warnConditionWork) {
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//字段乱码处理
		//companyInfo = (CompanyInfo) CodeConversionUtils.ObjectConversion(companyInfo, "utf-8");
		List<WarnConditionWork> list = warnConditionWorkMapper.queryDataByConditionsPage(warnConditionWork);
		PageInfo<WarnConditionWork> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
