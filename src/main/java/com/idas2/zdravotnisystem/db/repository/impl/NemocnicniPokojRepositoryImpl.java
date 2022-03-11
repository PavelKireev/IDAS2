package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.mapper.view.NemocnicniPokojViewMapper;
import com.idas2.zdravotnisystem.db.repository.NemocnicniPokojRepository;
import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;
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
public class NemocnicniPokojRepositoryImpl
    extends AbstractCrudRepository
    implements NemocnicniPokojRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(NemocnicniPokojRepositoryImpl.class);

    private final NemocnicniPokojViewMapper nemocnicniPokojViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public NemocnicniPokojRepositoryImpl(
        NemocnicniPokojViewMapper nemocnicniPokojViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.nemocnicniPokojViewMapper = nemocnicniPokojViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<NemocnicniPokojView> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM NEMOCNICNI_POKOJ_V",
                        mapParams(map),
                        nemocnicniPokojViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public void saveFromView(@NotNull NemocnicniPokojView view) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", view.getId())
                .addValue("NAZEV", view.getNazev())
                .addValue("CISLO", view.getCislo())
                .addValue("PLOCHA", view.getPlocha())
                .addValue("KAPACITA", view.getKapacita())
                .addValue("POCET_PACIENTU", view.getPocetPacientu());

            namedParameterJdbcTemplate.update(
                "CALL NEMOCNICNI_POKOJ_PRC (" +
                    ":ID, :NAZEV, :CISLO, :PLOCHA, :KAPACITA, :POCET_PACIENTU )",
                parameters
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(@NotNull Integer id) {
        try {
            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM NEMOCNICNI_POKOJ WHERE MISTNOST_ID_MISTNOST = :ID",
                    mapParams("ID", id)
                );

            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM MISTNOST WHERE ID_MISTNOST = :ID",
                    mapParams("ID", id)
                );
        } catch (RuntimeException ex) {
            LOGGER.warn("Delete pokoj ex");
        }
    }

    @Override
    public NemocnicniPokojView findById(@NotNull Integer id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("ID", id);
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM NEMOCNICNI_POKOJ_V WHERE ID = :ID",
                        parameters,
                        nemocnicniPokojViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn(ex.getMessage());
            return null;
        }
    }

    @Override
    public NemocnicniPokojView findByCislo(
        @NotNull Integer cislo
    ) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("CISLO", cislo);
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM NEMOCNICNI_POKOJ_V WHERE CISLO = :CISLO",
                        parameters,
                        nemocnicniPokojViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn(ex.getMessage());
            return null;
        }
    }
}
