package com.application.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "roles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","createdby"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "displayname", nullable = false)
    private String displayname;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "createdby")
    private User createdby;

    @CreatedDate
    @Column(name = "createdat", nullable = false, updatable = false)
    private Date creationdate;

    @LastModifiedDate
    @Column(name = "updatedat")
    private Date lastupdate;


//    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Collection<User> users;

    public Role() {
    }

    public Role(long id, String name, String displayname, String description, User createdby, Date creationdate, Date lastupdate) {
        this.id = id;
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
        return "Role{" +
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
