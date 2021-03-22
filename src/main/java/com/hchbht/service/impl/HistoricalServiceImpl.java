package com.hchbht.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hchbht.model.TjHchbdbCompanyInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.AirHistoricalHoursVOCMapper;
import com.hchbht.mapper.AirHistoricalMinutesVOCMapper;
import com.hchbht.mapper.CompanyInfoMapper;
import com.hchbht.mapper.HistoricalHoursMapper;
import com.hchbht.mapper.HistoricalMapper;
import com.hchbht.mapper.HistoricalMinutesMapper;
import com.hchbht.mapper.LampblackHistoricalHoursValueMapper;
import com.hchbht.mapper.LampblackHistoricalMinutesValueMapper;
import com.hchbht.mapper.WorkingHistoricalHoursValueMapper;
import com.hchbht.mapper.WorkingHistoricalMinutesValueMapper;
import com.hchbht.model.Equipment;
import com.hchbht.model.commons.AjaxResult;
import com.hchbht.model.commons.Constants;
import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import com.hchbht.model.monitoring.LampblackMonitoringValue;
import com.hchbht.model.monitoring.WorkingConditionValue;
import com.hchbht.service.CompanyInfoService;
import com.hchbht.service.HistoricalService;

@Service("historicalServiceImpl")
public class HistoricalServiceImpl implements HistoricalService{
	@Resource
	private CompanyInfoMapper companyInfoMapper;
	@Resource
	private AirHistoricalMinutesVOCMapper airHistoricalMinutesVOCMapper;//VOC 历史数据，分钟
	@Resource
	private WorkingHistoricalMinutesValueMapper workingHistoricalMinutesValueMapper;//工况  历史数据，分钟
	@Resource
	private LampblackHistoricalMinutesValueMapper lampblackHistoricalMinutesValueMapper;//油烟	历史数据，分钟
	
	@Resource
	private AirHistoricalHoursVOCMapper airHistoricalHoursVOCMapper;//VOC 历史数据，小时
	@Resource
	private WorkingHistoricalHoursValueMapper workingHistoricalHoursValueMapper;//工况  历史数据，小时
	@Resource
	private LampblackHistoricalHoursValueMapper lampblackHistoricalHoursValueMapper;//油烟	历史数据，小时
	@Resource
	private HistoricalMinutesMapper historicalMinutesMapper;		//历史分钟数据，每家企业单个的最新实时数据
	@Resource
	private HistoricalHoursMapper historicalHoursMapper;			//历史小时数据，每家企业单个的最新实时数据
	@Resource
	private HistoricalMapper historicalMapper;						//历史数据，以企业为单位，分钟、小时
	
	//--------------------------------------历史分钟数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，分钟	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteHistoricalMinutesVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		/*//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(1);
		List<CompanyInfo> list = airHistoricalMinutesVOCMapper.queryWorkComapny(companyInfo);
		//更换内容
		List<AirHistoricalMinutesVOC> alist = getListVocM(list);*/
		List<AirHistoricalMinutesVOC> alist = historicalMapper.queryLastDataVocM(companyInfo);
		PageInfo<AirHistoricalMinutesVOC> pageInfo = new PageInfo(alist);
		return pageInfo;
	}
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteHistoricalMinutesVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirHistoricalMinutesVOC> list = airHistoricalMinutesVOCMapper.queryDataByConditionsPage(companyInfo);
		PageInfo<AirHistoricalMinutesVOC> pageInfo = new PageInfo(list);
		return pageInfo;
	}
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteWorkingHistoricalMinutes(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//return workingHistoricalMinutesValueMapper.queryLastDataWork(companyInfo);
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		/*//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(2);
		List<CompanyInfo> list = workingHistoricalMinutesValueMapper.queryWorkComapny(companyInfo);
		//更换内容
		List<WorkingHistoricalMinutesValue> alist = getListWorkM(list);*/
		List<WorkingHistoricalMinutesValue> alist = historicalMapper.queryLastDataWorkM(companyInfo);

		PageInfo<WorkingHistoricalMinutesValue> pageInfo = new PageInfo(alist);
		return pageInfo;
	}
	
	/**
	 * 工业污染，工业废气，历史数据，分钟	工况
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteWorkingHistoricalMinutes2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//从数据库中查询
		List<WorkingHistoricalMinutesValue> list = workingHistoricalMinutesValueMapper.queryDataByConditionsPage(companyInfo);
		PageInfo<WorkingHistoricalMinutesValue> pageInfo = new PageInfo(list);
		
		return pageInfo;
	}
	
	/**
	 * 环境质量，气，油气，历史数据，分钟
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryLampblackHistoricalMinutesGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		/*//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(3);
		List<CompanyInfo> list = lampblackHistoricalMinutesValueMapper.queryWorkComapny(companyInfo);
		//更换内容
