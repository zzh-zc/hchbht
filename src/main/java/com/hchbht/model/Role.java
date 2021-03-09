package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
@Data
@ApiModel(value = "角色表")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "角色id")
	private String id;			//角色id
	@ApiModelProperty(value = "角色名称")
	private String rolename;		//角色名称
	@ApiModelProperty(value = "状态",example = "1")
	private Integer status;			//状态，0：删除；1：未删
	
	//判断用户是否拥有该角色
	@Transient
	@ApiModelProperty(hidden = true)
	private boolean ishave = false;//true 拥有 ;false 未拥有 
}
