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
import com.hchbht.mapper.WarnConditionLampblackMapper;
import com.hchbht.model.WarnConditionLampblack;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.service.WarnConditionLampblackService;

@Service("warnConditionLampblackServiceImpl")
public class WarnConditionLampblackServiceImpl implements WarnConditionLampblackService {
	@Resource
	private WarnConditionLampblackMapper warnConditionLampblackMapper;
	@Autowired
    protected RedisCacheUtils redisCacheUtils;
	
	/**
	 * 添加
	 */
	public Object insert(WarnConditionLampblack warnConditionLampblack) {
		String equipmentid = warnConditionLampblack.getEquipmentid();
		//是否不为空，1： 是， 不为空；0： 否， 为空
		if (StringUtils.isNotEmpty(equipmentid)) {
			warnConditionLampblack.setId(UUID.randomUUID().toString());
			warnConditionLampblackMapper.insert(warnConditionLampblack);
			//添加成功了之后把新添加的存在Redis
			WarnConditionLampblack work = warnConditionLampblackMapper.queryDataByEid(equipmentid);
			redisCacheUtils.setCacheObject(equipmentid, work);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
		} else {
			return new AjaxResult(true, "设备id不能为空");
		}
	}
	
	/**
	 * 删除
	 */
	public Object delete(String id, String equipmentid) {
		warnConditionLampblackMapper.delete(id);
		//相对用的Redis也要删除
		redisCacheUtils.delete(equipmentid);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改
	 */
	public Object update(WarnConditionLampblack warnConditionLampblack) {
			warnConditionLampblackMapper.update(warnConditionLampblack);
			String equipmentid = warnConditionLampblack.getEquipmentid();
			redisCacheUtils.delete(equipmentid);
			redisCacheUtils.setCacheObject(equipmentid, warnConditionLampblack);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(WarnConditionLampblack warnConditionLampblack) {
			WarnConditionLampblack w = warnConditionLampblackMapper.queryDataByCondition(warnConditionLampblack);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE, w);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(WarnConditionLampblack warnConditionLampblack) {
			List<WarnConditionLampblack> list = warnConditionLampblackMapper.queryDataByConditions(warnConditionLampblack);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, WarnConditionLampblack warnConditionLampblack) {
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//字段乱码处理
		//companyInfo = (CompanyInfo) CodeConversionUtils.ObjectConversion(companyInfo, "utf-8");
		List<WarnConditionLampblack> list = warnConditionLampblackMapper.queryDataByConditionsPage(warnConditionLampblack);
		PageInfo<WarnConditionLampblack> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
