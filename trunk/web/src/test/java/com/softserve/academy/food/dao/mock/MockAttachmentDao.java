package com.softserve.academy.food.dao.mock;


import com.softserve.academy.food.dao.IAttachmentDao;
import com.softserve.academy.food.entity.DishAttachment;
import com.softserve.academy.food.entity.UserAttachment;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("MockAttachmentDao")
public class MockAttachmentDao implements IAttachmentDao {

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DishAttachment addDishAttachment(DishAttachment dishAttachment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DishAttachment getDishAttachment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DishAttachment> getAllDishAttachment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAttachment addUserAttachment(UserAttachment userAttachment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAttachment getUserAttachment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAttachment> getAllUserAttachment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}



 


}
