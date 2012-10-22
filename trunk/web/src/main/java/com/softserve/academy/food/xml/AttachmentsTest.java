package com.softserve.academy.food.xml;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

import antlr.collections.List;

import com.softserve.academy.food.entity.Attachment;
import com.softserve.academy.food.entity.User;
import com.softserve.academy.food.model.AttachmentModel;

public class AttachmentsTest {


		public static void main(String[] args) throws FileNotFoundException,
				ClassNotFoundException
		{
			AttachmentsXML c = new AttachmentsXML();
			Attachment cat = new Attachment(new User(),"Photo","D:", new Date());
			cat.setId(1);
			
		
			c.addModel(new User("Bogdan","dsfsd@ee","234"),"Photo","D:", new Date());
			
			c.addModel(new User("Bogdan2","dsfsd@ee","234"),"Photo2","D:", new Date());

			ArrayList<AttachmentModel> l = (ArrayList<AttachmentModel>) c.getAllModels();
			for (AttachmentModel mm : l)
				System.out.println(mm.getName());
	
			c.getModelByName("Bogdan2");

			ArrayList<AttachmentModel> ll = (ArrayList<AttachmentModel>) c.getAllModels();
			for (AttachmentModel mm : ll)
				System.out.println(mm.getName());
		}
	}




