package com.softserve.academy.food.dao.impl;


import com.softserve.academy.food.dao.IAttachmentDao;
import com.softserve.academy.food.entity.DishAttachment;
import com.softserve.academy.food.entity.UserAttachment;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("attachmentDao")
public class AttachmentDao extends Dao implements IAttachmentDao {

	@Override
	public DishAttachment addDishAttachment( DishAttachment dishAttachment ) {
		
		dishAttachment.setId( (Long)sessionFactory.getCurrentSession().save(dishAttachment));
        return dishAttachment;
	}
	
    @Override
    public DishAttachment getDishAttachment( Long id ) {
    	
        return (DishAttachment) getSession().load(DishAttachment.class, id);
    }

    @Override
    public List<DishAttachment> getAllDishAttachment() {
    	
        return getSession().createQuery("from DishAttachment").list();
    }

	@Override
	public UserAttachment addUserAttachment(UserAttachment userAttachment) {

		userAttachment.setId( (Long)sessionFactory.getCurrentSession().save(userAttachment));
        return userAttachment;
	}

	@Override
	public UserAttachment getUserAttachment(Long id) {
		
		return (UserAttachment) getSession().load(UserAttachment.class, id);
	}

	@Override
	public List<UserAttachment> getAllUserAttachment() {

		return getSession().createQuery("from UserAttachment").list();
	}
	
    @Override
    public void delete(Long id) {
        Query query = getSession().createQuery("delete Attachment where id = :attachmentId");
        query.setLong("attachmentId", id);
        query.executeUpdate();
    }

}
