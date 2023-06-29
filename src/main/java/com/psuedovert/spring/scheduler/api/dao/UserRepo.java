package com.psuedovert.spring.scheduler.api.dao;

import com.psuedovert.spring.scheduler.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
