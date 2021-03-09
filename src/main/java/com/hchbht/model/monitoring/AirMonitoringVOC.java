package com.hchbht.model.monitoring;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 空气VOC实时表	tj_hchbdb_air_monitoringvoc
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "空气VOC实时表")
public class AirMonitoringVOC implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort;		//排序，自动增长
	@ApiModelProperty(value = "设备id，有可能是风机、水泵")
	private String equipmentid;	//设备id，有可能是风机、水泵
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "实时时间")
	private Date monitoringtime;//实时时间
	@ApiModelProperty(value = "碳氢化合物 mg/m3")
	private String hydrocarbon;		//碳氢化合物	mg/m3
	@ApiModelProperty(value = "烟气流速 m/s")
	private String rate;			//烟气流速		m/s
	@ApiModelProperty(value = "烟气温度  °C")
	private String temperature;		//烟气温度		°C
	@ApiModelProperty(value = "烟气压力 kPa")
	private String pressure;		//烟气压力		kPa
	@ApiModelProperty(value = "烟气湿度 %")
	private String humidity;		//烟气湿度		%
	@ApiModelProperty(value = "废气 m3/s")
	private String wastegas;		//废气		m3/s
	@ApiModelProperty(value = "风向 [角]度")
	private String direction;		//风向		[角]度
	@ApiModelProperty(value = "风速 m/s")
	private String speed;			//风速		m/s
	
	//非数据库字段
	@Transient
	@ApiModelProperty(hidden = true)
	private String companyid;	//企业id
	@Transient
	@ApiModelProperty(hidden = true)
	private String companyname;	//企业名称
	@Transient
	@ApiModelProperty(hidden = true)
	private String longitude;	//经度
	@Transient
	@ApiModelProperty(hidden = true)
	private String latitude;	//纬度
	
	//单位字段，非数据库
	@Transient
	@ApiModelProperty(hidden = true)
	private String hydrocarbonunit = "mg/m3";	//单位	碳氢化合物	mg/m3
	@Transient
	@ApiModelProperty(hidden = true)
	private String rateunit = "m/s";			//单位	烟气流速		m/s
	@Transient
	@ApiModelProperty(hidden = true)
	private String temperatureunit = "°C";		//单位	烟气温度		°C
	@Transient
	@ApiModelProperty(hidden = true)
	private String pressureunit = "kPa";		//单位	烟气压力		kPa
	@Transient
	@ApiModelProperty(hidden = true)
	private String humidityunit = "%";			//单位	烟气湿度		%
	@Transient
	@ApiModelProperty(hidden = true)
	private String wastegasunit = "m3/s";		//单位	废气		m3/s
	@Transient
	@ApiModelProperty(hidden = true)
	private String directionunit = "[角]度";		//单位	风向		[角]度
	@Transient
	@ApiModelProperty(hidden = true)
	private String speedunit = "m/s";			//单位	风速		m/s
	//是否正常，0 ：不正常，1：正常
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer ishydrocarbon = 1;	//碳氢化合物	mg/m3
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer israte = 1;			//烟气流速		m/s
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer istemperature = 1;	//烟气温度		°C
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer ispressure = 1;		//烟气压力		kPa
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer ishumidity = 1;		//烟气湿度		%
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer iswastegas = 1;		//废气		m3/s
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isdirectio = 1;		//风向		[角]度
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isspeed = 1;		//风速		m/s
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer status = 0;                 //是否正常0：正常；1：故障
	
}
