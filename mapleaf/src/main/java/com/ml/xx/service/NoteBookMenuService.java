package com.ml.xx.service;

import java.util.List;

import com.ml.xx.bean.NoteBooKMenuBean;
import com.ml.xx.bean.NoteBookContain;
import com.ml.xx.bean.OthersBean;

public interface NoteBookMenuService {

	public NoteBooKMenuBean getNoteBookTree();  //获取到笔记树形菜单
	
	public List<NoteBooKMenuBean> getNoteBookCombox();  //获取到笔记CoxBox
		
	public void insertNoteBookMenu(NoteBooKMenuBean noteBookMenuBean); //插入菜单
	
	public List<NoteBooKMenuBean> getNoteBookMenuManageDg(); //获取所有菜单信息
	
	public void deleteNoteBookMenuBeanByid(String id); //通过id删除菜单
	
	public void EditNoteBookMMById(NoteBooKMenuBean noteBookMenuBean); //通过id修改菜单名称
	
	public List<NoteBookContain> getNoteBookChildernNodeById(String id); //通过id获取子节点
	
	public void insertNoteBookContain(NoteBookContain noteBookContain);  //插入主题内容

	public void editNoteBookContain(NoteBookContain noteBookContain);  //通过id修改内容

	public void deleteNoteBookContain(NoteBookContain noteBookContain);  //通过id删除内容

	public List<NoteBookContain> nNBloadNbTextListdgearch(OthersBean othersBean);  //通过id的名称的模糊查询
	
}
