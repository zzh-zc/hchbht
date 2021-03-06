package com.hchbht.mapper;

import java.util.List;

import com.hchbht.model.TjHchbdbCompanyInfo;
import tk.mybatis.mapper.common.Mapper;

public interface CompanyInfo2Mapper extends Mapper<TjHchbdbCompanyInfo> {
	
	/**
	 * 实时工况，工业污染
	 */
	public List<TjHchbdbCompanyInfo> queryGywrGK(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 实时工况，环境质量
	 */
	public List<TjHchbdbCompanyInfo> queryHjzlGK(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 实时工况，根据企业id和设备id
	 */
	public List<TjHchbdbCompanyInfo> queryGKByCidAndEid(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * GIS，工业污染
	 */
	public List<TjHchbdbCompanyInfo> queryGywrGIS(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * GIS，环境质量
	 */
	public List<TjHchbdbCompanyInfo> queryHjzlGIS(TjHchbdbCompanyInfo companyInfo);

}
