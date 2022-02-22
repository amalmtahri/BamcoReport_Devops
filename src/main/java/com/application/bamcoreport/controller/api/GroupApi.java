package com.application.bamcoreport.controller.api;

import com.application.bamcoreport.DTO.models.GroupDto;
import com.application.bamcoreport.entity.Group;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "groups", description = "the Group API")
public interface GroupApi {
    @GetMapping("/findGroups")
    @Operation(summary = "Get all groups", description = "this method return a list of Group dto", tags = { "groups" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<GroupDto>> getAllGroups();

    @GetMapping("/findGroup/{id}")
    @Operation(summary = "Get group by id", description = "search with id group", tags = { "groups" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Group with this id is found"),
            @ApiResponse(responseCode  = "404", description = "Group with this ID is not found")
    })
    Group findGroupById(@PathVariable long id);

    @PostMapping("/addGroup")
    @Operation(summary = "Add a new Group", description = "This method for added group", tags = { "groups" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "object group invalid")
    })
    GroupDto addGroup(@RequestBody GroupDto groupDto);

    @PutMapping("/updateGroup")
    @Operation(summary = "update Group", description = "update data of group", tags = { "groups" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "group updated"),
    })
    Group updateGroup(@RequestBody Group group);

    @DeleteMapping("/deleteGroup/{id}")
    @Operation(summary = "Delete group", description = "Delete group with id", tags = { "groups" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Group deleted"),
    })
    String deleteGroup(@PathVariable long id);
}
