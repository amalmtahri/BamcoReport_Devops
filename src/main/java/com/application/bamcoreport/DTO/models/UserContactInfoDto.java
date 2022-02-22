package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContactInfoDto {
    private long id;
    private User userId;
    private String email;
    private String phone;
    private String mobile;
    private String fax;
    private String building;
    private String room;
    private String address;
    private String zipcode;
    private String city;
    private String state;
    private String country;
    private String website;
    private boolean personal;
    private Date creationDate;
    private Date lastUpdate;

}
