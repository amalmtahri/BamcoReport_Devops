package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public class RoleService implements IRoleService{
    @Autowired
    IMapClassWithDto<Role, RoleDto> roleMapping;
    @Autowired
    private RoleRepository repository;

    @Autowired
    private UserService userService;


    @Override
    public List<RoleDto> getRoles() {
        List<Role> roles = repository.findAll();
        log.info("Get all roles");
        return roleMapping.convertListToListDto(roles, RoleDto.class);
    }

    public RoleDto saveRole(RoleDto roleDto){
        // convert DTO to entity
        Role roleRequest = roleMapping.convertToEntity(roleDto,Role.class);
        User getUserData = userService.getUserById(roleRequest.getCreatedby().getId());
        roleRequest.setCreatedby(getUserData);
        log.info("Saving new role {} to database",roleRequest.getId());
        Role role = repository.save(roleRequest);
        // convert entity to DTO
        RoleDto roleResponse = roleMapping.convertToDto(role, RoleDto.class);
        return roleResponse;

    }

    public Role getRoleById(long id){
        log.info("Get role {}",id);
        return repository.findById(id).orElse(null);
    }

    public String deleteRole(long id){
        repository.deleteById(id);
        log.info("Delete role {} ", id);
        return "Role removed !!";
    }

    public Role updateRole(Role role) {
        Role existingRole = repository.findById(role.getId()).orElse(null);
        if(existingRole !=null) {
            User getUserData = userService.getUserById(role.getCreatedby().getId());
            existingRole.setName(role.getName());
            existingRole.setDisplayname(role.getDisplayname());
            existingRole.setDescription(role.getDescription());
            existingRole.setCreatedby(getUserData);
            log.info("Update role {}", role.getName());
        }
        return repository.save(existingRole);
    }

}
