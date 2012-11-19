package com.softserve.academy.food.controller;

import com.softserve.academy.food.model.UserAttachmentModel;
import com.softserve.academy.food.service.UserAttachmentService;

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

    private UserAttachmentService userAttachmentService;

    @Autowired
    public UserAttachmentController(UserAttachmentService attachmentService) {
        this.userAttachmentService = attachmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserInfo(Map<String, Object> model) {
        List<UserAttachmentModel> userAttachmentList = userAttachmentService.getAll();
        model.put("userAttachmentList",  userAttachmentList);
        return "userinfo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleUpload(@RequestParam("file") MultipartFile file, HttpSession session) {
        String path = session.getServletContext().getRealPath("/") + "/data/";
        File destination = new File(path + file.getOriginalFilename());
        userAttachmentService.add(userAttachmentService.setModel(file.getOriginalFilename(), "/data/" + file.getOriginalFilename()));
        File parentDirectory = destination.getParentFile();
        parentDirectory.mkdirs();
        try {
            file.transferTo(destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/userinfo.html";
    }

}