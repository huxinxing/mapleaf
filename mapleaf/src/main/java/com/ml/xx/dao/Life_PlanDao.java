package com.ml.xx.dao;

import java.util.List;

import com.ml.xx.bean.LifePlanBean;

public interface Life_PlanDao {
		
	public List<LifePlanBean> getLifePlanByTime(String time);  //通过时间获取计划信息
	
	public void insertLifePlanBean(LifePlanBean lifePlanBean);  //插入相关计划  
	
	public void updateDealbyLifePlan_dh(LifePlanBean lifePlanBean); //通过单号修改处理结果
	
	public void deleteLifePlanBeanByLifePlan_dh(String lifePlan_dh);  //通过单号删除计划信息
	
	public List<LifePlanBean> getAllLifePlan();  //获取所有的计划信息
	
}
