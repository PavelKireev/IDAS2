package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.mapper.view.KancelarViewMapper;
import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class KancelarRepositoryImpl
    extends AbstractCrudRepository
    implements KancelarRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(KancelarRepositoryImpl.class);

    private final KancelarViewMapper kancelarViewMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public KancelarRepositoryImpl(
        KancelarViewMapper kancelarViewMapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.kancelarViewMapper = kancelarViewMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KancelarView> findAllView() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM KANCELAR_V",
                        mapParams(map),
                        kancelarViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public void saveFromView(@NotNull KancelarView view) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", view.getId())
                .addValue("NAZEV", view.getNazev())
                .addValue("CISLO", view.getCislo())
                .addValue("PLOCHA", view.getPlocha())
                .addValue("JEOBSAZENA", view.getJeObsazena());

            jdbcTemplate.update(
                "CALL KANCELAR_PRC (" +
                    ":ID, :NAZEV, :CISLO, :PLOCHA, :JEOBSAZENA )",
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
                    "DELETE FROM KANCELAR WHERE MISTNOST_ID_MISTNOST = :ID",
                    mapParams("ID", id)
                );

            jdbcTemplate
                .update(
                    "DELETE FROM MISTNOST WHERE ID_MISTNOST = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete lekar ex");
        }
    }

    @Override
    public KancelarView findById(@NotNull Integer id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("ID", id);
        try {
            return
                jdbcTemplate
                    .queryForObject(
                        "SELECT * FROM KANCELAR_V WHERE ID = :ID",
                        parameters,
                        kancelarViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
