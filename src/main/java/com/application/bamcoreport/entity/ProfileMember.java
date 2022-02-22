package com.application.bamcoreport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "profilemembers")
public class ProfileMember {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="profileid" ,referencedColumnName = "id")
    private Profile profileId;

    @ManyToOne()
    @JoinColumn(name="usersid" ,referencedColumnName = "id")
    private  User userId;

    @ManyToOne()
    @JoinColumn(name="groupeid" ,referencedColumnName = "id")
    private  Group groupeId;

    @ManyToOne()
    @JoinColumn(name="roleid",referencedColumnName = "id")
    private Role roleId;

    @CreatedDate
    @Column(name = "creationdate", nullable = false, updatable = false)
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdate")
    private Date lastUpdate;


}
