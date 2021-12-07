package com.idas2.zdravotnisystem.service;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.UserRepository;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User updateUser(
        @NotNull String uuid,
        @NotNull UserUpdateForm form
    ) {
        return null;
    }
}
