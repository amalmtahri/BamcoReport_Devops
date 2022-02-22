package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.UserMemberShipDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.entity.UserMemberShip;
import com.application.bamcoreport.repository.UserMembershipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public class UserMembershipService implements IUserMembership{

    @Autowired
    IMapClassWithDto<UserMemberShip, UserMemberShipDto> userMembershipMapping;

    @Autowired
    private UserMembershipRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;


    @Override
    public List<UserMemberShipDto> getUserMemberships() {
        log.info("Get all userMemberships");
        List<UserMemberShip> userMemberShips = repository.findAll();
        return userMembershipMapping.convertListToListDto(userMemberShips, UserMemberShipDto.class);
    }

    public UserMemberShip saveUserMembership(UserMemberShip userMemberShip){
        User getUserData = userService.getUserById(userMemberShip.getUserid().getId());
        userMemberShip.setUserid(getUserData);
        Role getRoleData = roleService.getRoleById(userMemberShip.getRoleid().getId());
        userMemberShip.setRoleid(getRoleData);
        Group getGroupData = groupService.getGroupById(userMemberShip.getGroupid().getId());
        userMemberShip.setGroupid(getGroupData);
        User getAssignedBy = userService.getUserById(userMemberShip.getAssignedby().getId());
        userMemberShip.setAssignedby(getAssignedBy);
        log.info("Saving a userMembership into database");
        return repository.save(userMemberShip);
    }

    public UserMemberShip getUserMembershipById(long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteUserMembership(long id){
        log.info("Delete userMembership {}", id);
        repository.deleteById(id);
         return "UserMembership removed !!";
    }

    public UserMemberShip updateUserMembership(UserMemberShip userMemberShip){
        UserMemberShip existingUserMembership = repository.findById(userMemberShip.getId()).orElse(null);
        if(existingUserMembership !=null){
            System.out.println(userMemberShip.getUserid().getId());
        User userup=userService.getUserById(userMemberShip.getUserid().getId());
        Role getRoleData = roleService.getRoleById(userMemberShip.getRoleid().getId());
        Group getGroupData = groupService.getGroupById(userMemberShip.getGroupid().getId());
        User getAssignedBy = userService.getUserById(userMemberShip.getAssignedby().getId());
        existingUserMembership.setUserid(userup);
        existingUserMembership.setRoleid(getRoleData);
        existingUserMembership.setGroupid(getGroupData);
        existingUserMembership.setAssignedby(getAssignedBy);
        log.info("Update data of userMembership");

        }
        return repository.save(existingUserMembership);
    }
}
