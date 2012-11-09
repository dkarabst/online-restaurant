package com.softserve.academy.food.controller;

import com.softserve.academy.food.entity.Attachment;
import com.softserve.academy.food.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class AttachmentController {

    private AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @RequestMapping(value = "/userinfo.html", method = RequestMethod.GET)
    public String showUserInfo() {
        return "userinfo";
    }

    @RequestMapping(value = "/userinfo.html", method = RequestMethod.POST)
    public void handleUpload(@RequestParam("file") MultipartFile file,
                             @ModelAttribute("attachment")Attachment attachment,
                             HttpSession session) {
        String path = session.getServletContext().getRealPath("/") + "/attachments/";
        File destination = new File(path + file.getOriginalFilename());
        attachmentService.add(attachmentService.setModel(file.getOriginalFilename(), destination.toString()));
        File parentDirectory = destination.getParentFile();
        parentDirectory.mkdirs();
        try {
            file.transferTo(destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}