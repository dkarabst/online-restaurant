package com.softserve.academy.food.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Repository;

@Repository
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
	return new File(path).delete();
    }

    public boolean fileExists(String file)
    {
	return new File(file).exists();
    }

}
