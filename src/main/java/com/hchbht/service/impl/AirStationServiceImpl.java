package com.hchbht.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.AirStationMapper;
import com.hchbht.model.air.AirStation;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.service.AirStationService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirStationServiceImpl implements AirStationService{
	@Resource
	private AirStationMapper airStationMapper;
	/**
	 * 添加
	 */
	public Object insertAirStation(AirStation airStation) {
		airStation.setId(UUID.randomUUID().toString());
		airStationMapper.insert(airStation);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}

	/**
	 * 删除
	 */
	public Object deleteAirStation(String id) {
		airStationMapper.deleteByPrimaryKey(id);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}

	/**
	 * 修改
	 */
	public Object updateAirStation(AirStation airStation) {
		airStationMapper.updateByPrimaryKey(airStation);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}

	/**
	 * 根据id, 查找相应的空气污染因子
	 * @return
	 */
	public Object queryAirStationByApfId(String id) {
		AirStation list = airStationMapper.selectByPrimaryKey(id);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);
	}

	/**
	 * 查找所有的，分页
	 * @return
	 */
	public PageInfo<AirStation> queryAirStationPage(Integer curPage, Integer pageSize, AirStation airStation) {
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirStation> list = airStationMapper.select(airStation);
		PageInfo<AirStation> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
