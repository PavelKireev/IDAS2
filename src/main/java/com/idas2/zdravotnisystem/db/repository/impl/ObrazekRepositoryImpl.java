package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Obrazek;
import com.idas2.zdravotnisystem.db.mapper.AvatarMapper;
import com.idas2.zdravotnisystem.db.repository.ObrazekRepository;
import oracle.jdbc.internal.OracleTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class ObrazekRepositoryImpl
    extends AbstractCrudRepository<Obrazek, AvatarMapper>
    implements ObrazekRepository {

    private final AvatarMapper avatarMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ObrazekRepositoryImpl(
        AvatarMapper avatarMapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        super(jdbcTemplate);
        this.avatarMapper = avatarMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @NotNull
    @Override
    public Integer create(
        @NotNull Obrazek obrazek
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue(
                "DATA",
                new SqlLobValue(
                    new ByteArrayInputStream(obrazek.getData()),
                    obrazek.getData().length,
                    new DefaultLobHandler()
                ), OracleTypes.BLOB);
            parameters.addValue("NAZEV", obrazek.getNazev());
            parameters.addValue("PRIPONA", obrazek.getPripona());
            parameters.addValue("DATUM", obrazek.getDatum(), OracleTypes.DATE);

            return jdbcTemplate.update(
                "INSERT INTO OBRAZEK(DATA, NAZEV, PRIPONA, DATUM)" +
                    " VALUES (:DATA,:NAZEV, :PRIPONA, :DATUM)",
                parameters
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public @Nullable Obrazek getOne(Integer id) {
        return getOne(
            "SELECT * FROM UZIVATEL WHERE EMAIL = :EMAIL",
            mapParams("ID_OBRAZEK", id),
            avatarMapper
        );
    }

    @Override
    public @Nullable Obrazek update(@NotNull Obrazek entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull Obrazek entity) {

    }
}
