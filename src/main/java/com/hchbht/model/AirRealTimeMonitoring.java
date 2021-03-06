package com.hchbht.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 大气实时监控表 tj_hchbht_air_realtimemonitoring
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "大气实时监控表")
public class AirRealTimeMonitoring implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "实时监控表id")
	private String id;				//实时监控表id
	@ApiModelProperty(value = "排序")
	private Integer sort;			//排序
	@ApiModelProperty(value = "企业编号")
	private String companyid;		//企业编号
	@ApiModelProperty(value = "排口编号")
	private String outletunmber;	//排口编号
	@ApiModelProperty(value = "监测时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	private Date monitoringtime;	//监测时间，秒
	
}
