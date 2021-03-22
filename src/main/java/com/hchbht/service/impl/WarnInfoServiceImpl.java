package com.hchbht.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.WarnInfoMapper;
import com.hchbht.model.Menu;
import com.hchbht.model.WarnInfo;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.service.WarnInfoService;
import com.hchbht.utils.DateUtils;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WarnInfoServiceImpl implements WarnInfoService {
	@Autowired
	private WarnInfoMapper warnInfoMapper;
	
	/**
	 * 添加
	 */
	public Object insert(WarnInfo warnInfo) {
		warnInfo.setId(UUID.randomUUID().toString());
		String time = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
		warnInfo.setHappentime(DateUtils.parseDate(time, "yyyy-MM-dd HH:mm:ss"));
		warnInfo.setIsdispose(0);
		warnInfoMapper.insert(warnInfo);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 删除
	 */
	public Object delete(String id) {
		warnInfoMapper.deleteByPrimaryKey(id);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改
	 */
	public Object update(WarnInfo warnInfo) {
		//生成日期对象
		Date current_date = new Date();
		//设置日期格式化样式为：yyyy-MM-dd
		SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//格式化当前日期
		String d = SimpleDateFormat.format(current_date.getTime());

		System.out.println(d);

		Date dd = null;
		try {
			dd = SimpleDateFormat.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(dd.toString());

		//处理时间
		warnInfo.setDisposetime(dd);
		warnInfoMapper.updateByPrimaryKey(warnInfo);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(WarnInfo warnInfo) {
		WarnInfo w = warnInfoMapper.queryDataByCondition(warnInfo);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, w);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(WarnInfo warnInfo) {
		List<WarnInfo> list = warnInfoMapper.queryDataByConditions(warnInfo);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, WarnInfo warnInfo) {
		System.out.println("chooseId : " + warnInfo.getChooseId());
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//字段乱码处理
		//companyInfo = (CompanyInfo) CodeConversionUtils.ObjectConversion(companyInfo, "utf-8");
		List<WarnInfo> list = warnInfoMapper.queryDataByConditionsPage(warnInfo);
		PageInfo<WarnInfo> page = new PageInfo<>(list);
		return page;
	}
	
	/**
	 * 统计预警未处理的条数
	 */
	public Object queryDataSize() {
		int n = warnInfoMapper.queryDataSize();
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, n);
	}
}
