package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.User;

import java.util.Date;

public class GroupDto {

    private long id;
    private String name;
    private String parentpath;
    private String displayname;
    private String description;
    private User createdby;
    private Date creationdate;
    private Date lastupdate;

    public GroupDto() {
    }

    public GroupDto(long id, String name, String parentpath, String displayname, String description, User createdby, Date creationdate, Date lastupdate) {
        this.id = id;
        this.name = name;
        this.parentpath = parentpath;
        this.displayname = displayname;
        this.description = description;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdate = lastupdate;
    }


    public GroupDto( String name, String parentpath, String displayname, String description, User createdby, Date creationdate, Date lastupdate) {
        this.name = name;
        this.parentpath = parentpath;
        this.displayname = displayname;
        this.description = description;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdate = lastupdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentpath() {
        return parentpath;
    }

    public void setParentpath(String parentpath) {
        this.parentpath = parentpath;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    @Override
    public String toString() {
        return "GroupDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentPath='" + parentpath + '\'' +
                ", displayname='" + displayname + '\'' +
                ", description='" + description + '\'' +
                ", createdby=" + createdby +
                ", creationdate=" + creationdate +
                ", lastupdate=" + lastupdate +
                '}';
    }
}
