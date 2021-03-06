package com.hchbht.model.commons;

public class Constants {

	public static final String UTF_8 = "UTF-8";
	// 基本响应信息配置
	public static final String SUCCESS_MESSAGE = "操作成功！";
	public static final String ERROR_MESSAGE = "网络异常，请稍后重试！";
	
	/**
	 * 数据源配置
	 */
	//默认数据源，大气数据源
	public static final String DATA_SOURCE_DQ = "dataSource";
    //水污染数据源
	public static final String DATA_SOURCE_SWR = "sdataSource";
	
	// 后台登录用户
	public static final String PCLOGINUSER = "pcloginuser";

	// 文件上传目录配置
	//服务器目录
	public static final String FILE_ROOT_PATH = "file.root.path";
	//文件访问根路径，用于tomcat映射本地文件
	public static final String FILE_SERVER_URL = "file.server.url";
	//测试上传路径
	public static final String FILE_TEST_PATH = "file.test.path";
	
	//freemark生成上报模板地址
	public static final String FILE_MOULD_TEST="file.mould";
	
	//视频存放地址
	public static final String FILE_VIDEO_PATH="file.video";
	//视频截图存放文件夹
	public static final String folder_thumbnail="file.folder_thumbnail";
	//ffmpeg的存放位置
	public static final String ffmpeg_posi="file.ffmpeg_posi";

	//短信服务
	public static final String SMS_URL="sms.url";
	public static final String SMS_USERNAME="sms.username";
	public static final String SMS_PASSWORD="sms.password";
	
	//工况检测时间
	public static final String WORK_TIME="work.time";
	
	//预警消息
	public static final String WARN_VOC = "warn.voc";
	public static final String WARN_WORK = "warn.work";
	public static final String WARN_LAMP = "warn.lamp";
}
