package com.hchbht.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.CompanyInfo2Mapper;
import com.hchbht.mapper.CompanyInfoEquipmentMapper;
import com.hchbht.mapper.CompanyInfoMapper;
import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.CompanyInfoEquipment;
import com.hchbht.model.Equipment;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.service.CompanyInfoService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
public class CompanyInfoServiceImpl implements CompanyInfoService{
	@Resource
	private CompanyInfoMapper companyInfoMapper;
	@Resource
	private CompanyInfoEquipmentMapper companyInfoEquipmentMapper;
	@Resource
	private CompanyInfo2Mapper companyInfo2Mapper;
	/**
	 * 添加单位
	 */
	public AjaxResult insertCompanyInfo(TjHchbdbCompanyInfo companyInfo) {
		companyInfo.setId(UUID.randomUUID().toString());
		companyInfoMapper.insert(companyInfo);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 修改单位
	 */
	public AjaxResult updateCompanyInfo(TjHchbdbCompanyInfo companyInfo) {
		companyInfoMapper.updateByPrimaryKey(companyInfo);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 删除单位
	 */
	public AjaxResult deleteCompanyInfo(String id) {
		companyInfoMapper.deleteByPrimaryKey(id);
		CompanyInfoEquipment ce = new CompanyInfoEquipment();
		ce.setCompanyid(id);
		companyInfoEquipmentMapper.delete(ce);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE);
	}
	
	/**
	 * 查询有多少家企业
	 */
	public Object queryDataSize(int companytype) {
			//1、工业污染，工业废气；2、工业污染，工业废水；3、环境质量，气；4、环境质量，水
			Integer mtype = 0;
			Integer ctype = 0;
			if (companytype == 1) {
				mtype = 1;
				ctype = 1;
			} else if (companytype == 2) {
				mtype = 1;
				ctype = 2;
			} else if (companytype == 3) {
				mtype = 2;
				ctype = 1;
			} else {
				mtype = 2;
				ctype = 2;
			}
			TjHchbdbCompanyInfo c = new TjHchbdbCompanyInfo();
			c.setMtype(mtype);
			c.setCtype(ctype);
			int n = companyInfoMapper.selectCount(c);
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE, n);
	}
	
	/**
	 * 查询所有单位信息
	 */
	public PageInfo<TjHchbdbCompanyInfo> queryALLCompanyInfoPage(Integer curPage, Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		PageHelper.startPage(curPage, pageSize);
		//字段乱码处理
		//companyInfo = (CompanyInfo) CodeConversionUtils.ObjectConversion(companyInfo, "utf-8");
		List<TjHchbdbCompanyInfo> list = companyInfoMapper.select(companyInfo);
		PageInfo<TjHchbdbCompanyInfo> pageInfo = new PageInfo<TjHchbdbCompanyInfo>(list);
		return pageInfo;
	}
	
