package com.hchbht.model.historical;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 历史掉线
 * @author Administrator  tj_hchbdb_historydrops
 *
 */
@Data
@ApiModel(value = "历史掉线")
public class HistoryDrops implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键id")
	private String id;			//主键id
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序
	@ApiModelProperty(value = "掉线企业id")
	private String companyid;	//掉线企业id
	@ApiModelProperty(value = "掉线企业")
	private String companyname;	//掉线企业
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "掉线时间")
	private Date dropstime;		//掉线时间
	@ApiModelProperty(value = "设备id")
	private String equipmentid;	//设备id
	@ApiModelProperty(value = "是否删除，0：删除，1：未删")
	private Integer status;		//是否删除，0：删除，1：未删
	
	//非数据库字段
	@Transient
	@ApiModelProperty(hidden = true,example = "1")
	private Integer chooseId;//当期那模块，1：工业污染，2：环境质量


}
