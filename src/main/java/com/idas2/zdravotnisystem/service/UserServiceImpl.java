package com.idas2.zdravotnisystem.service;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UzivatelRepository repository;

    @Autowired
    public UserServiceImpl(UzivatelRepository repository) {
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
