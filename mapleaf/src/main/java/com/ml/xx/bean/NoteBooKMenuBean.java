package com.ml.xx.bean;

import java.util.List;

public class NoteBooKMenuBean {
	
	private String id;
	private String text;
	private List<NoteBooKMenuBean> children;
	private String f_id;
	
	public NoteBooKMenuBean() {}

	public NoteBooKMenuBean(String id, String text, List<NoteBooKMenuBean> children, String f_id) {
		this.id = id;
		this.text = text;
		this.children = children;
		this.f_id = f_id;
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

	public List<NoteBooKMenuBean> getChildren() {
		return children;
	}

	public void setChildren(List<NoteBooKMenuBean> children) {
		this.children = children;
	}

	public String getF_id() {
		return f_id;
	}

	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	
}
