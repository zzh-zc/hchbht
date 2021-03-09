package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 预警条件	工况		tj_hchbdb_warnconditionwork
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "预警条件 工况")
@Table(name = "tj_hchbdb_warnconditionwork")
public class WarnConditionWork implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort;		//排序
	@ApiModelProperty(value = "设备id")
	private String equipmentid;	//设备id
	@ApiModelProperty(value = "工况类型，1：voc，2：锅炉",example = "1")
	private Integer worktype; //工况类型，1：voc，2：锅炉
	//TVOC 工况字段
	@ApiModelProperty(value = "风机电流")
	private String fancurrent;			//风机电流
	@ApiModelProperty(value = "voc，水泵  （waterpump） 电流")
	private String vocwpcurrent;		//voc，水泵  （waterpump） 电流
	//TVOC 锅炉 公用字段
	@ApiModelProperty(value = "总电流")
	private String totalcurrent;		//总电流
	@ApiModelProperty(value = "分电流")
	private String pointscurrent;		//分电流
	@ApiModelProperty(value = "静电吸附")
	private String adsorption;			//静电吸附
	//锅炉  工况字段
	@ApiModelProperty(value = "引风机")
	private String yfan;				//引风机
	@ApiModelProperty(value = "鼓风机")
	private String gfan;				//鼓风机
	@ApiModelProperty(value = "锅炉，水泵  （waterpump） 电流")
	private String glwpcurrent;			//锅炉，水泵  （waterpump） 电流
	@ApiModelProperty(value = "锅炉，静电除尘")
	private String gleledust;			//锅炉，静电除尘
	@ApiModelProperty(value = "锅炉，水膜除尘")
	private String glfilmdust;			//锅炉，水膜除尘
	@ApiModelProperty(value = "锅炉，布袋除尘")
	private String glbagdust;			//锅炉，布袋除尘
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
