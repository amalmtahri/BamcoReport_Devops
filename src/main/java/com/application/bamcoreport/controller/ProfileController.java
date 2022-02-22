package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.controller.api.ProfileApi;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.service.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/api/profile")
@RestController
@RequestMapping("/api/profile")
@SecurityRequirement(name = "bearerAuth")
public class ProfileController implements ProfileApi {

    @Autowired
    private ProfileService service;

    @Override
    public ProfileDto saveProfile(@RequestBody ProfileDto profile){
        return service.saveProfile(profile);
    }

    @PostMapping("/addList")
    public List<Profile> saveProfiles(@RequestBody List<Profile> profiles){
        return service.saveProfiles(profiles);
    }

    @Override
    public ResponseEntity<List<ProfileDto>> getAllProfiles(){
        List<ProfileDto> profileDto = service.getProfiles();
        return ResponseEntity.ok(profileDto);
    }

    @Override
    public ProfileDto findProfile(@PathVariable long id){
        return service.getProfileById(id);
    }


    @Override
    public String deleteProfile(@PathVariable long id){
        return service.deleteProfile(id);
    }

    @Override
    public ProfileDto updateProfile(@RequestBody ProfileDto profile){
        return service.updateProfile(profile);
    }
}
