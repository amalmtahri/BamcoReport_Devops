package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    IMapClassWithDto<Profile, ProfileDto> profileMapping;

    public ProfileDto saveProfile(ProfileDto profiledto){
        Profile profileRequest = profileMapping.convertToEntity(profiledto,Profile.class);
        User user=userService.getUserById(profileRequest.getCreatedBy().getId());
        profileRequest.setCreatedBy(user);
        User userdata=userService.getUserById(profileRequest.getLastUpdateBy().getId());
        profileRequest.setLastUpdateBy(userdata);
        Profile profile= repository.save(profileRequest);
        return profileMapping.convertToDto(profile, ProfileDto.class);
    }

    public List<Profile> saveProfiles(List<Profile> profiles){
        return repository.saveAll(profiles);
    }

    public List<ProfileDto> getProfiles() {
        List<Profile> profiles = repository.findAll();
        List<ProfileDto> profileDtos=profileMapping.convertListToListDto(profiles,ProfileDto.class);
        return profileDtos;
    }

    public ProfileDto getProfileById(Long id){
        Profile profile= repository.findById(id).orElse(null);
        return profileMapping.convertToDto(profile, ProfileDto.class);
    }

    public String deleteProfile(Long id){
        repository.deleteById(id);
        return "Profile removed !!";
    }

    public  ProfileDto updateProfile(ProfileDto profileDto){
        Profile profile = profileMapping.convertToEntity(profileDto,Profile.class);
        Profile existingProfile = repository.findById(profile.getId()).orElse(null);
        if(existingProfile!=null){
            User userC=userService.getUserById(profile.getCreatedBy().getId());
            User userL=userService.getUserById(profile.getLastUpdateBy().getId());
            profile.setCreatedBy(userC);
            profile.setLastUpdateBy(userL);
            Profile nprofile=  repository.save(profile);
            return profileMapping.convertToDto(nprofile, ProfileDto.class);
        }
        return profileMapping.convertToDto(profile, ProfileDto.class);
    }
}
