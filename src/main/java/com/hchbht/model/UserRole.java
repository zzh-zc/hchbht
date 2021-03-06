package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户角色表 tj_hchbht_user_role
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户角色表")
public class UserRole implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键ID")
	private String id;
	@ApiModelProperty(value = "用户ID")
	private String userid;
	@ApiModelProperty(value = "权限ID")
	private String roleid;
	@ApiModelProperty(value = "状态：删除，1：未删除")
	private Integer status;		//状态：删除，1：未删除


}
