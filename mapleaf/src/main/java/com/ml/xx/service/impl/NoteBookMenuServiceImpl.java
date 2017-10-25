package com.ml.xx.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ml.xx.bean.NoteBooKMenuBean;
import com.ml.xx.bean.NoteBookContain;
import com.ml.xx.bean.OthersBean;
import com.ml.xx.dao.NoteBookMenuDao;
import com.ml.xx.service.NoteBookMenuService;

@Service
public class NoteBookMenuServiceImpl implements NoteBookMenuService{
	
	@Resource
	private NoteBookMenuDao noteBookMenuDao;

	public NoteBooKMenuBean getNoteBookTree() {
		// TODO Auto-generated method stub
		NoteBooKMenuBean noteBooKMenuBean = new NoteBooKMenuBean();
		try{
		 	List<NoteBooKMenuBean> list = noteBookMenuDao.getNoteBookTree();
		 	for(int i = 0; i < list.size(); i++){
		 		if(list.get(i).getF_id() == null){
		 			noteBooKMenuBean.setF_id(list.get(i).getF_id());
		 			noteBooKMenuBean.setId(list.get(i).getId());
		 			noteBooKMenuBean.setText(list.get(i).getText());
		 			list.remove(i);
		 			int num = list.size();
		 			setChildren(noteBooKMenuBean,list,num);
		 		}
		 	}
		}catch(Exception e){
			e.printStackTrace();
		}
		return noteBooKMenuBean;
	}
	
	
	public void setChildren(NoteBooKMenuBean noteBooKMenuBean,List<NoteBooKMenuBean> list, int num){
		
		List<NoteBooKMenuBean> listTemp = new ArrayList<NoteBooKMenuBean>();
		
		try{
			
			for(int i = 0; i < num; i++){
				if(i >= list.size()){
					break;
				}
				if(list.get(i).getF_id().equals(noteBooKMenuBean.getId())){
					NoteBooKMenuBean noteBookMenuBeanTemp = list.get(i);
					listTemp.add(noteBookMenuBeanTemp);
					list.remove(i);
					num--;
					i--;
					setChildren(noteBookMenuBeanTemp, list,num);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		noteBooKMenuBean.setChildren(listTemp);
	}


	public List<NoteBooKMenuBean> getNoteBookCombox() {
		// TODO Auto-generated method stub
		List<NoteBooKMenuBean> list = null;
		try{
			list = noteBookMenuDao.getNoteBookTree();
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getId().length() > 3){
					list.remove(i);
					i--;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}


	public void insertNoteBookMenu(NoteBooKMenuBean noteBookMenuBean) {
		// TODO Auto-generated method stub
		String id = null;
		try{
			int num = noteBookMenuDao.getNumByF_id(noteBookMenuBean.getF_id()) + 1;
			
			System.out.println(num );
			
			if(num < 10){
				id = noteBookMenuBean.getF_id() + "0" + num;
			}else{
				id = noteBookMenuBean.getF_id() + num;
			}
			noteBookMenuBean.setId(id);
			noteBookMenuDao.addNoteBookMenu(noteBookMenuBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	public List<NoteBooKMenuBean> getNoteBookMenuManageDg() {
		// TODO Auto-generated method stub
		List<NoteBooKMenuBean> list = null;
		try{
			list = noteBookMenuDao.getNoteBookTree();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}


	public void deleteNoteBookMenuBeanByid(String id) {
		// TODO Auto-generated method stub
		try{
			noteBookMenuDao.deleteNoteBookMenuBeanByid(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	public void EditNoteBookMMById(NoteBooKMenuBean noteBookMenuBean) {
		// TODO Auto-generated method stub
		
		try{
			noteBookMenuDao.EditNoteBookMMById(noteBookMenuBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	public List<NoteBookContain> getNoteBookChildernNodeById(String id) {
		// TODO Auto-generated method stub
		List<NoteBookContain> list = null;
		try{
			list = noteBookMenuDao.getNoteBookChildernNodeById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}


	public void insertNoteBookContain(NoteBookContain noteBookContain) {
		// TODO Auto-generated method stub
		try{
			noteBookMenuDao.insertNoteBookContain(noteBookContain);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public void editNoteBookContain(NoteBookContain noteBookContain) {
		// TODO Auto-generated method stub
		try{
			noteBookMenuDao.editNoteBookContain(noteBookContain);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	public void deleteNoteBookContain(NoteBookContain noteBookContain) {
		// TODO Auto-generated method stub
		try{
			noteBookMenuDao.deleteNoteBookContain(noteBookContain);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	public List<NoteBookContain> nNBloadNbTextListdgearch(OthersBean othersBean) {
		// TODO Auto-generated method stub
		List<NoteBookContain> list = null;
		try{
			list = noteBookMenuDao.nNBloadNbTextListdgearch(othersBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
