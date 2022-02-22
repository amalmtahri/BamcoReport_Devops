package com.application.bamcoreport.controller.api;

import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "profileMembers", description = "the ProfileMember API")
public interface ProfileMemberApi {

    @GetMapping("/getAll")
    @Operation(summary = "Get all profileMembers", description = "this method return a list of profileMember dto", tags = { "profileMembers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<ProfileMemberDto>> getAllProfileMembers();

    @GetMapping("/findBy/{id}")
    @Operation(summary = "Get profileMember by id", description = "search with id profileMember", tags = { "profileMember" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "profileMember with this id is found"),
            @ApiResponse(responseCode  = "404", description = "profileMember with this ID is not found")
    })
    ProfileMemberDto findProfileMember(@PathVariable long id);

    @PostMapping("/add")
    @Operation(summary = "Add a new profileMember", description = "This method for added profileMember", tags = { "profileMembers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "object profileMember invalid")
    })
    ProfileMemberDto saveProfileMember(@RequestBody ProfileMemberDto profileMemberDto);


    @PutMapping("/update")
    @Operation(summary = "update profileMember", description = "update data of profileMember", tags = { "profileMembers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "profileMember updated"),
    })
    ProfileMemberDto updateProfileMember(@RequestBody ProfileMemberDto profileMember);

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete profileMember", description = "Delete profileMember with id", tags = { "profileMembers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "profileMember deleted"),
    })
    String deleteProfileMember(@PathVariable long id);
}
