package com.hchbht.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;

/**
 * 大气历史数据表 tj_hchbht_air_historicaldata
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "大气历史数据表")
public class AirHistoricalData implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "历史数据表id")
	private String id;				//历史数据表id
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort;			//排序
	@ApiModelProperty(value = "企业编号")
	private String companyid;		//企业编号
	@ApiModelProperty(value = "排口编号")
	private String outletunmber;	//排口编号
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm")
	@ApiModelProperty(value = "平均时间")
	private Date averagetime;		//平均时间时间
}
