package com.softserve.academy.food.dao.mock;

import com.softserve.academy.food.dao.UserAttachmentDao;

import com.softserve.academy.food.entity.UserAttachment;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("MockUserAttachmentDao")
public class MockUserAttachmentDao implements UserAttachmentDao {

	@Override
	public void add(UserAttachment userAttachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserAttachment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

 


}
