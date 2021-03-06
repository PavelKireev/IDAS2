package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Lekar;
import com.idas2.zdravotnisystem.db.mapper.entity.LekarMapper;
import com.idas2.zdravotnisystem.db.mapper.view.LekarViewMapper;
import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.view.LekarView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LekarRepositoryImpl
    extends AbstractCrudRepository
    implements LekarRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LekarRepositoryImpl.class);

    private final LekarViewMapper lekarViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public LekarRepositoryImpl(
        LekarViewMapper lekarViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.lekarViewMapper = lekarViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public @NotNull LekarView getViewById(@NotNull Integer id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("ID", id);
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM LEKAR_V WHERE ID = :ID",
                        parameters,
                        lekarViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateInfoByView(LekarView view) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("USER_ID", view.getId())
                .addValue("EMAIL", view.getEmail())
                .addValue("HESLO", view.getHeslo())
                .addValue("JMENO", view.getJmeno())
                .addValue("PRIJMENI", view.getPrijmeni())
                .addValue("TEL_CISLO", view.getTelCislo())
                .addValue("NAZEV", view.getObrazekNazev())
                .addValue("PRIPONA", view.getObrazekPripona())
                .addValue("PLAT", view.getPlat())
                .addValue("SPECIALIZACE_ID", view.getIdSpecializace())
                .addValue("KANCELAR_ID", view.getIdKancelar());

            if (Objects.isNull(view.getObrazek())) {
                parameters.addValue("DATA", new byte[0]);
            } else {
                parameters.addValue("DATA", view.getObrazek());
            }


            namedParameterJdbcTemplate.update(
                "CALL LEKAR_PRC (" +
                    ":USER_ID, :EMAIL, :HESLO, :JMENO, :PRIJMENI, :TEL_CISLO, " +
                    ":DATA, :NAZEV, :PRIPONA, :PLAT, " +
                    ":KANCELAR_ID, :SPECIALIZACE_ID )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public @NotNull List<LekarView> findAllView() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM LEKAR_V",
                        mapParams(map),
                        lekarViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public void delete(@NotNull Integer id) {

        try {
            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM LEKAR WHERE UZIVATEL_ID_UZIVATEL = :ID",
                    mapParams("ID", id)
                );

            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM UZIVATEL WHERE ID_UZIVATEL = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete lekar ex");
        }
    }
}
