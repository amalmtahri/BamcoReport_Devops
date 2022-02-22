package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.UserMemberShipDto;
import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.entity.UserMemberShip;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserMembershipControllerTest {

    @Autowired
    private UserMembershipController userMembershipController;

    @Test
    void testGetAllUserMemberships() {
        ResponseEntity<List<UserMemberShipDto>> memberships =  userMembershipController.getAllUserMemberships();
        assertThat(memberships).isNotNull();
    }

    @Test
    void testAddUseMembership() {
        Date date = new Date();
        UserMemberShip memberShip = new UserMemberShip(new User(),new Role(),new Group(),new User(),date);
        UserMemberShip saveUserMembership = userMembershipController.addUseMembership(memberShip);
        assertThat(saveUserMembership).isNotNull();
    }

    @Test
    void testGetUserMembership() {
        UserMemberShip userMemberShip = userMembershipController.getUserMembership(2L);
        assertThat(userMemberShip).isNotNull();
    }

    @Test
    void testDeleteUserMembership() {
        String deleteMembership = userMembershipController.deleteUserMembership(2L);
        assertThat(deleteMembership).isEqualTo("UserMembership removed !!");
    }

    @Test
    void updateUserMembership() {
    }
}