package com.application.bamcoreport.controller.api;

import com.application.bamcoreport.DTO.models.ChangePasswordDto;
import com.application.bamcoreport.DTO.models.JsonResponse;
import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "users", description = "the User API")
public interface UserApi {
    @PostMapping(value="/addUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    //anotation de swagger pour ajouter une description du fonction
    @Operation(summary = "Add a new user", description = "This method for added user", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "object user invalid")
    })
    UserDto saveUser(@RequestBody UserDto userDto);

    @GetMapping("/findUsers")
    @Operation(summary = "Get all users", description = "this method return a list of user dto", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping("/findUser/{id}")
    @Operation(summary = "Get user by id", description = "search with id user", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "User with this id is found"),
            @ApiResponse(responseCode  = "404", description = "User with this ID is not found")
    })
    User findUser(@PathVariable Long id);

    @PutMapping("/updateUser")
    @Operation(summary = "Update user data", description = "update data of user", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "user updated"),
    })
    User updateUser(@RequestBody User user);

    @DeleteMapping("/deleteUser/{id}")
    @Operation(summary = "Delete user", description = "Delete user with id", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "User deleted"),
    })
    String deleteUser(@PathVariable Long id);

    @PostMapping(value="/changePassword",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "change user password", description = "This method for change user password", tags = { "users" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "username or password invalid")
    })
    JsonResponse<UserDto> ChangeUserPassword(@RequestBody ChangePasswordDto userDto);
}
