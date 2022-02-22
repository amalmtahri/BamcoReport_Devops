package com.application.bamcoreport.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "isdefault", nullable = false)
    private  boolean isDefault;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private  String description;

    @CreatedDate
    @Column(name = "creationdate", nullable = false, updatable = false)
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdatedate", nullable = false)
    private Date lastUpdateDate;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="createdby", referencedColumnName = "id")
    private User createdBy;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne()
    @JoinColumn(name="lastupdateby", referencedColumnName = "id")
    private User lastUpdateBy;

    public Profile() {
    }

    public Profile(long id, boolean isDefault, String name, String description, Date creationDate, Date lastUpdateDate, User createdBy, User lastUpdateBy) {
        this.id = id;
        this.isDefault = isDefault;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.createdBy = createdBy;
        this.lastUpdateBy = lastUpdateBy;
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
