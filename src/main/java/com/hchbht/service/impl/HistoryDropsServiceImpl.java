package com.hchbht.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.HistoryDropsMapper;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.model.historical.HistoryDrops;
import com.hchbht.service.HistoryDropsService;

@Service("historyDropsServiceImpl")
public class HistoryDropsServiceImpl implements HistoryDropsService {
	@Resource
	private HistoryDropsMapper historyDropsMapper;
	
	/**
	 * 添加
	 */
	public Object insert(HistoryDrops historyDrops) {
		historyDrops.setId(UUID.randomUUID().toString());
		historyDropsMapper.insert(historyDrops);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 删除
	 */
	public Object delete(String id) {
		historyDropsMapper.deleteByPrimaryKey(id);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改
	 */
	public Object update(HistoryDrops historyDrops) {
		//生成日期对象
		Date current_date = new Date();
		//设置日期格式化样式为：yyyy-MM-dd
		SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

		historyDropsMapper.updateByPrimaryKey(historyDrops);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 根据条件查询单个数据
	 */
	public Object queryDataByCondition(HistoryDrops historyDrops) {
		HistoryDrops w = historyDropsMapper.queryDataByCondition(historyDrops);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, w);
	}
	
	/**
	 * 根据条件查询  list 数据
	 */
	public Object queryDataByConditions(HistoryDrops historyDrops) {
		List<HistoryDrops> list = historyDropsMapper.queryDataByConditions(historyDrops);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);
	}
	
	/**
	 * 根据条件查询  Page 数据
	 */
	public Object queryDataByConditionsPage(Integer curPage,Integer pageSize, HistoryDrops historyDrops) {
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<HistoryDrops> list = historyDropsMapper.queryDataByConditions(historyDrops);
		PageInfo<HistoryDrops> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
