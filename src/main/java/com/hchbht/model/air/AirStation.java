package com.hchbht.model.air;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 空气站信息 	tj_hchbdb_airstation
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "空气站信息")
@Table(name = "tj_hchbdb_airstation")
@NameStyle(Style.normal)
public class AirStation implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键")
	@Id
	private String id;			//主键id
	@ApiModelProperty(value = "排序")
	private Integer sort;		//排序，自动增长
	@ApiModelProperty(value = "子站名称")
	private String stationName;		//子站名称
	@ApiModelProperty(value = "子站编号")
	private	String stationCode;		//子站编号 

}
