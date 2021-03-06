package com.hchbht.model;

import java.io.Serializable;
import java.util.List;

import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import com.hchbht.model.monitoring.LampblackMonitoringValue;
import com.hchbht.model.monitoring.WorkingConditionValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Transient;

/**
 * 设备表		tj_hchbdb_equipment
 * @author Administrator
 * @param <T>
 *
 */
@Data
@ApiModel(value = "设备表")
public class Equipment implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序，自动增长
	@ApiModelProperty(value = "设备序号")
	private String esort;		//设备序号
	@ApiModelProperty(value = "设备编号")
	private String eid;			//设备编号
	@ApiModelProperty(value = "设备名称")
	private String name;		//设备名称
	@ApiModelProperty(value = "设备类型 ，1：工业废气，2：工业污水，3：油烟")
	private Integer type;		//设备类型 ，1：工业废气，2：工业污水，3：油烟
	@ApiModelProperty(value = "类别类型，1：voc，2：工况")
	private Integer lstate;		//类别类型，1：voc，2：工况
	@ApiModelProperty(value = "工况类型，1：VOC工况，2：锅炉工况")
	private Integer	tstate;		//工况类型，1：VOC工况，2：锅炉工况
	@ApiModelProperty(value = "设备状态，0：启用，1：禁用")
	private Integer status;		//设备状态，0：启用，1：禁用
	
	//非数据库字段
	@Transient
	private String companyid;	//企业id
	@Transient
	private String companyname;	//企业名称
	@Transient
	private Integer isdata;		//是否有数据，0：没有，1：有
	@Transient
	private String datatime;	//数据时间
	@Transient
	private String points;		//分量
	//---------实时数据-----------
	//private List<AirMonitoringValue> vlist;	//关联的排口信息数值
	@Transient
	private List<AirMonitoringVOC> voclist;				//关联的voc信息数值
	@Transient
	private List<LampblackMonitoringValue> lamplist;	//关联的油烟实时信息
	@Transient
	private List<WorkingConditionValue> worklist;		//关联的工况实时信息
	
	//---------历史数据-----------
	//---------分钟数据-----------
	@Transient
	private List<AirHistoricalMinutesVOC> mvoc;			//关联的voc历史分钟信息
	@Transient
	private List<LampblackHistoricalMinutesValue> mlamp;	//关联的油烟历史分钟信息
	@Transient
	private List<WorkingHistoricalMinutesValue> mwork;	//关联的工况历史分钟信息
	//---------小时数据-----------
	@Transient
	private List<AirHistoricalHoursVOC> hvoc;			//关联的voc历史小时信息
	@Transient
	private List<LampblackHistoricalHoursValue> hlamp;	//关联的油烟历史小时信息
	@Transient
	private List<WorkingHistoricalHoursValue> hwork;	//关联的工况历史小时信息
}
