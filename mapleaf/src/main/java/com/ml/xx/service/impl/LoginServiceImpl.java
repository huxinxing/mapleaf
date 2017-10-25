package com.ml.xx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ml.xx.bean.LoginBean;
import com.ml.xx.dao.LoginDao;
import com.ml.xx.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Resource
	private LoginDao loginDao;

	public List<LoginBean> getAllUsername() {
		// TODO Auto-generated method stub
		List<LoginBean> list = null;
		try{
			list = loginDao.getAllUsername();
			for(int i = 0;i < list.size(); i++){
				System.out.println(list.get(i).getMl_username());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
