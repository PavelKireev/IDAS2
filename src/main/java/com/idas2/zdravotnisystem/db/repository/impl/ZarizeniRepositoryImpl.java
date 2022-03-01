package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Zarizeni;
import com.idas2.zdravotnisystem.db.mapper.entity.ZarizeniMapper;
import com.idas2.zdravotnisystem.db.mapper.view.ZarizeniViewMapper;
import com.idas2.zdravotnisystem.db.repository.ZarizeniRepository;
import com.idas2.zdravotnisystem.db.view.ZarizeniView;
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
public class ZarizeniRepositoryImpl
    extends AbstractCrudRepository
    implements ZarizeniRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZarizeniRepositoryImpl.class);

    private final ZarizeniViewMapper zarizeniViewMapper;
    private final ZarizeniMapper zarizeniMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ZarizeniRepositoryImpl(
        ZarizeniMapper zarizeniMapper,
        ZarizeniViewMapper zarizeniViewMapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
        this.zarizeniMapper = zarizeniMapper;
        this.zarizeniViewMapper = zarizeniViewMapper;
    }

    @Override
    public List<Zarizeni> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM ZARIZENI",
                        mapParams(map),
                        zarizeniMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public List<ZarizeniView> findAllView() {

        Map<String, Object> map = new HashMap<>();

        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM ZARIZENI_V",
                        mapParams(map),
                        zarizeniViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public @NotNull ZarizeniView getOne(@NotNull Integer id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("ID", id);

        try {
            return
                jdbcTemplate
                    .queryForObject(
                        "SELECT * FROM ZARIZENI_V WHERE ID = :ID",
                        parameters,
                        zarizeniViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void save(@NotNull Zarizeni view) {

    }

    @Override
    public void saveFromView(@NotNull ZarizeniView view) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", view.getId())
                .addValue("NAZEV", view.getNazev())
                .addValue("ZNACKA", view.getZnacka())
                .addValue("DATUMVYROBY", view.getDatumVyroby())
                .addValue("JEFUNKCNI", view.getJeFunkcni())
                .addValue("ID_MISTNOST",view.getIdMistnost())
                .addValue("ID_ZATIZENI", view.getIdTypZarizeni());

            jdbcTemplate.update(
                "CALL ZARIZENI_PRC (" +
                    ":ID, :NAZEV, :ZNACKA, :DATUMVYROBY, :JEFUNKCNI, " +
                    ":ID_MISTNOST, :ID_ZATIZENI )",
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
                    "DELETE FROM ZARIZENI WHERE ID_ZARIZENI = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete zarizeni ex");
        }
    }
}
