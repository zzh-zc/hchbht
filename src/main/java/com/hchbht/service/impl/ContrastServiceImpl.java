package com.hchbht.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.vo.ContrastEcharts;
import org.springframework.stereotype.Service;

import com.hchbht.mapper.ContrastMapper;
import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;
import com.hchbht.service.ContrastService;

@Service("contrastServiceImpl")
public class ContrastServiceImpl implements ContrastService{	
	//voc
	private String[] stringsvos = new String[]{"碳氢化合物", "烟气流速", "烟气温度", "烟气压力", "废气", "风速"}; 
	//工况
	private String[] stringswork = new String[]{"风机电流", "voc水泵 电流", "总电流", "分电流", "静电吸附", "引风机", "鼓风机", "锅炉水泵 电流", "静电除尘", "水膜除尘", "布袋除尘"};
	//油烟
	private String[] stringslamp = new String[]{"油烟浓度", "净化器工作电流", "烟气温度"};
	
	//voc 列项
	private String[] voc = new String[]{"设备ID", "企业名称", "时间", "碳氢化合物", "烟气流速", "烟气温度", "烟气压力", "废气", "风速"};
	//工况   列项
	private String[] work = new String[]{"设备ID", "企业名称", "时间", "工况类型", "设备名称", "探头id", "风机电流", "voc水泵 电流", "总电流", "分电流", "静电吸附", "引风机", "鼓风机", "锅炉水泵 电流", "静电除尘", "水膜除尘", "布袋除尘"};
	//油烟   列项
	private String[] lamp = new String[]{"设备ID", "企业名称", "时间", "探头id", "油烟浓度", "净化器工作电流", "烟气温度"};
	
	@Resource
	private ContrastMapper contrastMapper;
	
	public static void main(String[] args) {
		Date time = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式


		String hehe = dateFormat.format(time); 
		System.out.println(hehe); 

		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改

		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND);
		
		System.out.println(year + "-" + month + "-" + date + " " +hour + ":" +minute + ":" + second);
		
		StringBuffer s = new StringBuffer();
		s.append(year).append("-").append(month).append("-").append(date);
		System.out.println(s.toString());
		//年月日范围
		StringBuffer sd = new StringBuffer().append(c.get(Calendar.YEAR)).append("-").append(c.get(Calendar.MONTH)+1).append("-").append(c.get(Calendar.DATE));	
		StringBuffer ed = new StringBuffer().append(c.get(Calendar.YEAR)).append("-").append(c.get(Calendar.MONTH)+1).append("-").append(c.get(Calendar.DATE)+1);	
		//时分秒范围
		StringBuffer sm = new StringBuffer().append(c.get(Calendar.HOUR_OF_DAY)).append("-").append(c.get(Calendar.MINUTE)-1).append("-").append("00");	
		StringBuffer em = new StringBuffer().append(c.get(Calendar.HOUR_OF_DAY)).append("-").append(c.get(Calendar.MINUTE)-2).append("-").append("00");	
		
