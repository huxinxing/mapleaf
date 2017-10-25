package com.ml.xx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.attribute.standard.MediaSize.Other;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ml.xx.bean.NoteBooKMenuBean;
import com.ml.xx.bean.NoteBookContain;
import com.ml.xx.bean.OthersBean;
import com.ml.xx.service.NoteBookMenuService;

@Controller
@RequestMapping("/sysManager")
public class NoteBookController {
	
	@Resource
	private NoteBookMenuService noteBookMenuService;
	
	@RequestMapping(value="/goUeditor",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView goManager(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/notebook/notebook");
		return mav;
	}
	
	@RequestMapping(value="/getNotebooxShowSpace",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView getNotebooxShowSpace(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/notebook/noteBookUnity/ShowSpace");
		return mav;
	}
	
	@RequestMapping(value="/goMenuManager",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView goMenuManager(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/notebook/noteBookUnity/MenuManager");
		return mav;
	}
	
	@RequestMapping(value="/goNewNoteBookPagers",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView goNewNoteBookPagers(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/notebook/noteBookUnity/NewNoteBookPager");
		return mav;
	}
	
	@RequestMapping(value="/getNoteBookTree",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<NoteBooKMenuBean> getNoteBookTree(Model model,HttpServletRequest request,HttpServletResponse response){
		List<NoteBooKMenuBean> list = new ArrayList<NoteBooKMenuBean>();
		try{
			list.add(noteBookMenuService.getNoteBookTree());
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/getNoteBookCombox",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<NoteBooKMenuBean> getNoteBookCombox(Model model,HttpServletRequest request,HttpServletResponse response){
		List<NoteBooKMenuBean> list = null;
		try{
			list = noteBookMenuService.getNoteBookCombox();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/getNoteBookMenuManageDg",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<NoteBooKMenuBean> getNoteBookMenuManageDg(Model model,HttpServletRequest request,HttpServletResponse response){
		List<NoteBooKMenuBean> list = null;
		try{
			list = noteBookMenuService.getNoteBookMenuManageDg();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/addNoteBooxNewMenu",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,String> addNoteBooxNewMenu(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="newPagerName",required=false) String text,
			@RequestParam(value="F_noteBookCombox",required=false) String f_id){
		Map<String, String> map = new HashMap<String, String>();
		NoteBooKMenuBean noteBookMenuBean = new NoteBooKMenuBean();
		System.out.println(text + " " + f_id);
		try{
			noteBookMenuBean.setF_id(f_id);
			noteBookMenuBean.setText(text);
			noteBookMenuService.insertNoteBookMenu(noteBookMenuBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/deleteNoteBookMM",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,String> deleteNoteBookMM(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="id",required=false) String id){
		Map<String, String> map = new HashMap<String, String>();
		try{
			noteBookMenuService.deleteNoteBookMenuBeanByid(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/EditNoteBookMM",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,String> EditNoteBookMM(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="text",required = false) String text){
		Map<String, String> map = new HashMap<String, String>();
		NoteBooKMenuBean noteBookMenuBean = new NoteBooKMenuBean();
		try{
			System.out.println(id + " " + text);
			noteBookMenuBean.setId(id);
			noteBookMenuBean.setText(text);
			noteBookMenuService.EditNoteBookMMById(noteBookMenuBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	/*
	 * 编写主题内容->加载主题内容各项的菜单
	 */
	@RequestMapping(value="/nNBloadNbTextListdg",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<NoteBookContain> nNBloadNbTextListdg(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="id",required=false) String id){
		List<NoteBookContain> list = null;
		try{
			list = noteBookMenuService.getNoteBookChildernNodeById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	
	/*
	 * 编写主题内容->插入主题新内容
	 * 	
	 */
	@RequestMapping(value="/insertNoteBookContain",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> insertNoteBookContain(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="containTitle",required=false) String containTitle,
			@RequestParam(value="timeEdit",required=false) String timeEdit,
			@RequestParam(value="containText",required=false) String containText,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="containdh",required=false) String containdh){
		Map<String, String> map = new HashMap<String, String>();
		NoteBookContain noteBookContain = new NoteBookContain();
		if(id == null){
			return map;
		}
		try{
			noteBookContain.setId(id);
			noteBookContain.setContainTitle(containTitle);
			noteBookContain.setTimeEdit(timeEdit);
			noteBookContain.setContainText(containText);
			noteBookContain.setContaindh(containdh);
			noteBookMenuService.insertNoteBookContain(noteBookContain);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping(value="/editNoteBookPagerTh",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> editNoteBookPagerTh(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="containTitle",required=false) String containTitle,
			@RequestParam(value="timeEdit",required=false) String timeEdit,
			@RequestParam(value="containText",required=false) String containText,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="containdh",required=false) String containdh){
		Map<String, String> map = new HashMap<String, String>();
		NoteBookContain noteBookContain = new NoteBookContain();
		if(id == null){
			return map;
		}
		try{
			noteBookContain.setId(id);
			noteBookContain.setContainTitle(containTitle);
			noteBookContain.setTimeEdit(timeEdit);
			noteBookContain.setContainText(containText);
			noteBookContain.setContaindh(containdh);
			noteBookMenuService.editNoteBookContain(noteBookContain);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/deleteNoteBookPagerTh",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, String> deleteNoteBookPagerTh(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="containTitle",required=false) String containTitle,
			@RequestParam(value="timeEdit",required=false) String timeEdit,
			@RequestParam(value="containText",required=false) String containText,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="containdh",required=false) String containdh){
		Map<String, String> map = new HashMap<String, String>();
		NoteBookContain noteBookContain = new NoteBookContain();
		if(id == null){
			return map;
		}
		try{
			noteBookContain.setId(id);
			noteBookContain.setContainTitle(containTitle);
			noteBookContain.setTimeEdit(timeEdit);
			noteBookContain.setContainText(containText);
			noteBookContain.setContaindh(containdh);
			noteBookMenuService.deleteNoteBookContain(noteBookContain);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping(value="/nNBloadNbTextListdgearch",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<NoteBookContain> nNBloadNbTextListdgearch(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="search",required=false) String search){
		List<NoteBookContain> list = null;
		OthersBean othersBean = new OthersBean(); 
		try{
			othersBean.setId(id);
			othersBean.setSearch(search);
			list = noteBookMenuService.nNBloadNbTextListdgearch(othersBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
