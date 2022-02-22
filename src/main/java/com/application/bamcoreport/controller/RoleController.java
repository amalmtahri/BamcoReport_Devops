package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.controller.api.RoleApi;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.service.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@SecurityRequirement(name = "bearerAuth")
public class RoleController implements RoleApi {


    @Autowired
    private RoleService service;

    @Override
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        List<RoleDto> roleDto = service.getRoles();
        return ResponseEntity.ok(roleDto);
    }

    @Override
    public RoleDto saveRole(@RequestBody RoleDto roleDto){
        return service.saveRole(roleDto);
    }

    @Override
    public Role findById(@PathVariable long id){
        return service.getRoleById(id);
    }

    @Override
    public String deleteRole(@PathVariable long id){
        return service.deleteRole(id);
    }

   @Override
    public Role updateRole(@RequestBody Role role){
        return service.updateRole(role);
    }


}
