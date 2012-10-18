package com.softserve.academy.food.model;


import com.softserve.academy.food.entity.User;
import java.util.Date;

public class AttachmentModel implements IModel{
    private User	user;
    private String  name;
    private String  Path;
    private Date modified;

    public AttachmentModel()
    {
    }

    public AttachmentModel(User user,String name,String Path,Date modified)
    {
        this.user = user;
        this.name=name;
        this.Path = Path;
        this.modified = modified;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPath(){
        return Path;
    }

    public void setPath(String Path){
        this.Path=Path;
    }

    public Date getModified(){
        return modified;
    }

    public void setModified(Date modified){
        this.modified=modified;
    }
}
