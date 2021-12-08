package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.mapper.entity.UserMapper;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UzivatelRepositoryImpl
    extends AbstractCrudRepository<User, UserMapper>
    implements UzivatelRepository {

    private final UserMapper mapper;

    @Autowired
    public UzivatelRepositoryImpl(
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
    public @Nullable User update(
        @NotNull User entity
    ) {
        return null;
    }

    @Override
    public void update(
        @NotNull String userUuid,
        @NotNull UserUpdateForm form
    ) {
//        update(
//            "UPDATE UZIVATEL " +
//                "SET JMENO = :jmeno" +
//                "PRIJMENI = :prijmeni" +
//                "TEL_CISLO = :telCislo"
//        );
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
            "SELECT * FROM UZIVATEL WHERE EMAIL = :EMAIL",
            mapParams("EMAIL", email),
            mapper
        );
    }
}
