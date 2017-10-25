package com.ml.xx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ml.xx.bean.SysUsernameBean;
import com.ml.xx.dao.Sys_UsernameDao;
import com.ml.xx.service.Sys_UsernameService;

@Service
public class Sys_UsernameServiceImpl implements Sys_UsernameService {
	
	@Resource
	private Sys_UsernameDao sys_UsernameDao;

	public List<SysUsernameBean> getAllUser() {
		// TODO Auto-generated method stub
		List<SysUsernameBean> list = null;
		try{
			list = sys_UsernameDao.getAllUser();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public void insertUser(SysUsernameBean sysUsernameBean) {
		// TODO Auto-generated method stub
		try{
			sys_UsernameDao.insertUser(sysUsernameBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void updateUserByHumanId(SysUsernameBean sysUsernameBean) {
		// TODO Auto-generated method stub
		try{
			sys_UsernameDao.updateUserByHumanId(sysUsernameBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void deleteByHumanId(String humanId) {
		// TODO Auto-generated method stub
		try{
			sys_UsernameDao.deleteByHumanId(humanId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<SysUsernameBean> getSearchUser(String searchStr) {
		// TODO Auto-generated method stub
		List<SysUsernameBean> list = null;
		try{
			list = sys_UsernameDao.getSearchUser(searchStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
