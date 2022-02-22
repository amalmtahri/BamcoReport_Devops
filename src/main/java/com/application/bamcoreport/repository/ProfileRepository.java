package com.application.bamcoreport.repository;


import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository  extends JpaRepository<Profile,Long> {

}
