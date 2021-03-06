package com.hchbht.model.air;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 空气站检测数据 实体类   	tj_hchbdb_airstation_testingdata
 * @author Administrator
 */
@Data
@ApiModel(value = "空气站检测数据")
@Table(name = "tj_hchbdb_airstation_testingdata")
public class AirStationTestingData implements Serializable{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序，自动增长
	
	/**
	 * 报类型声明
	 * 30 秒值：bn01（标况），JR01（实况）
		5 分钟均值：JZ12（标况），JR12（实况）
		1 小时均值：JZ16（标况），JR16（实况）
		AQI日均值：JZ18（标况），JR18（实况）
		API日均值：JZ06（标况），JR06（实况）
		气象日均值：JZ24（无实况）
		温室日均值：JZ25（无实况）
	 */
	@ApiModelProperty(value = "biz_DataType")
	private String datatype;					// 数据库对应字段  biz_DataType
	@ApiModelProperty(value = "子站编码")
	private String stationCode;					//子站编码 ，  数据库对应字段  biz_StationCode
	@ApiModelProperty(value = "数据时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	private Date datatime;						//数据时间，数据库对应字段  biz_DataTime
	
	//SO2/NO/NO2/NOx/CO/O3/PM10/PM2.5/风速/风向/气温/气压/湿度/雨量
	@ApiModelProperty(value = "so2")
	private String so2;
	@ApiModelProperty(value = "no")
	private String no;
	@ApiModelProperty(value = "no2")
	private String no2;
	@ApiModelProperty(value = "nox")
	private String nox;
	@ApiModelProperty(value = "co")
	private String co;
	@ApiModelProperty(value = "o3")
	private String o3;
	@ApiModelProperty(value = "pm10")
	private String pm10;
	@ApiModelProperty(value = "pm25")
	private String pm25;
	@ApiModelProperty(value = "风速")
	private String windspeed;		//风速
	@ApiModelProperty(value = "风向")
	private String winddirection;	//风向
	@ApiModelProperty(value = "气温")
	private String temperature;		//气温
	@ApiModelProperty(value = "气压")
	private String airpressure;		//气压
	@ApiModelProperty(value = "湿度")
	private String humidity;		//湿度
	@ApiModelProperty(value = "雨量")
	private String rainfall;		//雨量

	
	//非数据库字段
	@Transient
	private String stationName;		//子站名称
	@Transient
	private String sd;
	@Transient
	private String ed;
	
}
