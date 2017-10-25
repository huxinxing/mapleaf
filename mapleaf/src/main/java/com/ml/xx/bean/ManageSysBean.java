package com.ml.xx.bean;

import java.util.List;

public class ManageSysBean {
	
	private String dh;
	private String id;
	private String f_id;
	private String text;
	private String url;
	private String urltype;
	private String hasChildern;
	private List<ManageSysBean> children;
	private int sort;
	private String iconCls ;
	
	public ManageSysBean() {}

	public ManageSysBean(String dh, String id, String f_id, String text, String url, String urltype, String hasChildern,
			List<ManageSysBean> children, int sort, String iconCls) {
		this.dh = dh;
		this.id = id;
		this.f_id = f_id;
		this.text = text;
		this.url = url;
		this.urltype = urltype;
		this.hasChildern = hasChildern;
		this.children = children;
		this.sort = sort;
		this.iconCls = iconCls;
	}



	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getF_id() {
		return f_id;
	}

	public void setF_id(String f_id) {
		this.f_id = f_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrltype() {
		return urltype;
	}

	public void setUrltype(String urltype) {
		this.urltype = urltype;
	}

	public String getHasChildern() {
		return hasChildern;
	}

	public void setHasChildern(String hasChildern) {
		this.hasChildern = hasChildern;
	}

	public List<ManageSysBean> getChildren() {
		return children;
	}

	public void setChildren(List<ManageSysBean> children) {
		this.children = children;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	
	
}
