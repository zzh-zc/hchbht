package com.hchbht.model;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hchbht.conifg.IgnoreSwaggerParameter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import com.hchbht.model.historical.hours.AirHistoricalHoursVOC;
import com.hchbht.model.historical.hours.LampblackHistoricalHoursValue;
import com.hchbht.model.historical.hours.WorkingHistoricalHoursValue;
import com.hchbht.model.historical.minutes.AirHistoricalMinutesVOC;
import com.hchbht.model.historical.minutes.LampblackHistoricalMinutesValue;
import com.hchbht.model.historical.minutes.WorkingHistoricalMinutesValue;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import com.hchbht.model.monitoring.LampblackMonitoringValue;
import com.hchbht.model.monitoring.WorkingConditionValue;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 企业表 tj_hchbdb_companyInfo
 * 
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "企业表")
@Table(name = "tj_hchbdb_companyInfo")
@NameStyle(Style.normal)
public class TjHchbdbCompanyInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(value = "主键id")
	private String id; 				// 主键id
	@ApiModelProperty(value = "企业名称")
	private String name; 			// 企业名称
	@ApiModelProperty(value = "企业地址")
	private String address; 		// 企业地址
	@ApiModelProperty(value = "联系人名称")
	private String contactName; 	// 联系人名称
	@ApiModelProperty(value = "联系人电话")
	private String contactPhone; 	// 联系人电话
	@ApiModelProperty(value = "大模块类型",example = "1")
	private Integer mtype; 			// 大模块类型 ，1、工业污染；2、环境质量
	@ApiModelProperty(value = "次级类型",example = "1")
	private Integer ctype; 			// 次级类型，如果是 工业污染，1：工业废气；2：工业废水，如果是环境质量，1、环境质量，气；2、环境质量，水
	@ApiModelProperty(value = "企业类型",example = "1")
	private Integer type; 			// 如果是工业污染 便选择填写，否在便不填写 ，企业类型，0：VOC企业；1：锅炉企业；2 voc+锅炉
	@ApiModelProperty(value = "如果是工业污染，锅炉企业，则填写 锅炉容量")
	private String boilerCapacity; 	// 如果是工业污染，锅炉企业，则填写 锅炉容量
	@ApiModelProperty(value = "如果是工业污染，锅炉企业，则填写 容量单位")
	private String units; 			// 如果是工业污染，锅炉企业，则填写 容量单位
	@ApiModelProperty(value = "如果是环境质量，油烟企业，则填写净化器类型。1：静电，2：运水烟罩；3：静电+运水烟罩",example = "1")
	private Integer purifierstate; 	// 如果是环境质量，油烟企业，则填写净化器类型。1：静电，2：运水烟罩；3：静电+运水烟罩
	@ApiModelProperty(value = "是否有效",example = "1")
	private Integer isAvailable; 	// 是否有效 0：无效;1：有效
	@ApiModelProperty(value = "排序",example = "1")
	private Integer sort; 			// 排序
	@ApiModelProperty(value = "经营场所经度")
	private String longitude; 		// 经营场所经度
	@ApiModelProperty(value = "经营场所纬度")
	private String latitude; 		// 经营场所纬度
	@ApiModelProperty(value = "关联设备之后，有些设备还没有传输来数据，分页查询实时数据时会收到影响，故暂时添加此属性判断，0：没有，1：有",example = "1")
	private Integer isEquipment; 	// 关联设备之后，有些设备还没有传输来数据，分页查询实时数据时会收到影响，故暂时添加此属性判断，0：没有，1：有

	// 非数据库字段
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String eid; 			// 关联的设备id
	@Transient
	@IgnoreSwaggerParameter
	private List<Equipment> elist; 	// 关联的设备信息

	// 用户查询
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String searchTime;
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String sd;
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String ed;
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String sm;//时分秒
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String em;//时分秒
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true,example = "1")
	private Integer startrow;
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true,example = "1")
	private Integer endrow;
	
	//历史监控中使用
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true,example = "1")
	private Integer stype; //1：voc, 2:工况, 3:油烟
	//是否离线
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true,example = "1")
	private Integer isover;	//0：否，1：是
	//工况实时页面，设备最新的实时数据时间
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String datatime;
	//工况实时页面，记录voc、工况、油烟时间
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String voctime;
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String worktime;
	@Transient
	@ApiModelProperty(value = "关联的设备id",hidden = true)
	private String lamptime;

	// 非数据库字段
	// ---------实时数据-----------
	// private List<AirMonitoringValue> vlist; //关联的排口信息数值
	@Transient
	@IgnoreSwaggerParameter
	private List<AirMonitoringVOC> voclist; // 关联的voc信息数值
	@Transient
	@IgnoreSwaggerParameter
	private List<LampblackMonitoringValue> lamplist; // 关联的油烟实时信息
	@Transient
	@IgnoreSwaggerParameter
	private List<WorkingConditionValue> worklist; // 关联的工况实时信息
	// ---------历史数据-----------
	// ---------分钟数据-----------
	@Transient
	@IgnoreSwaggerParameter
	private List<AirHistoricalMinutesVOC> mvoc; // 关联的voc历史分钟信息
	@Transient
	@IgnoreSwaggerParameter
	private List<LampblackHistoricalMinutesValue> mlamp; // 关联的油烟历史分钟信息
	@Transient
	@IgnoreSwaggerParameter
	private List<WorkingHistoricalMinutesValue> mwork; // 关联的工况历史分钟信息
	// ---------小时数据-----------
	@Transient
	@IgnoreSwaggerParameter
	private List<AirHistoricalHoursVOC> hvoc; // 关联的voc历史小时信息
	@Transient
	@IgnoreSwaggerParameter
	private List<LampblackHistoricalHoursValue> hlamp; // 关联的油烟历史小时信息
	@Transient
	@IgnoreSwaggerParameter
	private List<WorkingHistoricalHoursValue> hwork; // 关联的工况历史小时信息

	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
		if (StringUtils.isNotEmpty(searchTime) && searchTime.contains(" - ")) {
			this.sd = searchTime.split(" - ")[0];
			this.ed = searchTime.split(" - ")[1];
		}
	}


}
