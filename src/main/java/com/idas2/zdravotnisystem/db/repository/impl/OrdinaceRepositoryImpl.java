package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.mapper.view.OrdinaceViewMapper;
import com.idas2.zdravotnisystem.db.repository.OrdinaceRepository;
import com.idas2.zdravotnisystem.db.view.OrdinaceView;
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
public class OrdinaceRepositoryImpl
    extends AbstractCrudRepository
    implements OrdinaceRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(OrdinaceRepositoryImpl.class);

    private final OrdinaceViewMapper mapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public OrdinaceRepositoryImpl(
        OrdinaceViewMapper mapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.mapper = mapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<OrdinaceView> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM ORDINACE_V",
                        mapParams(map),
                        mapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public @NotNull OrdinaceView findById(
        @NotNull Integer id
    ) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("ID", id);

        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM ORDINACE_V WHERE ID = :ID",
                        parameters,
                        mapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public OrdinaceView findByCislo(@NotNull Integer cislo) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("CISLO", cislo);
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM ORDINACE_V WHERE CISLO = :CISLO",
                        parameters,
                        mapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn(ex.getMessage());
            return null;
        }
    }

    @Override
    public void delete(@NotNull Integer id) {
        try {
            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM ORDINACE WHERE MISTNOST_ID_MISTNOST = :ID",
                    mapParams("ID", id)
                );

            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM MISTNOST WHERE ID_MISTNOST = :ID",
                    mapParams("ID", id)
                );

        } catch (RuntimeException ex) {
            LOGGER.warn("Delete ordinace ex");
        }
    }

    @Override
    public void saveFromView(OrdinaceView view) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", view.getId())
                .addValue("NAZEV", view.getNazev())
                .addValue("CISLO", view.getCislo())
                .addValue("PLOCHA", view.getPlocha())
                .addValue("JEVPROVOZU", view.getJeVProvozu());


            namedParameterJdbcTemplate.update(
                "CALL ORDINACE_PRC (" +
                    ":ID, :NAZEV, :CISLO, :PLOCHA, :JEVPROVOZU )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
