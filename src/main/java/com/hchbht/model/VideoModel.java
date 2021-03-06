package com.hchbht.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 视频模型(tj_hchbdb_video)
 * @author Administrator
 *
 */
@Data
@ApiModel(value = "视频模型")
public class VideoModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "视频ID号")
	private String id;	//ID		VARCHAR2	视频ID号
	@ApiModelProperty(value = "视频编号")
	private String bh;				//BH		VARCHAR2	视频编号
	@ApiModelProperty(value = "视频名称")
	private String mc;				//MC		VARCHAR2	视频名称
	@ApiModelProperty(value = "通道编码编号")
	private String tdbmbh;			//TDBMBH	VARCHAR2	通道编码编号
	@ApiModelProperty(value = "通道编号")
	private String tdbh;			//TDBH		VARCHAR2	通道编号
	@ApiModelProperty(value = "通道号")
	private String tdh;				//TDH		VARCHAR2	通道号
	@ApiModelProperty(value = "视频类型1:mp4，2：mkv")
	private Integer type;			//TYPE		NUMBER		视频类型1:mp4，2：mkv
	@ApiModelProperty(value = "是否上线")
	private String ifonline;		//IF_ONLINE	VARCHAR2	是否上线
	@ApiModelProperty(value = "视频方向")
	private String direction;		//DIRECTION	VARCHAR2	视频方向
	@ApiModelProperty(value = "监管所代码（12位派出所代码）")
	private String bmbh;			//BMBH		VARCHAR2	监管所代码（12位派出所代码）
	@ApiModelProperty(value = "监管所名称")
	private String bmmc;			//BMMC		VARCHAR2	监管所名称
	@ApiModelProperty(value = "视频播放IP地址")
	private String ipdz;			//IPDZ		VARCHAR2	视频播放IP地址
	@ApiModelProperty(value = "用户名")
	private String username;		//USERNAME	VARCHAR2	用户名
	@ApiModelProperty(value = "密码")
	private String psw;				//PSW		VARCHAR2	密码
	@ApiModelProperty(value = "端口号")
	private String port;			//PORT		VARCHAR2	端口号
	@ApiModelProperty(value = "经度")
	private String zbx;				//ZBX		NUMBER		经度
	@ApiModelProperty(value = "纬度")
	private String zby;				//ZBY		NUMBER		纬度
	@ApiModelProperty(value = "视频来源类型，如1:交警、2:消防、3:治安")
	private Integer videotype;		//VIDEOTYPE	VARCHAR2	视频来源类型，如1:交警、2:消防、3:治安
	@ApiModelProperty(value = "空间索引字段")
	private String objectid;		//OBJECTID	INTEGER		空间索引字段
	@ApiModelProperty(value = "空间字段")
	private String shape;			//SHAPE		ST_GEOMETRY	空间字段
	@ApiModelProperty(value = "视频存在状态，0：不存在，1：表示存在")
	private Integer status;			//视频存在状态，0：不存在，1：表示存在
	@ApiModelProperty(value = "视频简介")
	private String introduction;	//视频简介
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "最后编辑时间")
	private Date edittime;			//最后编辑时间
	@ApiModelProperty(value = "转码视频存放位置")
	private String url;				//转码视频存放位置
	@ApiModelProperty(value = "上传视频存放位置")
	private String oriurl;			//上传视频存放位置
	@ApiModelProperty(value = "视频截图（略缩图）存放位置")
	private String thumbnailurl;	//视频截图（略缩图）存放位置
	@ApiModelProperty(value = "排序")
	private Integer sort; 			//排序
	

}
