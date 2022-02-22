package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.UserMemberShipDto;
import com.application.bamcoreport.controller.api.UserMembershipApi;
import com.application.bamcoreport.entity.UserMemberShip;
import com.application.bamcoreport.service.UserMembershipService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userMembership")
@SecurityRequirement(name = "bearerAuth")
public class UserMembershipController implements UserMembershipApi {


    @Autowired
    private UserMembershipService service;

    @Override
    public ResponseEntity<List<UserMemberShipDto>> getAllUserMemberships(){
        List<UserMemberShipDto> userMemberShipDtos = service.getUserMemberships();
        return ResponseEntity.ok(userMemberShipDtos);
    }

    @Override
    public UserMemberShip addUseMembership(@RequestBody UserMemberShip userMemberShip){
        return service.saveUserMembership(userMemberShip);
    }

    @Override
    public UserMemberShip getUserMembership(@PathVariable long id){
        return service.getUserMembershipById(id);
    }

    @Override
    public String deleteUserMembership(@PathVariable long id){
        return service.deleteUserMembership(id);
    }

    @Override
    public UserMemberShip updateUserMembership(@RequestBody UserMemberShip userMemberShip){
        return service.updateUserMembership(userMemberShip);
    }
}
