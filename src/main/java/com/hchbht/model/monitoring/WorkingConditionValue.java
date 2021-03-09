package com.hchbht.model.monitoring;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hchbht.conifg.IgnoreSwaggerParameter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 工况实时数据表  tj_hchbdb_working_conditionvalue
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "工况实时数据表")
public class WorkingConditionValue implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键id")
	private String id;					//主键id
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort;				//排序，自动增长
	@ApiModelProperty(value = "工况类型，1：TVOC工况，2：锅炉工况",example = "1")
	private Integer workingtype;		//工况类型，1：TVOC工况，2：锅炉工况
	@ApiModelProperty(value = "设备id，也就是排口id")
	private String equipmentid;			//设备id，也就是排口id
	@ApiModelProperty(value = "设备名称，1：风机；2：引风机；3：鼓风机；4：水泵",example = "1")
	private Integer equipmentname;		//设备名称，1：风机；2：引风机；3：鼓风机；4：水泵
	@ApiModelProperty(value = "探头id")
	private String probeid;				//探头id
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "实时时间")
	private Date monitoringtime;		//实时时间
	
	//TVOC 工况字段
	@ApiModelProperty(value = "风机电流")
	private String fancurrent;			//风机电流
	@ApiModelProperty(value = "风机状态。1，表示风机停运；0 表示风机运行正常。",example = "1")
	private Integer fanstate;			//风机状态。1，表示风机停运；0 表示风机运行正常。
	@ApiModelProperty(value = "voc，水泵  （waterpump） 电流")
	private String vocwpcurrent;		//voc，水泵  （waterpump） 电流
	@ApiModelProperty(value = "voc，水泵状态。1：停运，2：正常",example = "1")
	private Integer vocwpstate;			//voc，水泵状态。1：停运，2：正常
	
	//private String voctotalcurrent;		//voc，总电流
	//private String vocpointscurrent;	//voc，分电流
	//private String vocadsorption;		//voc，静电吸附
	
	//TVOC 锅炉 公用字段 
	//private String totalcurrent;	//总电流---
	//private String pointscurrent;	//分电流---
	@ApiModelProperty(value = "静电吸附")
	private String adsorption;		//静电吸附
	
	//锅炉  工况字段
	@ApiModelProperty(value = "引风机")
	private String yfan;				//引风机
	@ApiModelProperty(value = "引风机状态。1，表示风机停运；0 表示风机运行正常。",example = "1")
	private Integer yfanstate;			//引风机状态。1，表示风机停运；0 表示风机运行正常。
	@ApiModelProperty(value = "鼓风机")
	private String gfan;				//鼓风机
	@ApiModelProperty(value = "鼓风机状态。1，表示风机停运；0 表示风机运行正常。",example = "1")
	private Integer gfanstate;			//鼓风机状态。1，表示风机停运；0 表示风机运行正常。
	@ApiModelProperty(value = "锅炉，水泵  （waterpump） 电流")
	private String glwpcurrent;			//锅炉，水泵  （waterpump） 电流
	@ApiModelProperty(value = "锅炉，水泵状态。1：停运，2：正常",example = "1")
	private Integer glwpstate;			//锅炉，水泵状态。1：停运，2：正常
	
	//private String gltotalcurrent;		//锅炉，总电流
	//private String glpointscurrent;		//锅炉，分电流
	//private String gladsorption;		//锅炉，静电吸附
	
	//private String gleledust;			//锅炉，静电除尘---
	@ApiModelProperty(value = "锅炉，水膜除尘---")
	private String glfilmdust;			//锅炉，水膜除尘---
	@ApiModelProperty(value = "锅炉，布袋除尘")
	private String glbagdust;			//锅炉，布袋除尘
	
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
	@Transient
	@ApiModelProperty(hidden = true)
	private String unit = "A";		//单位A，通用风机、水泵
	
	//是否正常，0 ：不正常，1：正常
	//TVOC 工况字段
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isfancurrent;		//风机电流
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isvocwpcurrent;		//voc，水泵  （waterpump） 电流
	//TVOC 锅炉 公用字段
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer istotalcurrent;		//总电流
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer ispointscurrent;	//分电流
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isadsorption;		//静电吸附
	//锅炉  工况字段
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isyfan;				//引风机
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isgfan;				//鼓风机
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isglwpcurrent;		//锅炉，水泵  （waterpump） 电流
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer isglbagdust;		//锅炉，布袋除尘
	@Transient
	@IgnoreSwaggerParameter
	private List<WorkingConditionValue> list;		//次级、三级数据
	

}
