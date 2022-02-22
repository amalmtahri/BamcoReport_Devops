package com.application.bamcoreport.controller.api;

import com.application.bamcoreport.DTO.models.UserMemberShipDto;
import com.application.bamcoreport.entity.UserMemberShip;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "memberships", description = "the Membership API")
public interface UserMembershipApi {

    @GetMapping("/findUserMemberships")
    @Operation(summary = "Get all memberships", description = "this method return a list of UserMembership dto", tags = { "memberships" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<UserMemberShipDto>> getAllUserMemberships();

    @PostMapping("/addUserMembership")
    UserMemberShip addUseMembership(@RequestBody UserMemberShip userMemberShip);

    @GetMapping("/findUserMembership/{id}")
    @Operation(summary = "Get UserMembership by id", description = "search with id UserMembership", tags = { "memberships" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "UserMembership with this id is found"),
            @ApiResponse(responseCode  = "404", description = "UserMembership with this ID is not found")
    })
    UserMemberShip getUserMembership(@PathVariable long id);

    @DeleteMapping("/deleteUserMembership/{id}")
    @Operation(summary = "Delete UserMembership", description = "Delete UserMembership with id", tags = { "memberships" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "UserMembership deleted"),
    })
    String deleteUserMembership(@PathVariable long id);

    @PutMapping("/updateUserMembership")
    @Operation(summary = "update UserMembership", description = "update data of UserMembership", tags = { "memberships" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "UserMembership updated"),
    })
    UserMemberShip updateUserMembership(@RequestBody UserMemberShip userMemberShip);
}
