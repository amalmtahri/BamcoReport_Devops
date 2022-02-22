package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ProfileServiceTest {
   private long millis=System.currentTimeMillis();
    @InjectMocks
    private ProfileService profileService;

    @Mock
    private ProfileRepository repository;

    @Mock
    UserService userService;

    @Mock
    private Profile profile;

    @Mock
    IMapClassWithDto<Profile, ProfileDto> profileMapping;

    @BeforeEach
    public void setup() {
        profileService = new ProfileService(repository,userService,profileMapping);
    }


    @Test
    void saveProfile() {
        User user1 = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new Date(millis), null);
        User user2 = new User(2L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new Date(millis), null);
         profile=new Profile(1L,true,"profile1","description",new Date(millis),new Date(millis),new User(),new User());

        ProfileDto profileDto1=new ProfileDto(1L,true,"profile1","description",new Date(millis),user1,new Date(millis),user2);

        Mockito.when(profileMapping.convertToEntity(profileDto1,Profile.class))
                .thenReturn(profile);
        Mockito.when(userService.getUserById(profile.getCreatedBy().getId()))
                .thenReturn(user1);
        Mockito.when(profileService.saveProfile(profileDto1))
                .thenReturn(profileDto1);
        assertThat(profileService.saveProfile(profileDto1)).isEqualTo(profileDto1);
    }

    @Test
    @DisplayName("Should List All Profiles When making GET request to endpoint - /api/profile/find")
    void getProfiles() {

        ProfileDto profileDto1=new ProfileDto(1L,true,"profile1","description",new Date(millis),new User(),new Date(millis),new User());
        ProfileDto profileDto2=new ProfileDto(2L,true,"profile2","description",new Date(millis),new User(),new Date(millis),new User());
        List<ProfileDto> profileDtos=new ArrayList<>();
        profileDtos.add(profileDto1);
        profileDtos.add(profileDto2);
        Mockito.when(profileService.getProfiles()).thenReturn(profileDtos);
        assertThat(profileService.getProfiles()).isNotNull();
    }

    @Test
    void getProfileById() {
        ProfileDto profileDto1=new ProfileDto(1L,true,"profile1","description",new Date(millis),new User(),new Date(millis),new User());
        Mockito.when(profileService.getProfileById(1L)).thenReturn(profileDto1);
        assertNotNull(profileService.getProfileById(1L));
    }

    @Test
    void deleteProfile() {

        ProfileDto profileDto1=new ProfileDto(1L,true,"profile1","description",new Date(millis),new User(),new Date(millis),new User());

        assertThat(profileService.deleteProfile(profileDto1.getId())).isEqualTo("Profile removed !!");
    }

    @Test
    void updateProfile() {

    }
}