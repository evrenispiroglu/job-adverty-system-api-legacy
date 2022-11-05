package com.lcwaikiki.advertservice.repository;

import com.lcwaikiki.advertservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findUserByEmail(String email);
}
