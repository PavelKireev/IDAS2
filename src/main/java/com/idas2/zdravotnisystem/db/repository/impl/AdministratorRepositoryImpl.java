package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.mapper.view.AdministratorViewMapper;
import com.idas2.zdravotnisystem.db.repository.AdministratorRepository;
import com.idas2.zdravotnisystem.db.view.AdministratorView;
import jdk.nashorn.internal.runtime.logging.Loggable;
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
public class AdministratorRepositoryImpl
    extends AbstractCrudRepository
    implements AdministratorRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(AdministratorRepositoryImpl.class);

    private final AdministratorViewMapper administratorViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AdministratorRepositoryImpl(
        AdministratorViewMapper administratorViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.administratorViewMapper = administratorViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public AdministratorView findById(Integer id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("ID", id);
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM ADMINISTRATOR_V WHERE ID = :ID",
                        parameters,
                        administratorViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<AdministratorView> findAllView() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM ADMINISTRATOR_V",
                        mapParams(map),
                        administratorViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public void saveFromView(@NotNull AdministratorView view) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", view.getId())
                .addValue("JMENO", view.getJmeno())
                .addValue("PRIJMENI", view.getPrijmeni())
                .addValue("EMAIL", view.getEmail())
                .addValue("HESLO", view.getHeslo())
                .addValue("TELCISLO", view.getTelCislo())
                .addValue("NAZEV", view.getObrazekNazev())
                .addValue("PRIPONA", view.getObrazekPripona());

            if (Objects.isNull(view.getObrazekData())) {
                parameters.addValue("OBRAZEK", new byte[0]);
            } else {
                parameters.addValue("OBRAZEK", view.getObrazekData());
            }

            namedParameterJdbcTemplate.update(
                "CALL ADMINISTRATOR_PRC (" +
                    ":ID, :EMAIL, :HESLO, :JMENO, :PRIJMENI, :TELCISLO, :OBRAZEK, :NAZEV, :PRIPONA )",
                parameters
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
