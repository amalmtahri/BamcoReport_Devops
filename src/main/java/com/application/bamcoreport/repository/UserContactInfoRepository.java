package com.application.bamcoreport.repository;

import com.application.bamcoreport.entity.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserContactInfoRepository extends JpaRepository<UserContactInfo,Long> {

}
