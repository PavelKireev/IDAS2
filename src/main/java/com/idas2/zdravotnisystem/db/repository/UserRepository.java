package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.User;

public interface UserRepository extends CrudRepository<User> {

    User findByEmail(String email);
}
