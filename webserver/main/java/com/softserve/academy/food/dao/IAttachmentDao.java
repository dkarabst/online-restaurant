package com.softserve.academy.food.dao;

import java.util.ArrayList;

import com.softserve.academy.food.entity.Attachment;
import com.softserve.academy.food.entity.User;

public interface IAttachmentDao {
	
	public Attachment get(int id);
	public ArrayList<Attachment> get(User user);
	public void add( Attachment attachment);
	public void delete(int id);

}
