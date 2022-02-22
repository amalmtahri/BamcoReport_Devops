package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;

import java.util.Date;


@ApiModel("Role")
public class RoleDto {


    private long id;
    private String name;
    private String displayname;
    private String description;

    private User createdby;
    private Date creationdate;
    private Date lastupdate;


    public RoleDto() {
    }

    public RoleDto(long id, String name, String displayname, String description, User createdby, Date creationdate, Date lastupdate) {
        this.id = id;
        this.name = name;
        this.displayname = displayname;
        this.description = description;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdate = lastupdate;
    }
    public RoleDto(String name, String displayname, String description, User createdby, Date creationdate, Date lastupdate) {
        this.name = name;
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
        return "RoleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayname='" + displayname + '\'' +
                ", description='" + description + '\'' +
                ", createdby=" + createdby +
                ", creationdate=" + creationdate +
                ", lastupdate=" + lastupdate +
                '}';
    }
}
