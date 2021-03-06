package com.hchbht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hchbht.model.TjHchbdbCompanyInfo;
import tk.mybatis.mapper.common.Mapper;

public interface CompanyInfoMapper extends Mapper<TjHchbdbCompanyInfo> {
	/**
	 * 查询有多少家企业
	 */
	public int queryDataSize(TjHchbdbCompanyInfo companyInfo);

	/**
	 * 根据条件查询，单一的数据
	 */
	public TjHchbdbCompanyInfo queryDataByCondition(TjHchbdbCompanyInfo companyInfo);

	/**
	 * 根据条件查询，list数据
	 */
	public List<TjHchbdbCompanyInfo> queryDataByConditions(TjHchbdbCompanyInfo companyInfo);

	/**
	 * 根据条件查询，list数据， 分页
	 */
//	public Page<CompanyInfo> queryDataByConditionsPage(CompanyInfo companyInfo);

	/**
	 * 根据企业id查询关联的设备信息
	 */
//	public List<Equipment> queryDataEquipment(String companyid);

	/**
	 * 根据设备id查询当前数值量
	 * n 1:voc 碳氢化合物浓度；2：工况  A；3:油烟浓度
	 * @return
	 */
	public String queryValue(@Param(value="equipmentid")String equipmentid, @Param(value="n")Integer n);
	
	/**
	 * 根据条件查询，list数据，历史检测
	 */
	public List<TjHchbdbCompanyInfo> queryDataByConditionsH(TjHchbdbCompanyInfo companyInfo);
	
	/**
	 * 根据企业设备类型，去历史表里面，查询最近三天的的数据总数
	 */
	public int queryDataNumberByEquipmentid(@Param(value="equipmentid")String equipmentid, @Param(value="n")Integer n);
	
	/**
	 * 根据企业设备类型，查设备当前最新数据的时间
	 */
	public String queryDataTime(@Param(value="equipmentid")String equipmentid, @Param(value="n")Integer n);
}
