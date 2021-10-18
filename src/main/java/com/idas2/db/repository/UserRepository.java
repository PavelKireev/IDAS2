package com.idas2.db.repository;

import com.idas2.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<String, User> {
    User findByEmail(String email);
}
