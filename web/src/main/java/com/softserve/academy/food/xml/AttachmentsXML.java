package com.softserve.academy.food.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;

import com.softserve.academy.food.entity.Attachment;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.AttachmentModel;

public class AttachmentsXML {
	protected Session	session;
	
	public XMLEncoder GetXMLEncoder() throws FileNotFoundException{
		return  new XMLEncoder(new FileOutputStream(new File(
				"//java//Attachments.xml")));
	}
	
	public XMLDecoder GetXMLDecoder() throws FileNotFoundException{
		return new XMLDecoder(new FileInputStream(new File(
				"//java//Attachments.xml")));
	}
	public AttachmentModel getModelById(int id)
	{
		Attachment att = (Attachment) session.get(Attachment.class, id);
		return new AttachmentModel(att.getUser(), att.getName(), att.getPath(),
				att.getModified());
	}
	
	@SuppressWarnings("unchecked")
	public AttachmentModel getModelByName(String name) throws FileNotFoundException
	{
		XMLDecoder d = GetXMLDecoder();
		AttachmentModel atmodel = null;
		ArrayList<Attachment> cat = new ArrayList<Attachment>();
		cat=(ArrayList<Attachment>) d.readObject();
		for (int i = 0; i < cat.size(); i++)
		{
			Attachment att = cat.get(i);
			if (att.getName().equals(name))
				atmodel =new AttachmentModel(att.getUser(), att.getName(), att.getPath(),
						att.getModified());
		}
		d.close();
		return atmodel;
	}
	
	@SuppressWarnings("unchecked")
	public void addModel(User user, String name, String path, Date modified) throws FileNotFoundException
	{
		Attachment c = new Attachment(user,name,path,modified);
		ArrayList<Attachment> cat = new ArrayList<Attachment>();
		if (new File("//java//Attachment.xml").exists())
		{
		XMLDecoder d = GetXMLDecoder();
		cat=(ArrayList<Attachment>) d.readObject();
		}
		cat.add(c);
		XMLEncoder e = GetXMLEncoder();
		e.writeObject(cat);
		e.close();  	
	}	
	
	@SuppressWarnings("unchecked")
	public ArrayList<AttachmentModel> getAllModels() throws FileNotFoundException
	{
		
		XMLDecoder d = GetXMLDecoder();
		ArrayList<Attachment> entityList = new ArrayList<Attachment>();
		entityList=(ArrayList<Attachment>) d.readObject();
		ArrayList<AttachmentModel> modelList = new ArrayList<AttachmentModel>();
		for (Attachment att : entityList)
		{
			modelList.add(new AttachmentModel(att.getUser(), att.getName(), att
					.getPath(), att.getModified()));
		}
		d.close();
		return modelList;
	}
	
	@SuppressWarnings("unchecked")
	public void delModelById(int id) throws FileNotFoundException
	{
		XMLDecoder d = GetXMLDecoder();
		ArrayList<Attachment> cat = new ArrayList<Attachment>();
		cat=(ArrayList<Attachment>) d.readObject();
		for (int i = 0; i < cat.size(); i++)
		{
			Attachment c = cat.get(i);
			if (c.getId().equals(id))
				cat.remove(i);
		}
		XMLEncoder e = GetXMLEncoder();
		e.writeObject(cat);
		e.close();
	}
	
	@SuppressWarnings("unchecked")
	public void delModelByName(String name) throws FileNotFoundException
	{
		XMLDecoder d = GetXMLDecoder();
		ArrayList<Attachment> cat = new ArrayList<Attachment>();
		cat=(ArrayList<Attachment>) d.readObject();

		for (Attachment c : cat)
		{
			if (c.getName().equals(name))
				cat.remove(c);
			if (cat.size()==0) break;
		}
		XMLEncoder e = GetXMLEncoder();
		e.writeObject(cat);
		e.close();
	}
	
}


