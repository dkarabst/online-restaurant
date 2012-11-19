package com.softserve.academy.food.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.softserve.academy.food.model.UserAttachmentModel;

public interface IUserAttachmentService {

    public void add( MultipartFile file );
    public List<UserAttachmentModel> getAll();
    public  UserAttachmentModel get( Long id );
    
	public String getPath();
	public void setPath( String path );

}