		System.out.println("sd : " + sd.toString());
		System.out.println("ed : " + ed);
		System.out.println("sm : " + sm);
		System.out.println("em : " + em);
	}
	
	/**
	 * 环比统计，那当前最新一分的跟上一秒进行对比，voc
	 */
	public Object contrastVOCMinutes(TjHchbdbCompanyInfo companyInfo) {
		//对比的各项名称
		List<String> str = Arrays.asList(stringsvos);
		//table列项
		List<String> column = Arrays.asList(voc);
		//从数据库中拿到上一秒和上上一秒的数据
		List<AirHistoricalMinutesVOC> list = contrastMapper.contrastDataVOCMinutes(companyInfo);
		//数据转换
		List<AirHistoricalMinutesVOC> l = new ArrayList<AirHistoricalMinutesVOC>();
		
		if (list.size() > 0) {
			//循环查找list有多少不同的数据，而且不同的数据有多少条
			int n = 1;//储存list有多少不同的数据
			int m = 1;//记录不同数据有多少条
			String s = "";//储存不同数据有多少条
			//储存第一个数据的企业id
			String id = list.get(0).getCompanyid();
			for (int i = 1; i < list.size(); i++) {
				AirHistoricalMinutesVOC wv = list.get(i);
				if (id.equals(wv.getCompanyid())) {
					m++;
					if (i == list.size() - 1) {
						s += m;
					}
				} else {
					id = wv.getCompanyid();
					n++;
					s += m + ",";
					m = 1;
				}
			}
			l = conversionData(list, s, n);
			
		} 
		ContrastEcharts<AirHistoricalMinutesVOC> ce = new ContrastEcharts<AirHistoricalMinutesVOC>("voc数据环比", "最新数据", "对比上数据", str, column, l);
		return ce;
	}
	
	/**
	 * 环比统计，小时对比， voc
	 */
	public Object contrastVOC(TjHchbdbCompanyInfo companyInfo) {
		//对比的各项名称
		List<String> str = Arrays.asList(stringsvos);
		//table列项
		List<String> column = Arrays.asList(voc);
		//从数据库中数据
		List<AirHistoricalHoursVOC> list = contrastMapper.contrastDataVOC(companyInfo);
		//数据转换
		List<AirHistoricalHoursVOC> l = new ArrayList<AirHistoricalHoursVOC>();
		if (list.size() > 0) {
			//循环查找list有多少不同的数据，而且不同的数据有多少条
			int n = 1;//储存list有多少不同的数据
			int m = 1;//记录不同数据有多少条
			String s = "";//储存不同数据有多少条
			//储存第一个数据的企业id
			String id = list.get(0).getCompanyid();
			for (int i = 1; i < list.size(); i++) {
				AirHistoricalHoursVOC wv = list.get(i);
				if (id.equals(wv.getCompanyid())) {
					m++;
					if (i == list.size() - 1) {
						s += m;
					}
				} else {
					id = wv.getCompanyid();
					n++;
					s += m + ",";
					m = 1;
				}
			}
			l = conversionData(list, s, n);
		}
		ContrastEcharts<AirHistoricalHoursVOC> ce = new ContrastEcharts<AirHistoricalHoursVOC>("voc数据环比统计", "最新数据", "对比数据", str, column, list);
		return ce;
	}
	
	/**
	 * 环比统计，今天和昨天的对比，工况
	 */
	public Object contrastWorkMinutes(TjHchbdbCompanyInfo companyInfo) {
		//对比的各项名称
		List<String> str = Arrays.asList(stringswork);
		//table列项
		List<String> column = Arrays.asList(work);
		//从数据库中数据
		List<WorkingHistoricalMinutesValue> list = contrastMapper.contrastWorkMinutes(companyInfo);
		//数据转换
		List<WorkingHistoricalMinutesValue> l = new ArrayList<WorkingHistoricalMinutesValue>();
		if (list.size() > 0) {
			//循环查找list有多少不同的数据，而且不同的数据有多少条
			int n = 1;//储存list有多少不同的数据
			int m = 1;//记录不同数据有多少条
			String s = "";//储存不同数据有多少条
			//储存第一个数据的企业id
			String id = list.get(0).getCompanyid();
			for (int i = 1; i < list.size(); i++) {
				WorkingHistoricalMinutesValue wv = list.get(i);
				if (id.equals(wv.getCompanyid())) {
					m++;
					if (i == list.size() - 1) {
						s += m;
					}
				} else {
					id = wv.getCompanyid();
					n++;
					s += m + ",";
					m = 1;
				}
			}
			l = conversionData(list, s, n);
		}
		ContrastEcharts<WorkingHistoricalMinutesValue> ce = new ContrastEcharts<WorkingHistoricalMinutesValue>("油烟数据环比统计", "最新数据", "对比数据", str, column, l);
		return ce;
	}
	
	/**
	 * 环比统计，小时对比，工况
	 */
	public Object contrastWork(TjHchbdbCompanyInfo companyInfo) {
		//对比的各项名称
		List<String> str = Arrays.asList(stringswork);
		//table列项
		List<String> column = Arrays.asList(work);
		//从数据库中数据
		List<WorkingHistoricalHoursValue> list = contrastMapper.contrastWork(companyInfo);
		//数据转换
		List<WorkingHistoricalHoursValue> l = new ArrayList<WorkingHistoricalHoursValue>();
		if (list.size() > 0) {
			//循环查找list有多少不同的数据，而且不同的数据有多少条
			int n = 1;//储存list有多少不同的数据
			int m = 1;//记录不同数据有多少条
			String s = "";//储存不同数据有多少条
			//储存第一个数据的企业id
			String id = list.get(0).getCompanyid();
			for (int i = 1; i < list.size(); i++) {
				WorkingHistoricalHoursValue wv = list.get(i);
				if (id.equals(wv.getCompanyid())) {
					m++;
					if (i == list.size() - 1) {
						s += m;
					}
				} else {
					id = wv.getCompanyid();
					n++;
					s += m + ",";
					m = 1;
				}
			}
			l = conversionData(list, s, n);
		}
		ContrastEcharts<WorkingHistoricalHoursValue> ce = new ContrastEcharts<WorkingHistoricalHoursValue>("油烟数据环比统计", "最新数据", "对比数据", str, column, list);
		return ce;
	}
	
	/**
	 * 环比统计，今天和昨天的对比，油烟
	 */
	public Object contrastLampMinutes(TjHchbdbCompanyInfo companyInfo) {
		//对比的各项名称
		List<String> str = Arrays.asList(stringslamp);
		//table列项
		List<String> column = Arrays.asList(lamp);
		//从数据库中数据
		List<LampblackHistoricalMinutesValue> list = contrastMapper.contrastLampMinutes(companyInfo);
		//数据转换
		List<LampblackHistoricalMinutesValue> l = new ArrayList<LampblackHistoricalMinutesValue>();
		if (list.size() > 0) {
			//循环查找list有多少不同的数据，而且不同的数据有多少条
			int n = 1;//储存list有多少不同的数据
			int m = 1;//记录不同数据有多少条
			String s = "";//储存不同数据有多少条
			//储存第一个数据的企业id
			String id = list.get(0).getCompanyid();
			for (int i = 1; i < list.size(); i++) {
				LampblackHistoricalMinutesValue wv = list.get(i);
				if (id.equals(wv.getCompanyid())) {
					m++;
					if (i == list.size() - 1) {
						s += m;
					}
				} else {
					id = wv.getCompanyid();
					n++;
					s += m + ",";
					m = 1;
				}
			}
			l = conversionData(list, s, n);
		}
		ContrastEcharts<LampblackHistoricalMinutesValue> ce = new ContrastEcharts<LampblackHistoricalMinutesValue>("油烟数据环比统计", "最新数据", "对比数据", str, column, list);
		return ce;
	}
	
	/**
	 * 环比统计，小时对比，油烟
	 */
	public Object contrastLamp(TjHchbdbCompanyInfo companyInfo) {
		//对比的各项名称
		List<String> str = Arrays.asList(stringslamp);
		//table列项
		List<String> column = Arrays.asList(lamp);
		//从数据库中数据
		List<LampblackHistoricalHoursValue> list = contrastMapper.contrastLamp(companyInfo);
		//数据转换
		List<LampblackHistoricalHoursValue> l = new ArrayList<LampblackHistoricalHoursValue>();
		if (list.size() > 0) {
			//循环查找list有多少不同的数据，而且不同的数据有多少条
			int n = 1;//储存list有多少不同的数据
			int m = 1;//记录不同数据有多少条
			String s = "";//储存不同数据有多少条
			//储存第一个数据的企业id
			String id = list.get(0).getCompanyid();
			for (int i = 1; i < list.size(); i++) {
				LampblackHistoricalHoursValue wv = list.get(i);
				if (id.equals(wv.getCompanyid())) {
					m++;
					if (i == list.size() - 1) {
						s += m;
					}
				} else {
					id = wv.getCompanyid();
					n++;
					s += m + ",";
					m = 1;
				}
			}
			l = conversionData(list, s, n);
		}
		ContrastEcharts<LampblackHistoricalHoursValue> ce = new ContrastEcharts<LampblackHistoricalHoursValue>("油烟数据环比统计", "最新数据", "对比数据", str,column, list);
		return ce;
	}
	
	//计算月份，返回数值
	public int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = 0;
		switch (month) {
			case 1:;case 3:; case 5:; case 7:; case 8:; case 10:; case 12: day = 31; break;
			case 4:;case 6:; case 9:; case 11: day = 30; break;
			case 2: day = year % 4 == 0 ? 29 : 28;
			default : break;
		}
		return day;
	}
	//数据转换
	public List conversionData(List list, String s, int n) {
		List l = new ArrayList();
		String[] ss = s.split(",");
		int u = 0;
		if (n == ss.length) {
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(ss[i]);
				int y = x/2;
				for (int j = 0; j < y; j++) {
					l.add(list.get(u+j));
					l.add(list.get(u+j+y));
				}
				u += x;
			}
		}
		return l;
	}
}
