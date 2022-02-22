package com.application.bamcoreport.controller.api;

import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.entity.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "roles", description = "the Role API")
public interface RoleApi {
    @GetMapping("/findRoles")
    @Operation(summary = "Get all roles", description = "this method return a list of role dto", tags = { "roles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "DB is empty")
    })
    ResponseEntity<List<RoleDto>> getAllRoles();

    @PostMapping("/saveRole")
    @Operation(summary = "Add a new role", description = "This method for added role", tags = { "roles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Success Response"),
            @ApiResponse(responseCode  = "400", description = "object role invalid")
    })
    RoleDto saveRole(@RequestBody RoleDto roleDto);

    @GetMapping("/findById/{id}")
    @Operation(summary = "Get role by id", description = "search with id role", tags = { "roles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Role with this id is found"),
            @ApiResponse(responseCode  = "404", description = "Role with this ID is not found")
    })
    Role findById(@PathVariable long id);

    @DeleteMapping("/deleteRole/{id}")
    @Operation(summary = "Delete role", description = "Delete role with id", tags = { "roles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "Role deleted"),
    })
    String deleteRole(@PathVariable long id);

    @PutMapping("/updateRole")
    @Operation(summary = "update role", description = "update data of role", tags = { "roles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "role updated"),
    })
    Role updateRole(@RequestBody Role role);
}
