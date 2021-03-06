package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 空气污染因子 (tj_hchbdb_air_pollutionfactor)
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "空气污染因子")
public class AirPollutionFactor implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "空气污染因子id")
	private String id;		//空气污染因子id
	@ApiModelProperty(value = "空气污染因子名字")
	private String apfname;		//空气污染因子名字
	@ApiModelProperty(value = "空气污染因子中文名字")
	private String apfcname;	//空气污染因子中文名字
	@ApiModelProperty(value = "空气污染因子单位")
	private String apfunit;		//空气污染因子单位
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序
	@ApiModelProperty(value = "是否有效")
	private Integer status;		//是否有效，0：无效，1：有效
}
