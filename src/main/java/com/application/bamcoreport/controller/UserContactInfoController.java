package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.UserContactInfoDto;
import com.application.bamcoreport.controller.api.UserContactInfoApi;
import com.application.bamcoreport.entity.ProfileMember;
import com.application.bamcoreport.entity.UserContactInfo;
import com.application.bamcoreport.service.UserContactInfoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userContactInfo")
@SecurityRequirement(name = "bearerAuth")
public class UserContactInfoController implements UserContactInfoApi {

    @Autowired
    private UserContactInfoService service;

    @Override
    public UserContactInfoDto saveUserContactInfo(@RequestBody UserContactInfoDto userContactInfo){
        return service.saveUserContactInfo(userContactInfo);
    }

    @PostMapping("/addList")
    public List<UserContactInfo> saveUserContactInfos(@RequestBody List<UserContactInfo> userContactInfos){
        return service.saveUserContactInfos(userContactInfos);
    }

    @Override
    public ResponseEntity<List<UserContactInfoDto>> getAllUserContactInfos(){
        List<UserContactInfoDto> userDto = service.getUserContactInfos();
        return ResponseEntity.ok(userDto);
    }



    @Override
    public UserContactInfoDto findUserContactInfo(@PathVariable long id){
        return service.getUserContactInfoById(id);
    }


    @Override
    public String deleteUserContactInfo(@PathVariable long id){
        return service.deleteUserContactInfo(id);
    }


    @Override
    public UserContactInfoDto updateUserContactInfo(@RequestBody UserContactInfoDto userContactInfo){
        return service.updateUserContactInfo(userContactInfo);
    }

}
