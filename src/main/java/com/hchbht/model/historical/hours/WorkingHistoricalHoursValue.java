package com.hchbht.model.historical.hours;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Transient;

/**
 * 工况历史数据表 小时数据 tj_hchbdb_working_historicalhoursvalue
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "工况历史数据表 小时数据")
public class WorkingHistoricalHoursValue implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键id")
	private String id;					//主键id
	@ApiModelProperty(value = "排序")
	private Integer sort;				//排序，自动增长
	@ApiModelProperty(value = "工况类型，1：TVOC工况，2：锅炉工况")
	private Integer workingtype;		//工况类型，1：TVOC工况，2：锅炉工况
	@ApiModelProperty(value = "设备id，也就是排口id")
	private String equipmentid;			//设备id，也就是排口id
	@ApiModelProperty(value = "设备名称，1：风机；2：引风机；3：鼓风机；4：水泵")
	private Integer equipmentname;		//设备名称，1：风机；2：引风机；3：鼓风机；4：水泵
	@ApiModelProperty(value = "探头id")
	private String probeid;				//探头id
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "实时时间")
	private Date historicaltime;		//实时时间
	
	//TVOC 工况字段
	@ApiModelProperty(value = "风机电流")
	private String fancurrent;			//风机电流
	@ApiModelProperty(value = "风机状态。1，表示风机停运；0 表示风机运行正常。")
	private Integer fanstate;			//风机状态。1，表示风机停运；0 表示风机运行正常。
	@ApiModelProperty(value = "voc，水泵  （waterpump） 电流")
	private String vocwpcurrent;		//voc，水泵  （waterpump） 电流
	@ApiModelProperty(value = "voc，水泵状态。1：停运，2：正常")
	private Integer vocwpstate;			//voc，水泵状态。1：停运，2：正常
	
	//private String voctotalcurrent;		//voc，总电流
	//private String vocpointscurrent;	//voc，分电流
	//private String vocadsorption;		//voc，静电吸附
	
	//TVOC 锅炉 公用字段
	@ApiModelProperty(value = "总电流")
	private String totalcurrent;	//总电流
	@ApiModelProperty(value = "分电流")
	private String pointscurrent;	//分电流
	@ApiModelProperty(value = "静电吸附")
	private String adsorption;		//静电吸附

	//锅炉  工况字段
	@ApiModelProperty(value = "引风机")
	private String yfan;				//引风机
	@ApiModelProperty(value = "引风机状态。1，表示风机停运；0 表示风机运行正常。")
	private Integer yfanstate;			//引风机状态。1，表示风机停运；0 表示风机运行正常。
	@ApiModelProperty(value = "鼓风机")
	private String gfan;				//鼓风机
	@ApiModelProperty(value = "鼓风机状态。1，表示风机停运；0 表示风机运行正常。")
	private Integer gfanstate;			//鼓风机状态。1，表示风机停运；0 表示风机运行正常。
	@ApiModelProperty(value = "锅炉，水泵  （waterpump） 电流")
	private String glwpcurrent;			//锅炉，水泵  （waterpump） 电流
	@ApiModelProperty(value = "锅炉，水泵状态。1：停运，2：正常")
	private Integer glwpstate;			//锅炉，水泵状态。1：停运，2：正常
	
	//private String gltotalcurrent;		//锅炉，总电流
	//private String glpointscurrent;		//锅炉，分电流
	//private String gladsorption;		//锅炉，静电吸附
	@ApiModelProperty(value = "锅炉，静电除尘")
	private String gleledust;			//锅炉，静电除尘
	@ApiModelProperty(value = "锅炉，水膜除尘")
	private String glfilmdust;			//锅炉，水膜除尘
	@ApiModelProperty(value = "锅炉，布袋除尘")
	private String glbagdust;			//锅炉，布袋除尘
	
	//非数据库字段
	@Transient
	private String companyid;	//企业id
	@Transient
	private String companyname;	//企业名称
	@Transient
	private String longitude;	//经度
	@Transient
	private String latitude;	//纬度
	@Transient
	private String unit = "A";		//单位A，通用风机、水泵
	@Transient
	private String btime;		//报表时间
	@Transient
	private List<WorkingHistoricalHoursValue> list; //次级，三级数据
	

}
