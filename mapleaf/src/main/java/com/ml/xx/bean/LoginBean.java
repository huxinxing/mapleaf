package com.ml.xx.bean;

public class LoginBean {
	
	private int ml_keyId;
	private String ml_username;
	private String ml_password;
	private String ml_phone;
	private String ml_email;
	private String ml_registerTime;
	
	public LoginBean() {}

	public LoginBean(int ml_keyId, String ml_username, String ml_password, String ml_phone, String ml_email,
			String ml_registerTime) {
		this.ml_keyId = ml_keyId;
		this.ml_username = ml_username;
		this.ml_password = ml_password;
		this.ml_phone = ml_phone;
		this.ml_email = ml_email;
		this.ml_registerTime = ml_registerTime;
	}

	public int getMl_keyId() {
		return ml_keyId;
	}

	public void setMl_keyId(int ml_keyId) {
		this.ml_keyId = ml_keyId;
	}

	public String getMl_username() {
		return ml_username;
	}

	public void setMl_username(String ml_username) {
		this.ml_username = ml_username;
	}

	public String getMl_password() {
		return ml_password;
	}

	public void setMl_password(String ml_password) {
		this.ml_password = ml_password;
	}

	public String getMl_phone() {
		return ml_phone;
	}

	public void setMl_phone(String ml_phone) {
		this.ml_phone = ml_phone;
	}

	public String getMl_email() {
		return ml_email;
	}

	public void setMl_email(String ml_email) {
		this.ml_email = ml_email;
	}

	public String getMl_registerTime() {
		return ml_registerTime;
	}

	public void setMl_registerTime(String ml_registerTime) {
		this.ml_registerTime = ml_registerTime;
	}

	@Override
	public String toString() {
		return "login [ml_keyId=" + ml_keyId + ", ml_username=" + ml_username + ", ml_password=" + ml_password
				+ ", ml_phone=" + ml_phone + ", ml_email=" + ml_email + ", ml_registerTime=" + ml_registerTime + "]";
	}
	
}
