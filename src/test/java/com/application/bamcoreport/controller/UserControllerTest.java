package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.entity.User;
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
class UserControllerTest {


    @Autowired
    private UserController userController;

    @Test
    void testSaveUser() {
        Date date = new Date();
        UserDto userDto = new UserDto(true,"amalmthr","amalooo","amal","mtahri","developpement","developer web",new User(),new User(), date,null);
        UserDto saveUser = userController.saveUser(userDto);
        assertThat(saveUser).isNotNull();
    }


    @Test
    void testGetAllUsers() {
        ResponseEntity<List<UserDto>> users =  userController.getAllUsers();
        assertThat(users).isNotNull();
    }

    @Test
    void testFindUser() {
        User user = userController.findUser(1L);
        assertThat(user).isNotNull();
    }

    @Test
    void testUpdateUser() {
        Date date = new Date();
        User user = new User(32, true,"update","amalooo","amal","mtahri","developpement","developer web",new User(),new User(), date,null);
        User updateUser = userController.updateUser(user);
        assertThat(updateUser).isNotNull();

    }

    @Test
    void testDeleteUser() {
        String deleteUser = userController.deleteUser(30L);
        assertThat(deleteUser).isEqualTo("User removed !!");
    }
}