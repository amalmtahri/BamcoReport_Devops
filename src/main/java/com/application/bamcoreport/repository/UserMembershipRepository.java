package com.application.bamcoreport.repository;

import com.application.bamcoreport.entity.UserMemberShip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMembershipRepository extends JpaRepository<UserMemberShip, Long> {
}
