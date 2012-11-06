package com.softserve.academy.food.service;

import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.softserve.academy.food.dao.AttachDAO;

@Service
public class AttachmentService
{
    @Autowired
    private AttachDAO io;

    @Autowired
    private SystemPropertiesService SystemPropServ;

    // check the file to parameters like:size and extension
    private boolean checkFile(CommonsMultipartFile f)
    {
	boolean res = true;
	if ((f.getSize() > Long.parseLong((SystemPropServ.getProperties().getProperty("maxUploadSize").toString()))
		|| !f.getContentType().contains("image")))
	{
	    res = false;
	}
	return res;
    }

    public URL saveDishImg(CommonsMultipartFile img, int dishId) throws IOException
    {
	URL res = null;
	String fname = dishId + "_" + img.getOriginalFilename();
	String fpath = SystemPropServ.getProperties().getProperty("patchToDishImg") + fname;

	if (checkFile(img) && !io.fileExists(fpath))
	{
	    io.addImage(img.getBytes(), fpath);	   
	    res = new URL(SystemPropServ.getProperties().getProperty("urlToDishImg")+fname);
	}

	return res;
    }

    public URL saveClientImg(CommonsMultipartFile img, int clientId) throws IOException
    {
	URL res = null;
	String fname = clientId + "_" + img.getOriginalFilename();
	String fpath = SystemPropServ.getProperties().getProperty("patchToClientImg") + fname;

	if (checkFile(img) && !io.fileExists(fpath))
	{
	    io.addImage(img.getBytes(), fpath);
	    res = new URL(SystemPropServ.getProperties().getProperty("urlToClientImg")+fname);
	}

	return res;
    }

    private String getFileName(URL url)
    {
	return url.toString().substring(url.toString().lastIndexOf('/')+1, url.toString().length());	
    }

    public boolean deleteClientImg(URL url)
    {	
	return io.delImage(SystemPropServ.getProperties().getProperty("patchToClientImg") + getFileName(url));
    }

    public boolean deleteDishImg(URL url)
    {	
	return io.delImage(SystemPropServ.getProperties().getProperty("patchToDishImg") + getFileName(url));	
    }

}
