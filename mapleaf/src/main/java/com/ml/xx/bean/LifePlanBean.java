package com.ml.xx.bean;

public class LifePlanBean {
	
	private String lifePlan_dh;
	private String title;
	private String human;
	private String txTime;
	private String type;
	private int type_id;
	private String yqTime;
	private String step;
	private int step_id;
	private String deal;
	private String descplan;
	private String month;
	private String day;
	
	public LifePlanBean() {}

	public LifePlanBean(String lifePlan_dh, String title, String human, String txTime, String type, int type_id,
			String yqTime, String step, int step_id, String deal, String descplan, String month, String day) {
		this.lifePlan_dh = lifePlan_dh;
		this.title = title;
		this.human = human;
		this.txTime = txTime;
		this.type = type;
		this.type_id = type_id;
		this.yqTime = yqTime;
		this.step = step;
		this.step_id = step_id;
		this.deal = deal;
		this.descplan = descplan;
		this.month = month;
		this.day = day;
	}

	public String getLifePlan_dh() {
		return lifePlan_dh;
	}

	public void setLifePlan_dh(String lifePlan_dh) {
		this.lifePlan_dh = lifePlan_dh;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHuman() {
		return human;
	}

	public void setHuman(String human) {
		this.human = human;
	}

	public String getTxTime() {
		return txTime;
	}

	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getYqTime() {
		return yqTime;
	}

	public void setYqTime(String yqTime) {
		this.yqTime = yqTime;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public int getStep_id() {
		return step_id;
	}

	public void setStep_id(int step_id) {
		this.step_id = step_id;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public String getDescplan() {
		return descplan;
	}

	public void setDescplan(String descplan) {
		this.descplan = descplan;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
}
