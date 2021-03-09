package com.hchbht.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hchbht.conifg.IgnoreSwaggerParameter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.hchbht.model.Menu;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 菜单管理 tj_hchbht_menu
 *
 */
@Data
@ApiModel(value = "菜单管理表")
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键")
	private String id = ""; 							// ID
	@ApiModelProperty(value = "菜单名称")
	private String menuName = ""; 						// 菜单名称
	@ApiModelProperty(value = "菜单URL")
	private String menuUrl = ""; 						// 菜单URL
	@ApiModelProperty(value = "父级菜单ID")
	private String parentId = ""; 						// 父级菜单ID
	@ApiModelProperty(value = "图标")
	private String icon = "";                           // 图标
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort = 0; 							// 排序
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "最后操作时间")
	private Date lastOperatingTime; 					//最后操作时间
	@ApiModelProperty(value = "状态",example = "1")
	private Integer status;								//状态：删除，1：未删除

	@Transient
	@IgnoreSwaggerParameter
	private List<Menu> childs; 
	
	//判断用户是否拥有该菜单
	@Transient
	@ApiModelProperty(hidden = true)
	private boolean ishave = false;						//true 拥有 ;false 未拥有
}
