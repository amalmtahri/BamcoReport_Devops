package com.application.bamcoreport.repository;

import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import com.application.bamcoreport.entity.ProfileMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProfileMemberRepository  extends JpaRepository<ProfileMember,Long> {
}
