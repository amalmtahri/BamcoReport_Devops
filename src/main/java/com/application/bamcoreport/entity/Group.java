package com.application.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "parentpath", nullable = false)
    private String parentpath;

    @Column(name = "displayname", nullable = false)
    private String displayname;

    @Column(name = "description", nullable = false)
    private String description;


    @ManyToOne()
    @JoinColumn(name="createdby")
    private User createdby;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "createdby")
    //private User createdBy;

    @CreatedDate
    @Column(name = "createdat", nullable = false, updatable = false)
    private Date creationdate;

    @LastModifiedDate
    @Column(name = "updatedat")
    private Date lastupdate;


    public Group() {
    }

    public Group(long id, String name, String parentpath, String displayname, String description, User createdby, Date creationdate, Date lastupdate) {
        this.id = id;
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
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentpath='" + parentpath + '\'' +
                ", displayname='" + displayname + '\'' +
                ", description='" + description + '\'' +
                ", createdby=" + createdby +
                ", creationdate=" + creationdate +
                ", lastupdate=" + lastupdate +
                '}';
    }
}
