package com.ml.xx.dao;

import java.util.List;

import com.ml.xx.bean.ManageSysBean;

public interface SystemDao {
	
	public List<ManageSysBean> loadHeaderMean(); //加载头部导航栏
	
	public List<ManageSysBean> loadMenuTree(); //加载树形菜单
	
	public List<ManageSysBean> pzurl();  //加载所有菜单目录
	
	public void addurl(ManageSysBean manageSys); //添加菜单url
	
	public void updateManageSysUrlByDh(ManageSysBean manageSys);  //修改菜单url
	
	public void deleteUrlByDh(String dh); //根据单号删除url
	
	public List<ManageSysBean> getManageSysByid(String id);  //根据id获取子元素
	
	public List<ManageSysBean> getAllManageUrl();  //获取所有的url信息
	
	public void editHasChildernByF_id(String f_id);  //通过f_id修改是否有子节点字段
	
	public void addManageSysUrl(ManageSysBean manageSys);  //添加manageSys
	
	public void updateManageSysByDh(ManageSysBean manageSys); //根据单号修改ManageSys
	
	public void deleteManageSysByDh(String dh); //根据单号删除ManageSys
	
	
}
