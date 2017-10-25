package com.ml.xx.bean;

public class SysUsernameBean {
	
	private String humanId;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String age;
	private String birthday;
	private String phone;
	private String email;
	
	public SysUsernameBean() {}

	public SysUsernameBean(String humanId, String username, String password, String name, String sex, String age,
			String birthday, String phone, String email) {
		this.humanId = humanId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
	}



	public String getHumanId() {
		return humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
