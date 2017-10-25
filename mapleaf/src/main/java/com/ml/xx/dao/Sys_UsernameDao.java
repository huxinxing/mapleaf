package com.ml.xx.dao;

import java.util.List;

import com.ml.xx.bean.SysUsernameBean;

public interface Sys_UsernameDao {
	
	public List<SysUsernameBean> getAllUser();   //获取所有用户信息
	
	public void insertUser(SysUsernameBean sysUsernameBean); //插入用户信息
	
	public void updateUserByHumanId(SysUsernameBean sysUsernameBean); //根据humanId更新用户信息
	
	public void deleteByHumanId(String humanId); //根据humanId删除用户
	
	public List<SysUsernameBean> getSearchUser(String searchStr);  //模糊查询
	
	
}
