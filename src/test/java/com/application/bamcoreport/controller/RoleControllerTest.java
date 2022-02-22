package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.entity.Role;
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
class RoleControllerTest {

    @Autowired
    private RoleController roleController;

    @Test
    void testGetAllRoles() {
        ResponseEntity<List<RoleDto>> roles =  roleController.getAllRoles();
        assertThat(roles).isNotNull();
    }

    @Test
    void testSaveRole() {
        Date date = new Date();
        RoleDto roleDto = new RoleDto("role testing","role","role description",new User(),date,null);
        RoleDto saveRole = roleController.saveRole(roleDto);
        assertThat(saveRole).isNotNull();
    }

    @Test
    void testFindById() {
        Role role = roleController.findById(1L);
        assertThat(role).isNotNull();
    }

    @Test
    void testDeleteRole() {
        String deleteRole = roleController.deleteRole(5L);
        assertThat(deleteRole).isEqualTo("Role removed !!");
    }

    @Test
    void testUpdateRole() {
        Date date = new Date();
        Role role = new Role(1,"role update","role","role description",new User(),date,null);
        Role updateRole = roleController.updateRole(role);
        assertThat(updateRole).isNotNull();

    }
}