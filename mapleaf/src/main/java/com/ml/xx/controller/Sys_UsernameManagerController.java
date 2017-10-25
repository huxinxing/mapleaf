package com.ml.xx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ml.xx.bean.SysUsernameBean;
import com.ml.xx.service.Sys_UsernameService;

@Controller
@RequestMapping("/sysManager")
public class Sys_UsernameManagerController {
	
	@Resource
	private Sys_UsernameService sys_UsernameService;
	
	@RequestMapping(value="/goSysUsername",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView goManager(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/InnerSys/Sys_UsernameManager");
		return mav;
	}
	
	@RequestMapping(value = "/getAllUser",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<SysUsernameBean> getAllUser(Model model,HttpServletRequest request,HttpServletResponse response){
		List<SysUsernameBean> sysUsername = null;
		try{
			sysUsername = sys_UsernameService.getAllUser();
		}catch(Exception e){
			e.printStackTrace();
		}
		return sysUsername;
	}
	
	@RequestMapping(value = "/insertUser",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> insertUser(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="humanId",required=false) String humanId,
			@RequestParam(value="username",required=false) String username,
			@RequestParam(value="password",required=false) String password,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="sex",required=false) String sex,
			@RequestParam(value="age",required=false) String age,
			@RequestParam(value="phone",required=false) String phone,
			@RequestParam(value="birthday",required=false) String birthday,
			@RequestParam(value="email",required=false) String email){
		Map<String, String> map = new HashMap<String, String>();
		SysUsernameBean sysUsernameBean = new SysUsernameBean();
		try{
			sysUsernameBean.setHumanId(humanId);
			sysUsernameBean.setUsername(username);
			sysUsernameBean.setPassword(password);
			sysUsernameBean.setName(name);
			sysUsernameBean.setSex(sex);
			sysUsernameBean.setAge(age);
			sysUsernameBean.setBirthday(birthday);
			sysUsernameBean.setPhone(phone);
			sysUsernameBean.setEmail(email);
			sys_UsernameService.insertUser(sysUsernameBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/updateUserByHumanId",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> updateUserByHumanId(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="humanId",required=false) String humanId,
			@RequestParam(value="username",required=false) String username,
			@RequestParam(value="password",required=false) String password,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="sex",required=false) String sex,
			@RequestParam(value="age",required=false) String age,
			@RequestParam(value="phone",required=false) String phone,
			@RequestParam(value="birthday",required=false) String birthday,
			@RequestParam(value="email",required=false) String email){
		Map<String, String> map = new HashMap<String, String>();
		SysUsernameBean sysUsernameBean = new SysUsernameBean();
		try{
			sysUsernameBean.setHumanId(humanId);
			sysUsernameBean.setUsername(username);
			sysUsernameBean.setPassword(password);
			sysUsernameBean.setName(name);
			sysUsernameBean.setSex(sex);
			sysUsernameBean.setAge(age);
			sysUsernameBean.setBirthday(birthday);
			sysUsernameBean.setPhone(phone);
			sysUsernameBean.setEmail(email);
			sys_UsernameService.updateUserByHumanId(sysUsernameBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/deleteByHumanId",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> deleteByHumanId(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="humanId",required=false) String humanId){
		Map<String, String> map = new HashMap<String, String>();
		try{
			sys_UsernameService.deleteByHumanId(humanId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/getSearchUser",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<SysUsernameBean> getSearchUser(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="searchStr",required=false) String searchStr){
		List<SysUsernameBean> list = null;
		System.out.println(searchStr);
		try{
			list = sys_UsernameService.getSearchUser(searchStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
