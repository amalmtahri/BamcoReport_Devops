package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.DTO.models.UserContactInfoDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.ProfileMember;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.entity.UserContactInfo;
import com.application.bamcoreport.repository.UserContactInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserContactInfoService {

    @Autowired
    private UserContactInfoRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    IMapClassWithDto<UserContactInfo, UserContactInfoDto> UserContactInfoMapping;

    public UserContactInfoDto saveUserContactInfo(UserContactInfoDto UserContactInfoDto){
        UserContactInfo userContactInfo=UserContactInfoMapping.convertToEntity(UserContactInfoDto,UserContactInfo.class);
        User user=userService.getUserById(userContactInfo.getUserId().getId());
        userContactInfo.setUserId(user);
        userContactInfo= repository.save(userContactInfo);
        return  UserContactInfoMapping.convertToDto(userContactInfo, UserContactInfoDto.class);
    }

    public List<UserContactInfo> saveUserContactInfos(List<UserContactInfo> userContactInfos){
        return repository.saveAll(userContactInfos);
    }

    public List<UserContactInfoDto> getUserContactInfos() {
        List<UserContactInfo> userContactInfos = repository.findAll();
        return UserContactInfoMapping.convertListToListDto(userContactInfos,UserContactInfoDto.class);
    }

    public UserContactInfoDto getUserContactInfoById(Long id){

        UserContactInfo userContactInfo= repository.findById(id).orElse(null);
        return  UserContactInfoMapping.convertToDto(userContactInfo, UserContactInfoDto.class);
    }

    public String deleteUserContactInfo(Long id){
        repository.deleteById(id);
        return "UserContactInfo removed !!";
    }

    public UserContactInfoDto updateUserContactInfo(UserContactInfoDto userContactInfoDto){
        UserContactInfo userContactInfo=UserContactInfoMapping.convertToEntity(userContactInfoDto,UserContactInfo.class);
        UserContactInfo existingUserContactInfo = repository.findById(userContactInfo.getId()).orElse(null);
        if(existingUserContactInfo!=null){
            User user=userService.getUserById(userContactInfo.getUserId().getId());
            userContactInfo.setUserId(user);
            userContactInfo=  repository.save(userContactInfo);
            return  UserContactInfoMapping.convertToDto(userContactInfo, UserContactInfoDto.class);
        }
        return  UserContactInfoMapping.convertToDto(userContactInfo, UserContactInfoDto.class);
    }
}
