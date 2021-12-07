package com.idas2.zdravotnisystem.service;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface UserService {

    User updateUser(
        @NotNull String uuid,
        @NotNull UserUpdateForm form
    );

}
