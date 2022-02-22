package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileMemberDto {
    private long id;
    private Profile profileId;
    private User userId;
    private Group groupeId;
    private Role roleId;
    private Date creationDate;
    private Date lastUpdate;

}
