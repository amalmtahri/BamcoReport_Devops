package com.application.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToOne(targetEntity = UserContactInfo.class, mappedBy = "userId")
    private UserContactInfo userContactInfo;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "username", nullable = false)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "jobtitle", nullable = false)
    private String jobtitle;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne()
    @JoinColumn(name = "manageruserid")
    private User manageruserid;


    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   // @JsonBackReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne()
    @JoinColumn(name = "createdby")
    private User createdby;

    @CreatedDate
    @Column(name = "createdat", nullable = false, updatable = false)
    private Date creationdate;

    @LastModifiedDate
    @Column(name = "updatedat")
    private Date lastupdate;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_memberships", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id"))
    private Collection<Role> roles;



    public User(long id, boolean enabled, String username, String password, String firstname, String lastname, String title, String jobtitle, User manageruserid, User createdby, Date creationdate, Date lastupdate) {
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
}
