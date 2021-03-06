package com.hchbht.controller;

import com.github.pagehelper.PageInfo;
import com.hchbht.model.TjHchbdbCompanyInfo;
import com.hchbht.model.monitoring.AirMonitoringVOC;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hchbht.service.MonitoringService3;

/**
 * 监控数据控制中心
 * @author Administrator
 *
 */
@RequestMapping("/monitoring")
@Controller
@Api(tags = "工业污染VOC")
public class Monitoringcontroller {
	@Autowired
	private MonitoringService3 monitoringService3;
	/**
	 * 工业污染，工业废气，实时监控 VOC
	 * 每家企业最新的一条实时数据
	 */
	@PostMapping("/queryWasteVOC")
	@ResponseBody
	@ApiOperation(value = "查询列表",
			notes = "curPage: 页码（可空，和pageSize一起传值才有用）\n"+
					"pageSize: 页大小（可空，和curPage一起传值才有用）")
	public PageInfo<AirMonitoringVOC> queryWasteVOC(@RequestParam(value = "curPage",required = false,defaultValue = "1") Integer curPage,
													@RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize, TjHchbdbCompanyInfo companyInfo) {
		System.out.println("-------------------------------------");
		return monitoringService3.queryLastDataVoc(curPage, pageSize,companyInfo);
	}
}
