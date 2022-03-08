package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.db.mapper.entity.SpecializaceMapper;
import com.idas2.zdravotnisystem.db.repository.SpecializaceRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SpecializaceRepositoryImpl
    extends AbstractCrudRepository
    implements SpecializaceRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(SpecializaceRepositoryImpl.class);


    private final SpecializaceMapper mapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public SpecializaceRepositoryImpl(
        SpecializaceMapper mapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.mapper = mapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public @NotNull Specializace getOne(
        @NotNull Integer id
    ) {
        try {
            return
                jdbcTemplate
                    .queryForObject(
                        "SELECT * FROM SPECIALIZACE WHERE ID_SPEC = :ID",
                        mapViewParams("ID", id),
                        mapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Specializace> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM SPECIALIZACE",
                        mapParams(map),
                        mapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public void save(@NotNull Specializace entity) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", entity.getId())
                .addValue("NAZEV", entity.getNazev())
                .addValue("POPIS", entity.getPopis());

            jdbcTemplate.update(
                "CALL SPECIALIZACE_PRC (" +
                    ":ID, :NAZEV, :POPIS )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(@NotNull Integer id) {
        try {
            jdbcTemplate
                .update(
                    "DELETE FROM SPECIALIZACE WHERE ID_SPEC = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete specializace ex");
        }
    }
}
