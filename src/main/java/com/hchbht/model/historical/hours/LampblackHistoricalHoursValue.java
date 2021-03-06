package com.hchbht.model.historical.hours;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Transient;

/**
 * 环境质量，油烟历史数据表 小时数据   tj_hchbdb_lampblack_historicalhoursvalue
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "环境质量，油烟历史数据表 小时数据 ")
public class LampblackHistoricalHoursValue implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序，自动增长
	@ApiModelProperty(value = "设备id，也就是排口id")
	private String equipmentid;	//设备id，也就是排口id
	@ApiModelProperty(value = "探头id")
	private String probeid;		//探头id
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "实时时间")
	private Date historicaltime;//实时时间
	@ApiModelProperty(value = "油烟浓度")
	private String concentration;	//油烟浓度
	@ApiModelProperty(value = "风机状态。1，表示风机停运；0 表示风机运行正常。")
	private Integer fanstate;		//风机状态。1，表示风机停运；0 表示风机运行正常。
	@ApiModelProperty(value = "净化器状态。1，表示净化器停运；0 表示净化器运行正常")
	private Integer purifierstate;	//净化器状态。1，表示净化器停运；0 表示净化器运行正常
	@ApiModelProperty(value = "净化器工作电流")
	private String purifiercurrent;	//净化器工作电流
	@ApiModelProperty(value = "烟气温度，单位°C")
	private String temperature;		//烟气温度，单位°C
	
	//非数据库字段
	@Transient
	private String companyid;	//企业id
	@Transient
	private String companyname;	//企业名称
	@Transient
	private String longitude;	//经度
	@Transient
	private String latitude;	//纬度
	@Transient
	private String concentrationunit = "mg/m";	//油烟浓度
	@Transient
	private String purifiercurrentunit = "A";	//净化器工作电流 单位
	@Transient
	private String temperatureunit = "°C";		//烟气温度单位
	@Transient
	private String btime;		//报表时间
	

}
