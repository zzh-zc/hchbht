package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户去权限表 tj_hchbht_user_menu
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户去权限表")
public class UserMenu implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "用户菜单id")
	private String id;			//用户菜单id
	@ApiModelProperty(value = "用户id")
	private String userid;		//用户id
	@ApiModelProperty(value = "菜单id")
	private String menuid;		//菜单id
	@ApiModelProperty(value = "状态：删除，1：未删除",example = "1")
	private Integer status;		//状态：删除，1：未删除
	
}
