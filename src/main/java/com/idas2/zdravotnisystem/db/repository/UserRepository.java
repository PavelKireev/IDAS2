package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends CrudRepository<User> {

    User findByEmail(String email);
}
