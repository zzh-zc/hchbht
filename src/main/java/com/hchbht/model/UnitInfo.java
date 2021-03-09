package com.hchbht.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;

/**
 * 企业信息表   tj_hchbdb_unitInfo
 */
@Data
@ApiModel(value = "企业信息表")
public class UnitInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键ID")
	private String id;
	@ApiModelProperty(value = "单位信息ID")
	private String unitID;							//单位信息ID
	@ApiModelProperty(value = "单位类型")
	private String unitType;						//单位类型
	@ApiModelProperty(value = "位名称（中文名）")
	private String unitName;						//单位名称（中文名）
	@ApiModelProperty(value = "单位所属省")
	private String province;						//单位所属省
	@ApiModelProperty(value = "单位所属市")
	private String city;							//单位所属市
	@ApiModelProperty(value = "单位所属区")
	private String county;							//单位所属区
	@ApiModelProperty(value = "单位所属街道")
	private String street;							//单位所属街道
	@ApiModelProperty(value = "单位地址")
	private String unitAddress;						//单位地址
	@ApiModelProperty(value = "组织机构代码")
	private String orgCode;							//组织机构代码
	@ApiModelProperty(value = "行政区域")
	private String adminDivision;					//行政区域
	@ApiModelProperty(value = "邮政编码")
	private String postalCode;						//邮政编码
	@ApiModelProperty(value = "行业类别（大）")
	private String industryCategoryL;				//行业类别（大）
	@ApiModelProperty(value = "行业类别（中）")
	private String industryCategoryM;				//行业类别（中）
	@ApiModelProperty(value = "行业类别（小）")
	private String industryCategoryS;               //
	@ApiModelProperty(value = "行业类别（细）")
	private String companyScale;					//行业类别（细）
	@ApiModelProperty(value = "单位占地面积")
	private String area;							//单位占地面积
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "投产日期")
	private Date productionDate;					//投产日期
	@ApiModelProperty(value = "注册资金")
	private String registeredCapital;				//注册资金
	@ApiModelProperty(value = "固定资产")
	private String fixedAssets;						//固定资产
	@ApiModelProperty(value = "法人代表中文名")
	private String legalCName;						//法人代表中文名
	@ApiModelProperty(value = "法人代表证件类型")
	private String credentialsType;					//法人代表证件类型
	@ApiModelProperty(value = "法人有效身份证号")
	private String legalCredentialsCode;			//法人有效身份证号
	@ApiModelProperty(value = "法人固定电话")
	private String legalTel;						//法人固定电话
	@ApiModelProperty(value = "法人手机号码")
	private String legalPhone; 						//法人手机号码
	@ApiModelProperty(value = "本单位负责环保的部门")
	private String companyEnvironment;				//本单位负责环保的部门
	@ApiModelProperty(value = "联系人")
	private String contactName;						//联系人
	@ApiModelProperty(value = "联系人有效身份证号")
	private String contactCredentialsCode;			//联系人有效身份证号
	@ApiModelProperty(value = "联系人固定电话")
	private String contactTel;						//联系人固定电话
	@ApiModelProperty(value = "联系人手机电话")
	private String contactPhone;					//联系人手机电话
	@ApiModelProperty(value = "联系人微信号")
	private String contactWeChat;					//联系人微信号
	@ApiModelProperty(value = "联系人传真")
	private String contactFax;						//联系人传真
	@ApiModelProperty(value = "联系人邮箱")
	private String contactEmail;					//联系人邮箱
	@ApiModelProperty(value = "经营场所经度")
	private String longitude;						//经营场所经度
	@ApiModelProperty(value = "经营场所纬度")
	private String latitude;						//经营场所纬度
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "注册时间")
	private Date registerDate;						//注册时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "信息更新日期")
	private Date updateTime;						//信息更新日期
	@ApiModelProperty(value = "企业状态（0未审核、1正在审核、2已审核）")
	private String unitState;						//企业状态（0未审核、1正在审核、2已审核）
	@ApiModelProperty(value = "是否有效（1：有效，0：无效）")
	private String isAvailable;						//是否有效（1：有效，0：无效）
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort;							//排序
	

}
