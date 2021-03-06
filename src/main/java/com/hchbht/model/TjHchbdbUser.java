package com.hchbht.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表  tj_hchbdb_user
 * @author Administrator
 *
 */
@Data
@Table(name = "tj_hchbdb_user")
@ApiModel(value="用户表")
public class TjHchbdbUser implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "id")
	@ApiModelProperty(value = "主键")
	private String id;
	@Column(name = "username")
	@ApiModelProperty(value = "用户名")
	private String username;
	@Column(name = "password")
	@ApiModelProperty(value = "密码")
	private String password;
	@Column(name = "realname")
	@ApiModelProperty(value = "真实姓名")
	private String realname;		//真实姓名
	@Column(name = "phone")
	@ApiModelProperty(value = "手机号码")
	private String phone;			//手机号码
	@Column(name = "organizationid")
	@ApiModelProperty(value = "组织机构代码")
	private String organizationid;	//组织机构代码
	@Column(name = "status")
	@ApiModelProperty(value = "状态")
	private Integer status;			//状态，是否有效，0：无效，1：有效

	@Transient
	private String sex;

}
