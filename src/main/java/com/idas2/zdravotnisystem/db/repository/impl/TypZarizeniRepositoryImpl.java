package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.TypZarizeni;
import com.idas2.zdravotnisystem.db.mapper.entity.TypZarizeniMapper;
import com.idas2.zdravotnisystem.db.repository.TypZarizeniRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypZarizeniRepositoryImpl
    extends AbstractCrudRepository
    implements TypZarizeniRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(TypZarizeniRepositoryImpl.class);

    private final TypZarizeniMapper typZarizeniMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public TypZarizeniRepositoryImpl(
        TypZarizeniMapper typZarizeniMapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.typZarizeniMapper = typZarizeniMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(@NotNull TypZarizeni entity) {

        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", entity.getId())
                .addValue("NAZEV", entity.getNazev())
                .addValue("CILENE_POUZITI", entity.getCilenePouziti())
                .addValue("POPIS", entity.getPopis());

            jdbcTemplate.update(
                "CALL TYP_ZARIZENI_PRC (" +
                    ":ID, :NAZEV, :CILENE_POUZITI, :POPIS )",
                parameters
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public @NotNull TypZarizeni getOne(@NotNull Integer id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("ID", id);

        try {
            return
                jdbcTemplate
                    .queryForObject(
                        "SELECT * FROM TYP_ZARIZENI WHERE ID_TYPZARIZENI = :ID",
                        parameters,
                        typZarizeniMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @NotNull
    @Override
    public List<TypZarizeni> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM TYP_ZARIZENI",
                        mapParams(map),
                        typZarizeniMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public void delete(@NotNull Integer id) {
        try {
            jdbcTemplate
                .update(
                    "DELETE FROM TYP_ZARIZENI WHERE ID_TYPZARIZENI = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete zarizeni ex");
        }
    }
}
