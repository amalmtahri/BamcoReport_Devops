package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.UserMemberShipDto;

import java.util.List;

public interface IUserMembership {

    List<UserMemberShipDto> getUserMemberships();
}
