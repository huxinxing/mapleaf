package com.ml.xx.bean;

public class NoteBookContain {
	
	private String id;
	private String containTitle;
	private String timeEdit;
	private String containText;
	private String containdh;
	
	public NoteBookContain() {}

	public NoteBookContain(String id, String containTitle, String timeEdit, String containText, String containdh) {
		this.id = id;
		this.containTitle = containTitle;
		this.timeEdit = timeEdit;
		this.containText = containText;
		this.containdh = containdh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContainTitle() {
		return containTitle;
	}

	public void setContainTitle(String containTitle) {
		this.containTitle = containTitle;
	}

	public String getTimeEdit() {
		return timeEdit;
	}

	public void setTimeEdit(String timeEdit) {
		this.timeEdit = timeEdit;
	}

	public String getContainText() {
		return containText;
	}

	public void setContainText(String containText) {
		this.containText = containText;
	}

	public String getContaindh() {
		return containdh;
	}

	public void setContaindh(String containdh) {
		this.containdh = containdh;
	}
	

}
