package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 预警条件  voc   tj_hchbdb_warnconditionvoc
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "预警条件")
@Table(name = "tj_hchbdb_warnconditionvoc")
public class WarnConditionVOC implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort;		//排序
	@ApiModelProperty(value = "设备id")
	private String equipmentid;	//设备id
	@ApiModelProperty(value = "碳氢化合物临界值 mg/m3")
	private String hydrocarbon;		//碳氢化合物临界值	mg/m3
	@ApiModelProperty(value = "烟气流速临界值 m/s")
	private String rate;			//烟气流速临界值		m/s
	@ApiModelProperty(value = "烟气温度临界值 °C")
	private String temperature;		//烟气温度临界值		°C
	@ApiModelProperty(value = "烟气压力临界值 kPa")
	private String pressure;		//烟气压力临界值		kPa
	@ApiModelProperty(value = "烟气湿度临界值 %")
	private String humidity;		//烟气湿度临界值		%
	@ApiModelProperty(value = "废气总量临界值 m3/s")
	private String wastegas;		//废气总量临界值		m3/s
	@ApiModelProperty(value = "是否有效，0：无效，1：有效",example = "1")
	private Integer status;		//是否有效，0：无效，1：有效
	
	//非数据库字段
	@Transient
	@ApiModelProperty(hidden = true)
	private String companyid;
	@Transient
	@ApiModelProperty(hidden = true)
	private String companyname;
		
}
