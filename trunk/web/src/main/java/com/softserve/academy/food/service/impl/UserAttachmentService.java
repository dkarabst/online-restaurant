package com.softserve.academy.food.service.impl;

import com.softserve.academy.food.dao.IAttachmentDao;
import com.softserve.academy.food.dao.IUserDao;
import com.softserve.academy.food.entity.UserAttachment;
import com.softserve.academy.food.model.UserAttachmentModel;
import com.softserve.academy.food.service.IUserAttachmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserAttachmentService implements IUserAttachmentService {

    @Autowired
    private IAttachmentDao attachmentDao;
    @Autowired
    private IUserDao userDao;
    private String path;
    
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

    @Override
    @Transactional
    public void add( MultipartFile file ) {
    	
    	UserAttachment attach = new UserAttachment();
    	attach.setName( file.getOriginalFilename() );
    	attach.setPath( "/attach_data/" + file.getOriginalFilename() );
    	attach.setUser( userDao.get(getLogin()) );
    	
        try {
        	
            file.transferTo( new File(path + file.getOriginalFilename()) );
            attachmentDao.addUserAttachment( attach );
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

    @Override
    @Transactional
    public List<UserAttachmentModel> getAll() {
    	
        List<UserAttachmentModel> attachmentModelList = new ArrayList<UserAttachmentModel>();
        
        for(UserAttachment attachment : attachmentDao.getAllUserAttachment()) {
        	
                attachmentModelList.add(attachment.toModel());
        }
        return attachmentModelList;
    }

	@Override
	public UserAttachmentModel get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
    private String getLogin() {
        String login = "guest";

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                login = ((UserDetails) principal).getUsername();
            } else {
                login = principal.toString();
            }
        } catch (NullPointerException e) {

        }
        return login;
    }
	
	
}