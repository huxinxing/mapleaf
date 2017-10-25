package com.ml.xx.bean;

import java.util.List;
import java.util.Map;

public class LifePlanAccordionBean {
	
	private String id;
	private String text;
	private List<LifePlanAccordionBean> children;
	
	public LifePlanAccordionBean() {}

	public LifePlanAccordionBean(String id, String text, List<LifePlanAccordionBean> children) {
		this.id = id;
		this.text = text;
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<LifePlanAccordionBean> getChildren() {
		return children;
	}

	public void setChildren(List<LifePlanAccordionBean> children) {
		this.children = children;
	}
	
}
