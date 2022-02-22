package com.application.bamcoreport.repository;

import com.application.bamcoreport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String useName);

}
