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
import com.hchbht.mapper.WarnConditionVOCMapper;
import com.hchbht.model.WarnConditionLampblack;
import com.hchbht.model.WarnConditionVOC;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.service.WarnConditionVOCService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WarnConditionVOCServiceImpl implements WarnConditionVOCService {
	@Autowired
	private WarnConditionVOCMapper warnConditionVOCMapper;
	@Autowired
    protected RedisCacheUtils redisCacheUtils;
	
	/**
	 * 添加
	 */
	public Object insert(WarnConditionVOC warnConditionVOC) {
			String equipmentid = warnConditionVOC.getEquipmentid();
			//是否不为空，1： 是， 不为空；0： 否， 为空
			if (StringUtils.isNotEmpty(equipmentid)) {
				warnConditionVOC.setId(UUID.randomUUID().toString());
				warnConditionVOCMapper.insert(warnConditionVOC);
				//添加成功了之后把新添加的存在Redis
//				WarnConditionVOC work = warnConditionVOCMapper.queryDataByEid(equipmentid);
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
			warnConditionVOCMapper.deleteByPrimaryKey(id);
			//相对用的Redis也要删除
//			redisCacheUtils.delete(equipmentid);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改
	 */
	public Object update(WarnConditionVOC warnConditionVOC) {
			warnConditionVOCMapper.updateByPrimaryKey(warnConditionVOC);
			String equipmentid = warnConditionVOC.getEquipmentid();
//			redisCacheUtils.delete(equipmentid);
//			redisCacheUtils.setCacheObject(equipmentid, warnConditionVOC);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(WarnConditionVOC warnConditionVOC) {
			WarnConditionVOC w = warnConditionVOCMapper.queryDataByCondition(warnConditionVOC);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE, w);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(WarnConditionVOC warnConditionVOC) {
			List<WarnConditionVOC> list = warnConditionVOCMapper.queryDataByConditions(warnConditionVOC);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, WarnConditionVOC warnConditionVOC) {
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//字段乱码处理
		//companyInfo = (CompanyInfo) CodeConversionUtils.ObjectConversion(companyInfo, "utf-8");
		List<WarnConditionVOC> list = warnConditionVOCMapper.queryDataByConditionsPage(warnConditionVOC);
		PageInfo<WarnConditionVOC> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
