package com.softserve.academy.food.dao;

import com.softserve.academy.food.entity.DishAttachment;
import com.softserve.academy.food.entity.UserAttachment;

import java.util.List;

public interface IAttachmentDao extends IDao {

	public DishAttachment addDishAttachment( DishAttachment dishAttachment );
	public DishAttachment getDishAttachment( Long id );
	public List<DishAttachment> getAllDishAttachment();
	
	public UserAttachment addUserAttachment( UserAttachment userAttachment );
	public UserAttachment getUserAttachment( Long id );
	public List<UserAttachment> getAllUserAttachment();
	
	public void delete( Long id );
	
}
