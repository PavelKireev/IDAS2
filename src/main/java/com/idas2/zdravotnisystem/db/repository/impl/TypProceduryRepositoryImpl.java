package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.db.mapper.entity.TypProceduryMapper;
import com.idas2.zdravotnisystem.db.repository.TypProceduryRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
public class TypProceduryRepositoryImpl
    extends AbstractCrudRepository
    implements TypProceduryRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypProceduryRepositoryImpl.class);

    private final TypProceduryMapper typProceduryMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TypProceduryRepositoryImpl(
        TypProceduryMapper typProceduryMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.typProceduryMapper = typProceduryMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<TypProcedury> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM TYP_PROCEDURY",
                        mapParams(map),
                        typProceduryMapper
                        );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public @Nullable TypProcedury getOne(Integer id) {
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM TYP_PROCEDURY WHERE ID_TYPPROCEDURY = :ID",
                        mapViewParams("ID", id),
                        typProceduryMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void save(@NotNull TypProcedury typProcedury) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", typProcedury.getId())
                .addValue("NAZEV", typProcedury.getNazev())
                .addValue("POPIS", typProcedury.getPopis());

            namedParameterJdbcTemplate.update(
                "CALL TYP_PROCEDURY_PRC (" +
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
            namedParameterJdbcTemplate.update(
                "DELETE FROM TYP_PROCEDURY WHERE ID_TYPPROCEDURY = :ID",
                mapParams("ID", id)
            );
        } catch (EmptyResultDataAccessException ex) {
            LOGGER.error(ex.getMessage());
        }
    }

}
