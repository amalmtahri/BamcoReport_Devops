package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.GroupDto;
import com.application.bamcoreport.entity.Group;
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
class GroupControllerTest {

    @Autowired
    private GroupController groupController;

    @Test
    void testGetAllGroups() {
        ResponseEntity<List<GroupDto>> groups =  groupController.getAllGroups();
        assertThat(groups).isNotNull();
    }

    @Test
    void testFindGroupById() {
        Group group = groupController.findGroupById(1L);
        assertThat(group).isNotNull();
    }

    @Test
    void testAddGroup() {
        Date date = new Date();
        GroupDto groupDto = new GroupDto("group test unitaire","test","test group","description",new User(),date,null);
        GroupDto saveGroup = groupController.addGroup(groupDto);
        assertThat(saveGroup).isNotNull();
    }

    @Test
    void updateGroup() {
        Date date = new Date();
        Group group = new Group(1,"group test unitaire","test","test group","description",new User(),date,null);
        Group updateGroup = groupController.updateGroup(group);
        assertThat(updateGroup).isNotNull();
    }

    @Test
    void deleteGroup() {
        String deleteGroup = groupController.deleteGroup(6L);
        assertThat(deleteGroup).isEqualTo("Group removed !!");
    }
}