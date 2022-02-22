package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.*;
import com.application.bamcoreport.repository.ProfileMemberRepository;
import com.application.bamcoreport.repository.ProfileRepository;
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
class ProfileMemberServiceTest {
    private long millis=System.currentTimeMillis();

    @InjectMocks
    private ProfileMemberService profileMemberService;

    @Mock
    private ProfileMemberRepository profileMemberRepository;

    @Mock
    UserService userService;

    @Mock
    private ProfileMember profileMember;

    @Mock
    RoleService roleService;

    @Mock
    ProfileService profileService;

    @Mock
    IMapClassWithDto<Profile, ProfileDto> profileMapping;

    @Mock
    IMapClassWithDto<ProfileMember, ProfileMemberDto> profileMemberMapper;

    @Mock
    Profile profile;

    @Mock
    User user;

    @Mock
    Group group;
    @Mock
    Role role;

    @BeforeEach
    public void setup() {
        profileMemberService = new ProfileMemberService(profileMemberRepository,userService,roleService,profileService,profileMapping,profileMemberMapper);
    }


    @Test
    void saveProfile() {
        profile=new Profile(1L,true,"profile1","description",new java.sql.Date(millis),new java.sql.Date(millis),new User(),new User());
         user = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new java.sql.Date(millis), null);
        group = new Group(1L,"group","path","displayNAme","description",user,new Date(millis),new Date(millis));
        role =new Role(1L,"rolename","displayname","description",user,new Date(millis),new Date(millis));

        ProfileMemberDto profileMemberDto=new ProfileMemberDto(1L,profile,user,group,role,new Date(millis),new Date(millis));

        profileMember=new ProfileMember(1L,profile,user,group,role,new Date(millis),new Date(millis));
        Mockito.when(profileMemberMapper.convertToEntity(profileMemberDto,ProfileMember.class))
                .thenReturn(profileMember);
        Mockito.when(profileMemberService.saveProfile(profileMemberDto))
                .thenReturn(profileMemberDto);
        assertThat(profileMemberService.saveProfile(profileMemberDto)).isEqualTo(profileMemberDto);
    }

    @Test
    void getProfileMembers() {

        profile=new Profile(1L,true,"profile1","description",new java.sql.Date(millis),new java.sql.Date(millis),new User(),new User());
        user = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new java.sql.Date(millis), null);
        group = new Group(1L,"group","path","displayNAme","description",user,new Date(millis),new Date(millis));
        role =new Role(1L,"rolename","displayname","description",user,new Date(millis),new Date(millis));

        ProfileMemberDto profileMemberDto=new ProfileMemberDto(1L,profile,user,group,role,new Date(millis),new Date(millis));

        List<ProfileMemberDto> profileDtos=new ArrayList<>();
        profileDtos.add(profileMemberDto);
        Mockito.when(profileMemberService.getProfileMembers()).thenReturn(profileDtos);
        assertThat(profileMemberService.getProfileMembers()).isNotNull();
    }

    @Test
    void getProfileMemberById() {
        profile=new Profile(1L,true,"profile1","description",new java.sql.Date(millis),new java.sql.Date(millis),new User(),new User());
        user = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new java.sql.Date(millis), null);
        group = new Group(1L,"group","path","displayNAme","description",user,new Date(millis),new Date(millis));
        role =new Role(1L,"rolename","displayname","description",user,new Date(millis),new Date(millis));

        ProfileMemberDto profileMemberDto=new ProfileMemberDto(1L,profile,user,group,role,new Date(millis),new Date(millis));

        Mockito.when(profileMemberService.getProfileMemberById(1L)).thenReturn(profileMemberDto);
        assertNotNull(profileMemberService.getProfileMemberById(1L));
    }

    @Test
    void deleteProfileMember() {
        profile=new Profile(1L,true,"profile1","description",new java.sql.Date(millis),new java.sql.Date(millis),new User(),new User());
        user = new User(1L, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), new java.sql.Date(millis), null);
        group = new Group(1L,"group","path","displayNAme","description",user,new Date(millis),new Date(millis));
        role =new Role(1L,"rolename","displayname","description",user,new Date(millis),new Date(millis));

        ProfileMemberDto profileMemberDto=new ProfileMemberDto(1L,profile,user,group,role,new Date(millis),new Date(millis));

        assertThat(profileMemberService.deleteProfileMember(profileMemberDto.getId())).isEqualTo("ProfileMember removed !!");
    }
}