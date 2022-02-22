package com.application.bamcoreport.controller.api;

import com.application.bamcoreport.DTO.models.UserContactInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "userContactInfo", description = "the User contact info API")
public interface UserContactInfoApi {

    @GetMapping("/getAll")
    @Operation(summary = "Get all UserContactInfos", description = "this method return a list of UserContactInfo dto", tags = { "UserContactInfos" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<UserContactInfoDto>> getAllUserContactInfos();

    @GetMapping("/findBy/{id}")
    @Operation(summary = "Get UserContactInfo by id", description = "search with id UserContactInfo", tags = { "UserContactInfo" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "UserContactInfo with this id is found"),
            @ApiResponse(responseCode  = "404", description = "UserContactInfo with this ID is not found")
    })
    UserContactInfoDto findUserContactInfo(@PathVariable long id);

    @PostMapping("/add")
    @Operation(summary = "Add a new UserContactInfo", description = "This method for added UserContactInfo", tags = { "UserContactInfos" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "object UserContactInfo invalid")
    })
    UserContactInfoDto saveUserContactInfo(@RequestBody UserContactInfoDto UserContactInfoDto);


    @PutMapping("/update")
    @Operation(summary = "update UserContactInfo", description = "update data of UserContactInfo", tags = { "UserContactInfos" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "UserContactInfo updated"),
    })
    UserContactInfoDto updateUserContactInfo(@RequestBody UserContactInfoDto UserContactInfo);

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete UserContactInfo", description = "Delete UserContactInfo with id", tags = { "UserContactInfos" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "UserContactInfo deleted"),
    })
    String deleteUserContactInfo(@PathVariable long id);
}
