package com.ml.xx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ml.xx.bean.ManageSysBean;
import com.ml.xx.dao.SystemDao;
import com.ml.xx.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService{

	@Resource
	private SystemDao systemDao;
	
	public List<ManageSysBean> loadHeaderMean() {
		// TODO Auto-generated method stub
		List<ManageSysBean> list = null;
		try{
			list = systemDao.loadHeaderMean();

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ManageSysBean> loadMenuTree(String id) {
		// TODO Auto-generated method stub
		
		List<ManageSysBean> list = new ArrayList<ManageSysBean>();
		try{
			List<ManageSysBean> tmpList = systemDao.loadMenuTree();
			for(int i = 0; i < tmpList.size(); i++){
				if(tmpList.get(i).getF_id() != null && !tmpList.get(i).getF_id().equals("null")){
					
					if(tmpList.get(i).getF_id().equals(id)){
						ManageSysBean manageSys = tmpList.get(i);
						setChilder(manageSys,tmpList);
						list.add(manageSys);
					}
					
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public void setChilder(ManageSysBean root,List<ManageSysBean> list){
		List<ManageSysBean> tmpList = new ArrayList<ManageSysBean>();
		for(int i = 0; i < list.size(); i++){
			
			if(root.getId().equals(list.get(i).getF_id())){
				if(list.get(i).getHasChildern().equals("true")){
					if(list.get(i).getF_id().equals(root.getId())){
						ManageSysBean childern = list.get(i);
						tmpList.add(list.get(i));
						setChilder(childern,list);
					}
				}else{
					if(list.get(i).getF_id().equals(root.getId())){
						tmpList.add(list.get(i));
					}
					root.setChildren(tmpList);
				}
			}
			
		}
	}

	public List<ManageSysBean> pzurl() {
		// TODO Auto-generated method stub
		List<ManageSysBean> list = null;
		try{
			list = systemDao.pzurl();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public void addurl(ManageSysBean manageSys) {
		// TODO Auto-generated method stub
		int resultInt = 0;
		try{
			systemDao.addurl(manageSys);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateManageSysUrlByDh(ManageSysBean manageSys) {
		// TODO Auto-generated method stub
		try{
			systemDao.updateManageSysUrlByDh(manageSys);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void deleteUrlByDh(String dh) {
		// TODO Auto-generated method stub
		try{
			systemDao.deleteUrlByDh(dh);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public List<ManageSysBean> getManageSysByid(String id) {
		// TODO Auto-generated method stub
		List<ManageSysBean> list = null;
		try{
			list = systemDao.getManageSysByid(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<ManageSysBean> getAllManageUrl() {
		// TODO Auto-generated method stub
		
		List<ManageSysBean> list = null;
		try{
			list = systemDao.getAllManageUrl();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public void addManageSysUrl(ManageSysBean manageSys) {
		// TODO Auto-generated method stub
		try{
			systemDao.editHasChildernByF_id(manageSys.getF_id());
			systemDao.addManageSysUrl(manageSys);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateManageSysByDh(ManageSysBean manageSys) {
		// TODO Auto-generated method stub
		try{
			systemDao.updateManageSysByDh(manageSys);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void deleteManageSysByDh(String dh) {
		// TODO Auto-generated method stub
		try{
			systemDao.deleteManageSysByDh(dh);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
