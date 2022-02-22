package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("User")
public class UserDto {

    private long id;
    private boolean enabled;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String firstname;
    private String lastname;
    private String title;
    private String jobtitle;

    private User manageruserid;

    private User createdby;
    private Date creationdate;
    private Date lastupdate;


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Collection<Role> roles;

    public UserDto() {
    }

    public UserDto(long id, boolean enabled, String username, String password, String firstname, String lastname, String title, String jobtitle, User manageruserid, User createdby, Date creationdate, Date lastupdate) {
        this.id = id;
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdate = lastupdate;
    }

    public UserDto( boolean enabled, String username, String password, String firstname, String lastname, String title, String jobtitle, User manageruserid, User createdby, Date creationdate, Date lastupdate) {
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public User getManageruserid() {
        return manageruserid;
    }

    public void setManageruserid(User manageruserid) {
        this.manageruserid = manageruserid;
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
        return "UserDto{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", title='" + title + '\'' +
                ", jobtitle='" + jobtitle + '\'' +
                ", manageruserid=" + manageruserid +
                ", createdby=" + createdby +
                ", creationdate=" + creationdate +
                ", lastupdate=" + lastupdate +
                '}';
    }
}
