package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 字典 tj_hchbht_dictionary
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "数据字典")
public class Dictionary implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "字典id")
	private String id;			//字典id
	@ApiModelProperty(value = "字典名称")
	private String dname;		//字典名称
	@ApiModelProperty(value = "字典类型")
	private String type;		//字典类型
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序
	@ApiModelProperty(value = "字典状态")
	private Integer status;		//字典状态 0：有效，1：无效
}
