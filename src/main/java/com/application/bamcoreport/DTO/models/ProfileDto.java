package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.User;
import com.sun.istack.NotNull;
import lombok.NonNull;

import java.sql.Date;

public class ProfileDto {
    private long id;
    private  boolean isDefault;
    private String name;
    private  String description;
    private Date creationDate;

    private User createdBy;
    private Date lastUpdateDate;
    private User lastUpdateBy;

    public ProfileDto() {
    }


    public ProfileDto(long id, boolean isDefault, String name, String description, Date creationDate, User createdby, Date lastUpdateDate, User lastupdateby) {
        this.id = id;
        this.isDefault = isDefault;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.createdBy = createdby;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateBy = lastupdateby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(User lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
}
