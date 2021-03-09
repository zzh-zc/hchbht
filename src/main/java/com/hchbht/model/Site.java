package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 站点监测实体类
 * tj_hchbdb_siteMonitoring
 */
@Data
@ApiModel(value = "站点监测实体类")
public class Site implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键ID",example = "1")
	private Integer id;					//
	@ApiModelProperty(value = "站点编号")
	private String siteNo;				//站点编号
	@ApiModelProperty(value = "站点名称")
	private String siteName;			//站点名称
	@ApiModelProperty(value = "监控时间间隔")
	private String monitorInterval;		//监控时间间隔
	@ApiModelProperty(value = "站点地址")
	private String siteAddress;			//站点地址
	@ApiModelProperty(value = "站点管理人")
	private String siteManager;			//站点管理人
	@ApiModelProperty(value = "站点联系人")
	private String siteContacts;		//站点联系人
	@ApiModelProperty(value = "站点联系人电话")
	private String sitePhone;			//站点联系人电话
	@ApiModelProperty(value = "是否启用，0：没有启用，1：启用",example = "1")
    private Integer enabled;			//是否启用，0：没有启用，1：启用
	@ApiModelProperty(value = "监测类别")
    private String monitoringCategory;	//监测类别
	@ApiModelProperty(value = "监测类型")
    private String monitoringType;		//监测类型
	@ApiModelProperty(value = "环境类型")
    private String environmentTypes;	//环境类型
	@ApiModelProperty(value = "控制级别")
    private String controlHierarchy;	//控制级别
	@ApiModelProperty(value = "是否需要审核，0：不需要，1：需要")
    private Integer isRequired;			//是否需要审核，0：不需要，1：需要
	@ApiModelProperty(value = "排序",example = "1")
    private Integer sort;				//排序
	@ApiModelProperty(value = "站点状态，0：删除；1：未删除",example = "1")
    private Integer status;				//站点状态，0：删除；1：未删除
	@ApiModelProperty(value = "关联的单位id")
    private String unitID;				//关联的单位id
    
}
