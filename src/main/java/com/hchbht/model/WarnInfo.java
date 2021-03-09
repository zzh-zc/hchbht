package com.hchbht.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 预警信息查询
 * @author Administrator  tj_hchbdb_warnInfo
 *
 */
@Data
@ApiModel(value = "预警信息查询")
@Table(name = "tj_hchbdb_warnInfo")
public class WarnInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort;		//排序
	@ApiModelProperty(value = "设备id")
	private String equipmentid;	//设备id
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "发生时间")
	private Date happentime;	//发生时间
	@ApiModelProperty(value = "描述")
	private String describe;	//描述
	@ApiModelProperty(value = "是否处理，0：未处理，1：处理",example = "1")
	private Integer isdispose;	//是否处理，0：未处理，1：处理
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "处理时间")
	private Date disposetime;	//处理时间
	@ApiModelProperty(value = "是否删除，0：删除，1：未删",example = "1")
	private Integer status;		//是否删除，0：删除，1：未删
	
	//非数据库字段
	@Transient
	@ApiModelProperty(hidden = true)
	private String companyname;	//事件发生企业
	@Transient
	@ApiModelProperty(hidden = true)
	private String searchTime;
	@Transient
	@ApiModelProperty(hidden = true)
	private String sd;
	@Transient
	@ApiModelProperty(hidden = true)
	private String ed;
	@Transient
	@ApiModelProperty(hidden = true)
	private String updatetime;
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer chooseId;//当期那模块，1：工业污染，2：环境质量
	

}
