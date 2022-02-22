package com.application.bamcoreport.controller.api;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.entity.Profile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "profiles", description = "the profile API")
public interface ProfileApi {

    @GetMapping("/getAll")
    @Operation(summary = "Get all profiles", description = "this method return a list of profile dto", tags = { "profiles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<ProfileDto>> getAllProfiles();

    @GetMapping("/findBy/{id}")
    @Operation(summary = "Get profile by id", description = "search with id profile", tags = { "profile" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "profile with this id is found"),
            @ApiResponse(responseCode  = "404", description = "profile with this ID is not found")
    })
    ProfileDto findProfile(@PathVariable long id);

    @PostMapping("/add")
    @Operation(summary = "Add a new profile", description = "This method for added profile", tags = { "profiles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "object profile invalid")
    })
    ProfileDto saveProfile(@RequestBody ProfileDto profileDto);


    @PutMapping("/update")
    @Operation(summary = "update profile", description = "update data of profile", tags = { "profiles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "profile updated"),
    })
    ProfileDto updateProfile(@RequestBody ProfileDto profile);

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete profile", description = "Delete profile with id", tags = { "profiles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "profile deleted"),
    })
    String deleteProfile(@PathVariable long id);
}
