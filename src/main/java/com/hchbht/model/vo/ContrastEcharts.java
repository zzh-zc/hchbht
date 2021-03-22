package com.hchbht.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 环比统计，eCharts 转换类
 */
public class ContrastEcharts<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String title;		//标题
	private String nowstr;		//当前数据描述
	private String oldstr;		//过去数据描述
	
	private List<String> strs;  //对比项目条件
	
	//private List<String> now;	//当前数据，处理后的图表要用
	//private List<String> old;	//旧的数据，处理后的图表要用
	
	private List<String> column;//table列项
	private List<T> data;		//未处理之前的数据
	
	public ContrastEcharts() {
		
	}
	public ContrastEcharts(String title, String nowstr, String oldstr,
                           List<String> strs, List<String> column, List<T> data) {
		this.title = title;
		this.nowstr = nowstr;
		this.oldstr = oldstr;
		this.strs = strs;
		this.column = column;
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNowstr() {
		return nowstr;
	}

	public void setNowstr(String nowstr) {
		this.nowstr = nowstr;
	}

	public String getOldstr() {
		return oldstr;
	}

	public void setOldstr(String oldstr) {
		this.oldstr = oldstr;
	}

	public List<String> getStrs() {
		return strs;
	}

	public void setStrs(List<String> strs) {
		this.strs = strs;
	}
	
	public List<String> getColumn() {
		return column;
	}

	public void setColumn(List<String> column) {
		this.column = column;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	public String toString() {
		return "ContrastEcharts [title=" + title + ", nowstr=" + nowstr
				+ ", oldstr=" + oldstr + ", strs=" + strs + ", column="
				+ column + ", data=" + data + "]";
	}
}
