package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 企业设备关联表	tj_hchbdb_companyInfo_equipment
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "企业设备关联表")
public class CompanyInfoEquipment implements Serializable{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序，自动增长
	@ApiModelProperty(value = "企业id")
	private String companyid;	//企业id
	@ApiModelProperty(value = "设备id")
	private String equipmentid;	//设备id
	@ApiModelProperty(value = "状态")
	private Integer status;		//状态，是否有效，0：有效，1：无效
	
}
