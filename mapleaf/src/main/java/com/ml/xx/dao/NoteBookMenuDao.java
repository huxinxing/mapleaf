package com.ml.xx.dao;

import java.util.List;

import com.ml.xx.bean.NoteBooKMenuBean;
import com.ml.xx.bean.NoteBookContain;
import com.ml.xx.bean.OthersBean;

public interface NoteBookMenuDao {
	
	public List<NoteBooKMenuBean> getNoteBookTree();  //获取到笔记树形菜单
	
	public int getNumByF_id(String id); //根据id获取id的数量
	
	public void addNoteBookMenu(NoteBooKMenuBean noteBookMenuBean); //插入菜单
	
	public void deleteNoteBookMenuBeanByid(String id); //通过id删除菜单
	
	public void EditNoteBookMMById(NoteBooKMenuBean noteBookMenuBean); //通过id修改菜单名称
	
	public List<NoteBookContain> getNoteBookChildernNodeById(String id); //通过id获取子节点
	
	public void insertNoteBookContain(NoteBookContain noteBookContain);  //插入主题内容
	
	public void editNoteBookContain(NoteBookContain noteBookContain);  //通过id修改内容
	
	public void deleteNoteBookContain(NoteBookContain noteBookContain);  //通过id删除内容
	
	public List<NoteBookContain> nNBloadNbTextListdgearch(OthersBean othersBean);  //通过id的名称的模糊查询
	
	
	
}
