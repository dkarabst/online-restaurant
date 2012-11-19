package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.UserAttachmentModel;
import com.softserve.academy.food.service.IUserAttachmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userinfo.html")
public class UserAttachmentController {

	@Autowired
    private IUserAttachmentService userAttachmentService;

    @RequestMapping(method = RequestMethod.GET)
    public String showUserInfo(Map<String, Object> model) {
    	
        List<UserAttachmentModel> userAttachmentList = userAttachmentService.getAll();
        model.put("userAttachmentList",  userAttachmentList);
        return "userinfo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleUpload(@RequestParam("file") MultipartFile file, HttpSession session) {
    	
    	checkPath(session);
    	      
        userAttachmentService.add( file );
        
        return "redirect:/userinfo.html";
    }
    
    
    private void checkPath( HttpSession session )
    {
    	if ( userAttachmentService.getPath()==null )
    	{
    		userAttachmentService.setPath( session
    				.getServletContext().getRealPath("/") + "/attach_data/" );
    	}
    }

}