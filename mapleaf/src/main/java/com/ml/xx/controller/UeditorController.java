package com.ml.xx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sysManagerUE")
public class UeditorController {
	
	@RequestMapping(value="/goUE",method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView goManager(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/ueditor/ueditor");
		return mav;
	}
}
