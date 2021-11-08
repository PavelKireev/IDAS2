package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.mapper.UserMapper;
import com.idas2.zdravotnisystem.db.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class UserRepositoryImpl
    extends AbstractCrudRepository<User, UserMapper>
    implements UserRepository {

    private final UserMapper mapper;

    @Autowired
    public UserRepositoryImpl(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        UserMapper mapper
    ) {
        super(namedParameterJdbcTemplate);
        this.mapper = mapper;
    }

    @Override
    public @Nullable User getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull User entity) {
        return null;
    }

    @Override
    public @Nullable User update(@NotNull User entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull User entity) {

    }

    @Override
    public User findByEmail(String email) {
        return getOne(
            "SELECT * FROM UZIVATEL WHERE email = :email",
            mapParams("email", email),
            mapper
        );
    }
}
