package com.ml.xx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Lf2SpacesIndenter;
import com.ml.xx.bean.LifePlanAccordionBean;
import com.ml.xx.bean.LifePlanBean;
import com.ml.xx.dao.Life_PlanDao;
import com.ml.xx.service.Life_PlanService;

@Service
public class Life_PlanServiceImpl implements Life_PlanService {
	
	@Resource
	private Life_PlanDao life_PlanDao;

	public List<LifePlanBean> getLifePlanByTime(String time) {
		// TODO Auto-generated method stub
		List<LifePlanBean> list = null;
		try{
			list = life_PlanDao.getLifePlanByTime(time);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public void insertLifePlanBean(LifePlanBean lifePlanBean) {
		// TODO Auto-generated method stub
		try{
			life_PlanDao.insertLifePlanBean(lifePlanBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void updateDealbyLifePlan_dh(LifePlanBean lifePlanBean) {
		// TODO Auto-generated method stub
		try{
			life_PlanDao.updateDealbyLifePlan_dh(lifePlanBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void deleteLifePlanBeanByLifePlan_dh(String lifePlan_dh) {
		// TODO Auto-generated method stub
		try{
			life_PlanDao.deleteLifePlanBeanByLifePlan_dh(lifePlan_dh);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public List<LifePlanAccordionBean> getAccordionMenu() {
		// TODO Auto-generated method stub
		List<LifePlanAccordionBean> list = new ArrayList<LifePlanAccordionBean>();
		
		try{
			List<LifePlanBean> listTemp = life_PlanDao.getAllLifePlan();
			for(int i = 0; i < listTemp.size(); i++){
				LifePlanAccordionBean lifePlanAccordionBeans = new LifePlanAccordionBean();
				String month = listTemp.get(i).getMonth();
				List<LifePlanAccordionBean> listChildern = new ArrayList<LifePlanAccordionBean>();
				for(int j = listTemp.size()-1; j >= 0; j--){
					LifePlanAccordionBean lifePlanAccordionBean = new LifePlanAccordionBean();
					
					
					if(listTemp.get(j).getMonth().equals(month)){
						
						String day = listTemp.get(j).getDay();
						int countDay = 0;
						for(int k = 0; k < listTemp.size(); k ++){
							if(listTemp.get(k).getDay().equals(day)){
								countDay ++;
								j = j-1;
								listTemp.remove(k);
							}
							k--;
						}
						String days = day + "("+countDay+")";
						lifePlanAccordionBean.setId(day);
						lifePlanAccordionBean.setText(days);
						listChildern.add(lifePlanAccordionBean);
					}
				}
				lifePlanAccordionBeans.setId(month);
				lifePlanAccordionBeans.setText(month);
				lifePlanAccordionBeans.setChildren(listChildern);
				list.add(lifePlanAccordionBeans);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}

}
