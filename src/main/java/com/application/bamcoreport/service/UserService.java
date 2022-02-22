package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ChangePasswordDto;
import com.application.bamcoreport.DTO.models.JsonResponse;
import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements  IUserService, UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Autowired
    IMapClassWithDto<User, UserDto> userMapping;

    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public UserDto saveUser(UserDto userdto){

        // convert DTO to entity
        User userRequest = userMapping.convertToEntity(userdto,User.class);
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User getManageruserid = this.getUserById(userRequest.getManageruserid().getId());
        userRequest.setManageruserid(getManageruserid);
        User getCreatedBy = this.getUserById(userRequest.getCreatedby().getId());
        userRequest.setCreatedby(getCreatedBy);
        log.info("Saving new user {} to database",userRequest.getId());
        User user = repository.save(userRequest);
        // convert entity to DTO
        UserDto userResponse = userMapping.convertToDto(user, UserDto.class);
        return userResponse;

    }


    @Override
    public List<UserDto> getUsers() {
        List<User> users = repository.findAll();
        log.info("get all users");
        return userMapping.convertListToListDto(users,UserDto.class);
    }

    public User getUserById(long id){
        return repository.findById(id).orElse(null);
    }


    public  User findUserByUserName(String userName){
        return  repository.findByUsername(userName);
    }

    public String deleteUser(Long id){
        repository.deleteById(id);
        log.info("Delete user {}", id);
        return "User removed !!";
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);

        if(existingUser !=null) {
            User getManageruserid = this.getUserById(user.getManageruserid().getId());
            User getCreatedBy = this.getUserById(user.getCreatedby().getId());
            existingUser.setEnabled(user.isEnabled());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            existingUser.setTitle(user.getTitle());
            existingUser.setJobtitle(user.getJobtitle());
            existingUser.setManageruserid(getManageruserid);
            existingUser.setCreatedby(getCreatedBy);
            log.info("Modifier user {}",existingUser.getUsername());
        }
        return repository.save(existingUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =this.findUserByUserName(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //add user roles
        if(user.getRoles().size()>0)
        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        } );
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    public JsonResponse<UserDto> changePassword(ChangePasswordDto user){
        User foundUser =this.findUserByUserName(user.getUsername());
        if(foundUser != null){
            if(passwordEncoder.matches(user.getOldPassword(), foundUser.getPassword())){
                foundUser.setPassword(passwordEncoder.encode(user.getNewPassword()));
                foundUser= repository.save(foundUser);
                UserDto userResponse = userMapping.convertToDto(foundUser, UserDto.class);
                return new JsonResponse<> ("password changed successfully",userResponse);
            }
        }
        return new JsonResponse<> ("username or password incorrect");
    }
}