*/		List<LampblackHistoricalMinutesValue> alist = historicalMapper.queryLastDataLampM(companyInfo);//getListLampM(list);	

		PageInfo<LampblackHistoricalMinutesValue> pageInfo = new PageInfo(alist);
		return pageInfo;
		//return lampblackHistoricalMinutesValueMapper.queryLastDataLamp(companyInfo);
	}
	
	/**
	 * 环境质量，气，油气，历史数据，分钟
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryLampblackHistoricalMinutesGas2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		
		List<LampblackHistoricalMinutesValue> list = lampblackHistoricalMinutesValueMapper.queryDataByConditionsPage(companyInfo);
		PageInfo<LampblackHistoricalMinutesValue> pageInfo = new PageInfo(list);
		
		return pageInfo;
	}
	
	//--------------------------------------历史小时数据-------------------------------------------
	/**
	 * 工业污染，工业废气，历史数据，小时	 VOC
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteHistoricalHoursVOC(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		/*//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(1);
		List<CompanyInfo> list = airHistoricalHoursVOCMapper.queryWorkComapny(companyInfo);*/
		//更换内容
		List<AirHistoricalHoursVOC> alist = historicalMapper.queryLastDataVocH(companyInfo);//getListVocH(list);
		PageInfo<AirHistoricalHoursVOC> pageInfo = new PageInfo(alist);
		return pageInfo;
		//return airHistoricalHoursVOCMapper.queryLastDataVoc(companyInfo);
	}
	
	/**
	 * 工业污染，工业废气，历史数据，小时	 VOC
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteHistoricalHoursVOC2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirHistoricalHoursVOC> list = airHistoricalHoursVOCMapper.queryDataByConditionsPage(companyInfo);
		PageInfo<AirHistoricalHoursVOC> pageInfo = new PageInfo(list);
		return pageInfo;
	}
	
	/**
	 * 工业污染，工业废气，历史数据，小时	工况
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryWasteWorkingHistoricalHours(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//return workingHistoricalHoursValueMapper.queryLastDataWork(companyInfo);
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		/*//设备id最后结尾标识，1：voc，2:工况，3：油烟
		companyInfo.setStype(2);
		List<CompanyInfo> list = workingHistoricalHoursValueMapper.queryWorkComapny(companyInfo);*/
		//更换内容
		List<WorkingHistoricalHoursValue> alist = historicalMapper.queryLastDataWorkH(companyInfo);//getListWorkH(list);
		PageInfo<WorkingHistoricalHoursValue> pageInfo = new PageInfo(alist);
		return pageInfo;
		
	}
	
	/**
	 * 工业污染，工业废气，历史数据，小时	工况
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryWasteWorkingHistoricalHours2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//从数据库中查询
		List<WorkingHistoricalHoursValue> list = workingHistoricalHoursValueMapper.queryDataByConditionsPage(companyInfo);

		PageInfo<WorkingHistoricalHoursValue> pageInfo = new PageInfo(list);
		
		return pageInfo;
	}
	/**
	 * 环境质量，气，油气，历史数据，小时
	 * 实时监控，每家企业最新的历史数据
	 */
	public Object queryLampblackHistoricalHoursGas(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		//设备id最后结尾标识，1：voc，2:工况，3：油烟
		/*companyInfo.setStype(3);
		List<CompanyInfo> list = lampblackHistoricalHoursValueMapper.queryWorkComapny(companyInfo);*/
		//更换内容
		List<LampblackHistoricalHoursValue> alist = historicalMapper.queryLastDataLampH(companyInfo);//getListLampH(list);
		PageInfo<LampblackHistoricalHoursValue> pageInfo = new PageInfo(alist);
		return pageInfo;
		//return lampblackHistoricalHoursValueMapper.queryLastDataLamp(companyInfo);
	}
	
	/**
	 * 环境质量，气，油气，历史数据，小时
	 * 实时监控，每家企业全部历史数据
	 */
	public Object queryLampblackHistoricalHoursGas2(Integer curPage,Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		
		List<LampblackHistoricalHoursValue> list = lampblackHistoricalHoursValueMapper.queryDataByConditionsPage(companyInfo);
		PageInfo<LampblackHistoricalHoursValue> pageInfo = new PageInfo(list);
		
		return pageInfo;
	}
	
	//----------------------------------------------------类型转换-----------------------------------------------
	//内容替换，voc 分钟
	public List<AirHistoricalMinutesVOC> getListVocM(List<TjHchbdbCompanyInfo> list) {
		List<AirHistoricalMinutesVOC> alist = new ArrayList<AirHistoricalMinutesVOC>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getMvoc());
		}		
		return alist;
	}
	//内容替换，voc 小时
	public List<AirHistoricalHoursVOC> getListVocH(List<TjHchbdbCompanyInfo> list) {
		List<AirHistoricalHoursVOC> alist = new ArrayList<AirHistoricalHoursVOC>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getHvoc());
		}
		return alist;
	}
	
	//内容替换，工况 分钟
	public List<WorkingHistoricalMinutesValue> getListWorkM(List<TjHchbdbCompanyInfo> list) {
		List<WorkingHistoricalMinutesValue> alist = new ArrayList<WorkingHistoricalMinutesValue>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getMwork());
		}
		return alist;
	}
	//内容替换，工况 小时
	public List<WorkingHistoricalHoursValue> getListWorkH(List<TjHchbdbCompanyInfo> list) {
		List<WorkingHistoricalHoursValue> alist = new ArrayList<WorkingHistoricalHoursValue>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getHwork());
		}
		return alist;
	}
	
	//内容替换，油烟，分钟
	public List<LampblackHistoricalMinutesValue> getListLampM(List<TjHchbdbCompanyInfo> list) {
		List<LampblackHistoricalMinutesValue> alist = new ArrayList<LampblackHistoricalMinutesValue>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getMlamp());
		}
		return alist;
	}
	//内容替换，油烟，小时
	public List<LampblackHistoricalHoursValue> getListLampH(List<TjHchbdbCompanyInfo> list) {
		List<LampblackHistoricalHoursValue> alist = new ArrayList<LampblackHistoricalHoursValue>();
		for (TjHchbdbCompanyInfo c : list) {
			alist.addAll(c.getHlamp());
		}
		return alist;
	}
	
	//-------------------------------------------导出报表数据----------------------------------------------
	/**
	 * voc,报表
	 * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 
	 */
	public Object vocHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<AirHistoricalHoursVOC> list = airHistoricalHoursVOCMapper.queryBaoBiao(bbtype, equipmentid, sd, ed);
		PageInfo<AirHistoricalHoursVOC> pageInfo = new PageInfo(list);
		return pageInfo;
	}
	/**
	 * 工况,报表
	 * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 
	 */
	public Object workHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<WorkingHistoricalHoursValue> list = workingHistoricalHoursValueMapper.queryBaoBiao(bbtype, equipmentid, sd, ed);
		PageInfo<WorkingHistoricalHoursValue> pageInfo = new PageInfo(list);
		return pageInfo;
	}
	/**
	 * 油烟,报表
	 * bbtype 1:日报表; 2:周报表; 3:月报表 ; 4:季度报表; 5:年报表 
	 */
	public Object lampHQuery(Integer curPage,Integer pageSize, String equipmentid, Integer bbtype, String sd, String ed) {
		//分页
		if (curPage!= null && pageSize != null) {
			PageHelper.startPage(curPage, pageSize);
		}
		List<LampblackHistoricalHoursValue> list = lampblackHistoricalHoursValueMapper.queryBaoBiao(bbtype, equipmentid, sd, ed);
		PageInfo<LampblackHistoricalHoursValue> pageInfo = new PageInfo(list);
		return pageInfo;
	}
	
	//除去日报时间中的 T 
	public String removeT(String s) {
		s = s.replace("T", " ");
		return s;
	}
	
	//返回起始日期和结束日期
	public String getdate(Integer bbtype, String searchTime) {
		String sd = "";
		String ed = "";
		if ("".equals(searchTime)) {
			System.out.println("9898");
		}
		if (StringUtils.isNotEmpty(searchTime) && searchTime.contains(" - ")) {
			sd = searchTime.split(" - ")[0];
			ed = searchTime.split(" - ")[1];
		} else {
			Date now = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(now);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        ed = dateFormat.format(now);
			//1 日报表 , 2 周报表, 3 月报表, 4 季度报表 , 5  年报表
			if (bbtype == 1) {
				calendar.add(Calendar.DATE, -1);
				sd = dateFormat.format(calendar.getTime());
			} else if (bbtype == 2) {
				calendar.add(Calendar.DATE, -7);
				sd = dateFormat.format(calendar.getTime());
			} else if (bbtype == 3) {
				calendar.add(Calendar.MONTH, -1);
				sd = dateFormat.format(calendar.getTime());
			} else if (bbtype == 4) {
				calendar.add(Calendar.MONTH, -3);
				sd = dateFormat.format(calendar.getTime());
			} else if (bbtype == 5) {
				calendar.add(Calendar.YEAR, -1);
				sd = dateFormat.format(calendar.getTime());
			}
		}
		return sd + ", " + ed;
	}
}
