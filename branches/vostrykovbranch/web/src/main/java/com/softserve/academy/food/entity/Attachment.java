package com.softserve.academy.food.entity;

import javax.persistence.*;

@Entity
@Table(name = "ATTACHMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ATTACHMENTS_ID")
    private Long id;
    private String name;
    private String path;

    public Attachment() {}
    
    public Attachment(Long id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }



    public Attachment(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ATTACHMENTS_PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "ATTACHMENTS_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((path == null) ? 0 : path.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Attachment other = (Attachment) obj;
        if (id == null)
        {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (path == null)
        {
            if (other.path != null)
                return false;
        } else if (!path.equals(other.path))
            return false;
        return true;
    }

}
