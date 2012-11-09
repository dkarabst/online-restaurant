package com.softserve.academy.food.dao.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Repository;

@Repository("attachDao")
public class AttachDAO
{
    public void addImage(byte[] img, String path) throws IOException
    {
	BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(new File(path)));
	bs.write(img);
	bs.close();
    }

    public boolean delImage(String path)
    {
	boolean res = true;
	if (!new File(path).delete())
	{
	    res = false;
	}
	return res;
    }

    public boolean fileExists(String file)
    {
	return new File(file).exists();
    }

}
