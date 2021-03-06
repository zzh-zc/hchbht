package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 流域信息实体类
 */
@Data
@ApiModel(value = "流域信息实体类")
public class River implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键ID")
	private String id;
	@ApiModelProperty(value = "流域名称")
	private String rivername;		//流域名称
	@ApiModelProperty(value = "状态，0：无效，1：有效")
	private Integer status;			//状态，0：无效，1：有效

}