	/**
	 * 根据条件查询，唯一的单位信息
	 */
	public Object queryCompanyInfoByCondition(TjHchbdbCompanyInfo companyInfo) {
		Example example = new Example(TjHchbdbCompanyInfo.class);
		Example.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(companyInfo.getName())){
			criteria.andLike("contactName", "%"+companyInfo.getContactName()+"%");
		}
		if(StringUtils.isNotBlank(companyInfo.getAddress())){
			criteria.andLike("address", "%"+companyInfo.getAddress()+"%");
		}
		if(StringUtils.isNotBlank(companyInfo.getContactName())){
			criteria.andLike("contactName", "%"+companyInfo.getContactName()+"%");
		}
		TjHchbdbCompanyInfo cInfo = companyInfoMapper.selectOneByExample(example);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, cInfo);
	}
	
	/**
	 * 根据条件查询，单位信息，list
	 */
	public Object queryCompanyInfoByConditions(TjHchbdbCompanyInfo companyInfo) {
		//储存第一次查询数据
		List<TjHchbdbCompanyInfo> list = new ArrayList<TjHchbdbCompanyInfo>();
		//储存转换格式后的数据
		List<TjHchbdbCompanyInfo> clist = new ArrayList<TjHchbdbCompanyInfo>();
		//大模块类型 ，1、工业污染；2、环境质量
		if (companyInfo.getMtype() == 1) {
			list = companyInfo2Mapper.queryGywrGIS(companyInfo);//工业污染
		} else {
			list = companyInfo2Mapper.queryHjzlGIS(companyInfo);//环境质量
		}
		//统计第一次查询的数据有多少家企业
		clist = getList(list);
		//转换格式，每家企业有多少个设备
		clist = getSList(clist, list);

		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, clist);

	}
	
	/**
	 * 根据条件查询，唯一的单位信息 , 实时工况使用，
	 * 实时工况，根据企业id和设备id
	 */
	public Object queryCompanyInfoByConditionGK(TjHchbdbCompanyInfo companyInfo) {
			//储存第一次查询数据
			List<TjHchbdbCompanyInfo> list = new ArrayList<TjHchbdbCompanyInfo>();
			//储存转换格式后的数据
			List<TjHchbdbCompanyInfo> clist = new ArrayList<TjHchbdbCompanyInfo>();
			//返回传递过来的设备
			String eid = companyInfo.getEid();
			//截取设备最后一位
			String laste = eid.substring(eid.length()-1, eid.length());
			//根据最后一位判断，设备类型，1：voc, 2:工况, 3:油烟
			if ("V".equals(laste)) {
				companyInfo.setStype(1);
			}
			if ("G".equals(laste)) {
				companyInfo.setStype(2);
			}
			if ("Y".equals(laste)) {
				companyInfo.setStype(3);
			}
			list = companyInfo2Mapper.queryGKByCidAndEid(companyInfo);
			//统计第一次查询的数据有多少家企业
			clist = getList(list);
			//转换格式，每家企业有多少个设备
			clist = getSList(clist, list);
			
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE, clist);

	}
	
	/**
	 * 根据条件查询，单位信息，list 工况页面使用
	 */
	public Object queryCompanyInfoByConditionsGK(TjHchbdbCompanyInfo companyInfo) {
			//储存第一次查询数据
			List<TjHchbdbCompanyInfo> list = new ArrayList<TjHchbdbCompanyInfo>();
			//储存转换格式后的数据
			List<TjHchbdbCompanyInfo> clist = new ArrayList<TjHchbdbCompanyInfo>();
			//大模块类型 ，1、工业污染；2、环境质量
			if (companyInfo.getMtype() == 1) {
				list = companyInfo2Mapper.queryGywrGK(companyInfo);
			} else {
				list = companyInfo2Mapper.queryHjzlGK(companyInfo);
			}
			//统计第一次查询的数据有多少家企业
			clist = getList(list);
			//转换格式，每家企业有多少个设备
			clist = getSList(clist, list);
			
			return new AjaxResult(true, Constants.SUCCESS_MESSAGE, clist);

	}
	//返回链表中的企业
	public List<TjHchbdbCompanyInfo> getList(List<TjHchbdbCompanyInfo> list){
		List<TjHchbdbCompanyInfo> clist = new ArrayList<TjHchbdbCompanyInfo>();
		TjHchbdbCompanyInfo info = list.get(0);
		String id = info.getId();
		clist.add(info);
		
		int n = list.size();
		for (int i = 1; i < n; i++) {
			TjHchbdbCompanyInfo c = list.get(i);
			String l = c.getId();
			if (!id.equals(l)) {
				id = l;
				clist.add(c);
			}
		}
		return clist;
	}
	//添加企业所属设备，实施工况
	public List<TjHchbdbCompanyInfo> getCList(List<TjHchbdbCompanyInfo> clist, List<TjHchbdbCompanyInfo> list) {
		for (TjHchbdbCompanyInfo c1 : clist) {
			List<Equipment> elist = new ArrayList<Equipment>();
			for (TjHchbdbCompanyInfo c2 : list) {
				if (c2.getId().equals(c1.getId())) {
					Equipment e = new Equipment();
					String eid = c2.getEid();
					String laste = eid.substring(eid.length()-1, eid.length());
					e = Isdata(laste, c2, e);
					e.setEid(eid);
					elist.add(e);
				}
			}
			c1.setElist(elist);
		}
		return clist;
	}
	//添加企业所属设备，GIS
	public List<TjHchbdbCompanyInfo> getSList(List<TjHchbdbCompanyInfo> clist, List<TjHchbdbCompanyInfo> list) {
		int n = 0;
		for (TjHchbdbCompanyInfo c1 : clist) {
			List<Equipment> elist = new ArrayList<Equipment>();
			for (TjHchbdbCompanyInfo c2 : list) {
				if (c2.getId().equals(c1.getId())) {
					Equipment e = new Equipment();
					String eid = c2.getEid();
					String laste = eid.substring(eid.length()-1, eid.length());
					e = Isdata(laste, c2, e);
					if (e.getIsdata() == 0) {
						n++;
					}
					e.setEid(eid);
					elist.add(e);
				}
			}
			if (n == 0) {
				c1.setIsover(1);
			} else {
				c1.setIsover(0);
			}
			n = 0;
			c1.setElist(elist);
		}
		return clist;
	}
	//判断设备是否有数值
	public Equipment Isdata(String laste, TjHchbdbCompanyInfo c2, Equipment e) {
		if ("V".equals(laste)) {
			if (StringUtils.isNotEmpty(c2.getVoctime())) {
				e.setIsdata(1);
				e.setDatatime(c2.getVoctime());
			} else {
				e.setIsdata(0);
			}
		}
		if ("G".equals(laste)) {
			if (StringUtils.isNotEmpty(c2.getWorktime())) {
				e.setIsdata(1);
				e.setDatatime(c2.getWorktime());
			} else {
				e.setIsdata(0);
			}
		}
		if ("Y".equals(laste)) {
			if (StringUtils.isNotEmpty(c2.getLamptime())) {
				e.setIsdata(1);
				e.setDatatime(c2.getVoctime());
			} else {
				e.setIsdata(0);
			}
		}
		return e;
	}
	
	/**
	 * 根据条件查询，单位信息，list，添加设备选择所属企业项使用
	 */
	public Object queryALLCompanyInfo(TjHchbdbCompanyInfo companyInfo) {
		List<TjHchbdbCompanyInfo> list = companyInfoMapper.select(companyInfo);
		return new AjaxResult(true, Constants.SUCCESS_MESSAGE, list);

	}
}
