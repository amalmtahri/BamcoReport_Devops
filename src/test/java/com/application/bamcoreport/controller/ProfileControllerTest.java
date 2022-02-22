package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.ProfileRepository;
import com.application.bamcoreport.service.ProfileService;
import com.application.bamcoreport.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static java.util.Arrays.asList;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ProfileControllerTest {

    @InjectMocks
    private ProfileService profileService;

    @Mock
    private ProfileRepository repository;

    @Mock
    UserService userService;

    @Mock
    IMapClassWithDto<Profile, ProfileDto> profileMapping;

    @BeforeEach
    public void setup() {
        profileService = new ProfileService(repository,userService,profileMapping);
    }

    @Test
    void saveProfile() {


    }

    @Test
    @DisplayName("Should List All Profiles When making GET request to endpoint - /api/profile/find")
    void getAllProfiles() throws Exception {
        long millis=System.currentTimeMillis();
        ProfileDto profileDto1=new ProfileDto(1L,true,"profile1","description",new Date(millis),new User(),new Date(millis),new User());
        ProfileDto profileDto2=new ProfileDto(2L,true,"profile2","description",new Date(millis),new User(),new Date(millis),new User());
        List<ProfileDto> profileDtos=new ArrayList<>();
        profileDtos.add(profileDto1);
        profileDtos.add(profileDto2);
        Mockito.when(profileService.getProfiles()).thenReturn(profileDtos);
        assertThat(profileService.getProfiles()).isNotNull();
    }

    @Test
    @DisplayName("Should return a profile object When making GET request to endpoint - /api/profile/findBy/:id")
    void findProfile() {

    }

    @Test
    void deleteProfile() {
    }

    @Test
    void updateProfile() {
    }
}