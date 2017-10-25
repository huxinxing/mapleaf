package com.ml.xx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ml.xx.bean.ManageSysBean;
import com.ml.xx.service.LoginService;
import com.ml.xx.service.SystemService;

@Controller
@RequestMapping("/sysManager")
public class SystemController {
	
	@Resource
	private SystemService systemService;	
	
	@RequestMapping(value="/goManager",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView goManager(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/SysManager");
		return mav;
	}
	
	@RequestMapping(value = "/loadHeaderMean",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<ManageSysBean> loadHeaderMean(Model model,HttpServletRequest request,HttpServletResponse response){
		
		List<ManageSysBean> manageSys = null;
		try{
			manageSys = systemService.loadHeaderMean();
		}catch(Exception e){
			e.printStackTrace();
		}
		return manageSys;
	}
	
	@RequestMapping(value = "/loadMenuTree",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<ManageSysBean> loadMenuTree(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="id",required=false) String id){
		
		List<ManageSysBean> manageSys = null;
		try{
			manageSys = systemService.loadMenuTree(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return manageSys;
	}
	
	
	@RequestMapping(value="/addMenuUrl",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addMenuUrl(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/InnerSys/Sys_AddMenuUrl");
		return mav;
	}
	
	@RequestMapping(value="/pzurl",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<ManageSysBean> pzurl(Model model,HttpServletRequest request,HttpServletResponse response){
		List<ManageSysBean> list = null;
		try{
			list = systemService.pzurl();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/addurl",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HashMap<String, String> addurl(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="text",required=false) String text,
			@RequestParam(value="urltype",required=false) String urltype,
			@RequestParam(value="url",required=false) String url,
			@RequestParam(value="dh",required=false) String dh,
			@RequestParam(value="type",required=false) String type){
		HashMap<String, String> hashMap = new HashMap<String, String>();
		try{
			ManageSysBean manageSys = new ManageSysBean();
			manageSys.setText(text);
			manageSys.setDh(dh);
			manageSys.setUrl(url);
			manageSys.setUrltype(urltype);
			if(type.equals("add")){
				systemService.addurl(manageSys);
			}else{
				systemService.updateManageSysUrlByDh(manageSys);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return hashMap;
	}
	
	@RequestMapping(value="/deleteUrlByDh",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody Map<String, String> deleteUrlByDh(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="dh",required=false) String dh){
		Map<String, String> map = new HashMap<String, String>();
		try{
			systemService.deleteUrlByDh(dh);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/Sys_URLDirectory",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView Sys_URLDirectory(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/InnerSys/Sys_URLDirectory");
		return mav;
	}
	
	@RequestMapping(value="/getManageSysByid",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody List<ManageSysBean> getManageSysByid(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="id",required=false) String id){
		List<ManageSysBean> list = null;
		try{
			list = systemService.getManageSysByid(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/getAllManageUrl",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody List<ManageSysBean> getAllManageUrl(Model model,HttpServletRequest request,HttpServletResponse response){
		List<ManageSysBean> list = null;
		try{
			list = systemService.getAllManageUrl();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/gxDirectory",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody Map<String, String> gxDirectory(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="dh",required=false) String dh,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="f_id",required=false) String f_id,
			@RequestParam(value="text",required=false) String text,
			@RequestParam(value="url",required=false) String url,
			@RequestParam(value="urltype",required=false) String urltype,
			@RequestParam(value="sort",required=false) String sort,
			@RequestParam(value="gxtype",required=false) String gxtype){
		Map<String, String> map = new HashMap<String, String>();
		ManageSysBean manageSysBean = new ManageSysBean();
		try{
			System.out.println(dh + " " + id + " " + f_id + " " + text + " " + url + " " + urltype + " " + sort + " " + gxtype);
			manageSysBean.setDh(dh);
			manageSysBean.setId(id);
			manageSysBean.setF_id(f_id);
			manageSysBean.setText(text);
			manageSysBean.setUrl(url);
			manageSysBean.setUrltype(urltype);
			manageSysBean.setSort(Integer.parseInt(sort));

			if(gxtype.equals("add")){
			 	systemService.addManageSysUrl(manageSysBean);
			}else{
				systemService.updateManageSysByDh(manageSysBean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/deleteManageSysByDh",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody Map<String, String> deleteManageSysByDh(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="dh",required=false) String dh){
		Map<String, String> map = new HashMap<String, String>();
		try{
			systemService.deleteManageSysByDh(dh);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
}
