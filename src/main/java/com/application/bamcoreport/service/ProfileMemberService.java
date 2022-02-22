package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.ProfileMember;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.ProfileMemberRepository;
import com.application.bamcoreport.repository.ProfileMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileMemberService {
    @Autowired
    private ProfileMemberRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    ProfileService profileService;
    @Autowired
    IMapClassWithDto<Profile, ProfileDto> profileMapping;

    @Autowired
    IMapClassWithDto<ProfileMember, ProfileMemberDto> profileMemberMapper;

    public ProfileMemberDto saveProfile(ProfileMemberDto profileMemberdto){

        ProfileMember profileMember = profileMemberMapper.convertToEntity(profileMemberdto,ProfileMember.class);
        ProfileMember pm= repository.save(profileMember);
         return profileMemberMapper.convertToDto(pm, ProfileMemberDto.class);
    }

    public List<ProfileMember> saveProfiles(List<ProfileMember> profilesMembers){
        return repository.saveAll(profilesMembers);
    }

    public List<ProfileMemberDto> getProfileMembers() {
        List<ProfileMember> profilesMembers = repository.findAll();
        return profileMemberMapper.convertListToListDto(profilesMembers, ProfileMemberDto.class);
    }

    public ProfileMemberDto getProfileMemberById(Long id){

        ProfileMember profileM= repository.findById(id).orElse(null);
        return profileMemberMapper.convertToDto(profileM, ProfileMemberDto.class);

    }

    public String deleteProfileMember(Long id){
        repository.deleteById(id);
        return "ProfileMember removed !!";
    }

    public  ProfileMemberDto updateProfileMember(ProfileMemberDto profileMemberdto){
        ProfileMember profileMember=profileMemberMapper.convertToEntity(profileMemberdto,ProfileMember.class);
        ProfileMember existingProfileMember = repository.findById(profileMember.getId()).orElse(null);
        if(existingProfileMember!=null){
            User userC=userService.getUserById(profileMember.getUserId().getId());
            Role role=roleService.getRoleById(profileMember.getRoleId().getId());
            ProfileDto profiledto=profileService.getProfileById(profileMember.getProfileId().getId());
            Profile profile = profileMapping.convertToEntity(profiledto,Profile.class);
            profileMember.setProfileId(profile);
            profileMember.setRoleId(role);
            profileMember.setUserId(userC);
            ProfileMember profileMember1=  repository.save(profileMember);
            return profileMemberMapper.convertToDto(profileMember1, ProfileMemberDto.class);
        }
        return profileMemberMapper.convertToDto(profileMember, ProfileMemberDto.class);
    }
}
