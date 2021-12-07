package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface UzivatelRepository extends CrudRepository<User> {

    void update(
        @NotNull String userUuid,
        @NotNull UserUpdateForm form
    );

    User findByEmail(String email);
}
