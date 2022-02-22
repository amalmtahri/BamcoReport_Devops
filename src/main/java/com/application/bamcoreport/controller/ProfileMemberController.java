package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import com.application.bamcoreport.controller.api.ProfileMemberApi;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.ProfileMember;
import com.application.bamcoreport.service.ProfileMemberService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profileMember")
@SecurityRequirement(name = "bearerAuth")
public class ProfileMemberController implements ProfileMemberApi {

    @Autowired
    private ProfileMemberService service;

    @Override
    public ProfileMemberDto saveProfileMember(@RequestBody ProfileMemberDto profileMember){
        return service.saveProfile(profileMember);
    }


    public List<ProfileMember> saveProfileMembers(@RequestBody List<ProfileMember> profileMembers){
        return service.saveProfiles(profileMembers);
    }

    @Override
    public ResponseEntity<List<ProfileMemberDto>> getAllProfileMembers(){
        List<ProfileMemberDto> profileMemberDto = service.getProfileMembers();
        return ResponseEntity.ok(profileMemberDto);
    }
    @Override
    public ProfileMemberDto findProfileMember(@PathVariable long id){
        return service.getProfileMemberById(id);
    }


    @Override
    public String deleteProfileMember(@PathVariable long id){
        return service.deleteProfileMember(id);
    }

    @Override
    public ProfileMemberDto updateProfileMember(@RequestBody ProfileMemberDto profileMember){
        return service.updateProfileMember(profileMember);
    }
}