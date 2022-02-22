package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import com.application.bamcoreport.DTO.models.UserContactInfoDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.ProfileMember;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.entity.UserContactInfo;
import com.application.bamcoreport.repository.UserContactInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class UserContactInfoServiceTest {

    private long millis=System.currentTimeMillis();

    @InjectMocks
    private UserContactInfoService userContactInfoService;

    @Mock
    private UserContactInfoRepository userContactInfoRepository;

    @Mock
    UserService userService;

    @Mock
    User user;

    @Mock
    IMapClassWithDto<UserContactInfo, UserContactInfoDto> UserContactInfoMapping;

    @BeforeEach
    public void setup() {
        userContactInfoService = new UserContactInfoService(userContactInfoRepository,userService,UserContactInfoMapping);
    }

    @Test
    void saveUserContactInfo() {

        user = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new java.sql.Date(millis), null);

        UserContactInfoDto userContactInfoDto=new UserContactInfoDto(1L,user,"email@gmail.com","0886654433","123456567","12345678","building","rooom","address","1234","city","state","country","website",true,new Date(millis),new Date(millis));
        UserContactInfo userContactInfo=new UserContactInfo(1L,user,"email@gmail.com","0886654433","123456567","12345678","building","rooom","address","1234","city","state","country","website",true);

        Mockito.when(UserContactInfoMapping.convertToEntity(userContactInfoDto, UserContactInfo.class))
                .thenReturn(userContactInfo);
        Mockito.when(userService.getUserById(userContactInfo.getUserId().getId()))
                .thenReturn(user);

        Mockito.when(userContactInfoService.saveUserContactInfo(userContactInfoDto))
                .thenReturn(userContactInfoDto);
        assertThat(userContactInfoService.saveUserContactInfo(userContactInfoDto)).isEqualTo(userContactInfoDto);
    }

    @Test
    void getUserContactInfos() {

        user = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new java.sql.Date(millis), null);

        UserContactInfoDto userContactInfoDto=new UserContactInfoDto(1L,user,"email@gmail.com","0886654433","123456567","12345678","building","rooom","address","1234","city","state","country","website",true,new Date(millis),new Date(millis));

        List<UserContactInfoDto> userContactInfoDtos=new ArrayList<UserContactInfoDto>();
        userContactInfoDtos.add(userContactInfoDto);
        Mockito.when(userContactInfoService.getUserContactInfos()).thenReturn(userContactInfoDtos);
        assertThat(userContactInfoService.getUserContactInfos()).isNotNull();
    }

    @Test
    void getUserContactInfoById() {

        user = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new java.sql.Date(millis), null);

        UserContactInfoDto userContactInfoDto=new UserContactInfoDto(1L,user,"email@gmail.com","0886654433","123456567","12345678","building","rooom","address","1234","city","state","country","website",true,new Date(millis),new Date(millis));

        Mockito.when(userContactInfoService.getUserContactInfoById(1L)).thenReturn(userContactInfoDto);
        assertNotNull(userContactInfoService.getUserContactInfoById(1L));

    }

    @Test
    void deleteUserContactInfo() {

        user = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new java.sql.Date(millis), null);

        UserContactInfoDto userContactInfoDto=new UserContactInfoDto(1L,user,"email@gmail.com","0886654433","123456567","12345678","building","rooom","address","1234","city","state","country","website",true,new Date(millis),new Date(millis));

        assertThat(userContactInfoService.deleteUserContactInfo(userContactInfoDto.getId())).isEqualTo("UserContactInfo removed !!");
    }
}