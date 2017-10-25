package com.ml.xx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ml.xx.bean.LifePlanAccordionBean;
import com.ml.xx.bean.LifePlanBean;
import com.ml.xx.service.Life_PlanService;

@Controller
@RequestMapping("/sysManager")
public class life_PlanController {
	
	@Resource
	private Life_PlanService lifePlanService;
	
	@RequestMapping(value="/goLifePlan",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView goManager(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/lifeS/lifePlan");
		return mav;
	}
	
	@RequestMapping(value="/goPlanIndex",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView goPlanIndex(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/lifeS/Plan/index");
		return mav;
	}
	
	@RequestMapping(value="/getLifePlanByTime",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<LifePlanBean> getLifePlanByTime(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="time",required=false) String time){
		List<LifePlanBean> list = null;
		try{
			list = lifePlanService.getLifePlanByTime(time);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/insertLifePlanBean",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> insertLifePlanBean(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="lifePlan_dh",required=false) String lifePlan_dh,
			@RequestParam(value="title",required=false) String title,
			@RequestParam(value="human",required=false) String human,
			@RequestParam(value="txTime",required=false) String txTime,
			@RequestParam(value="type_id",required=false) String type_id,
			@RequestParam(value="yqTime",required=false) String yqTime,
			@RequestParam(value="step_id",required=false) String step_id,
			@RequestParam(value="deal",required=false) String deal,
			@RequestParam(value="descplan",required=false) String descplan,
			@RequestParam(value="month",required=false) String month,
			@RequestParam(value="day",required=false) String day){
		Map<String, String> map = new HashMap<String, String>();
		try{
			
			LifePlanBean lifePlanBean = new LifePlanBean();
			lifePlanBean.setLifePlan_dh(lifePlan_dh);
			lifePlanBean.setTitle(title);
			lifePlanBean.setHuman(human);
			lifePlanBean.setTxTime(txTime);
			lifePlanBean.setType_id(Integer.parseInt(type_id));
			lifePlanBean.setYqTime(yqTime);
			lifePlanBean.setStep_id(Integer.parseInt(step_id));
			lifePlanBean.setDeal(deal);
			lifePlanBean.setDescplan(descplan);
			lifePlanBean.setMonth(month);
			lifePlanBean.setDay(day);
			lifePlanService.insertLifePlanBean(lifePlanBean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/deleteLifePlanBeanByLifePlan_dh",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> deleteLifePlanBeanByLifePlan_dh(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="lifePlan_dh",required=false) String lifePlan_dh){
		
		Map<String, String> map = new HashMap<String, String>();
		try{
			lifePlanService.deleteLifePlanBeanByLifePlan_dh(lifePlan_dh);;
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/updateDealbyLifePlan_dh",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> updateDealbyLifePlan_dh(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="lifePlan_dh",required=false) String lifePlan_dh){
		
		Map<String, String> map = new HashMap<String, String>();
		LifePlanBean lifePlanBean = new LifePlanBean();
		try{
			lifePlanBean.setLifePlan_dh(lifePlan_dh);
			lifePlanBean.setDeal("已处理");
			lifePlanService.updateDealbyLifePlan_dh(lifePlanBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/getAccordionMenu",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<LifePlanAccordionBean> getAccordionMenu(Model model,HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("****************************************************");
		List<LifePlanAccordionBean> list = null;
		try{
			list = lifePlanService.getAccordionMenu();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
}
