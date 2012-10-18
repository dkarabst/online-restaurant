package com.softserve.academy.food.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.academy.food.entity.Attachment;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.IModel;
import com.softserve.academy.food.model.AttachmentModel;

import java.util.ArrayList;
import java.util.List;

public class AttachmentDAO  {
    protected Query queryResult;
    protected Session session;

    public IModel getModelById(int id)
    {
        queryResult = session.createQuery("from ATTACHMENTS where att_id =" + id);
        session.flush();
        Attachment att = (Attachment) queryResult.list().get(0);
        return new AttachmentModel(att.getUser(),att.getName(), att.getPath(), att.getModified());
    }


    public IModel getModelByName(String name) {
        queryResult = session.createQuery("from ATTACHMENTS where name ="+name);
        session.flush();
        Attachment att = (Attachment)queryResult.list().get(0);
        return new AttachmentModel(att.getUser(),att.getName(),att.getPath(),att.getModified());
    }

    public ArrayList<AttachmentModel> getAllModels()
    {
        queryResult = session.createQuery("from ATTACHMENTS");
        session.flush();
        @SuppressWarnings("unchecked")
        List<Attachment> entityList = queryResult.list();
        AttachmentModel model = null;
        ArrayList<AttachmentModel> modelList = new ArrayList<AttachmentModel>();
        for (Attachment att : entityList)
        {
            model = new AttachmentModel(att.getUser(),att.getName(),att.getPath(),att.getModified());
            modelList.add(model);
        }
        return modelList;
    }


    public void addModel(String name) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    public void delModelById(int id) {
        String hql = "DELETE FROM ATTACHMENTS WHERE att_id =" + id;
        session.createQuery(hql);
    }


    public void delModelByName(String name) {
        String hql = "DELETE FROM ATTACHMENTS WHERE name =" + name;
        session.createQuery(hql);
    }
}
