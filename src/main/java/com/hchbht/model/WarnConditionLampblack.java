package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 预警信息 	油烟		tj_hchbdb_warnconditionlampblack
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "预警信息 油烟")
public class WarnConditionLampblack implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序，自动增长
	@ApiModelProperty(value = "设备id")
	private String equipmentid;	//设备id
	@ApiModelProperty(value = "油烟浓度")
	private String concentration;	//油烟浓度
	@ApiModelProperty(value = "净化器工作电流")
	private String purifiercurrent;	//净化器工作电流
	@ApiModelProperty(value = "是否有效，0：无效，1：有效")
	private Integer status;		//是否有效，0：无效，1：有效
	
	//非数据库字段
	@Transient
	private String companyid;
	@Transient
	private String companyname;
}
