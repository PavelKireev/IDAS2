package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import com.idas2.zdravotnisystem.db.mapper.entity.ZdravotniKartaMapper;
import com.idas2.zdravotnisystem.db.repository.ZdravotniKartaRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ZdravotniKartaRepositoryImpl
    extends AbstractCrudRepository
    implements ZdravotniKartaRepository {

    private final ZdravotniKartaMapper zdravotniKartaMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ZdravotniKartaRepositoryImpl(
        ZdravotniKartaMapper zdravotniKartaMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.zdravotniKartaMapper = zdravotniKartaMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public ZdravortniKarta findByPacientId(
        @NotNull Integer pacientId
    ) {
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM ZDRAVOTNI_KARTA WHERE PACIENT_UZIVATEL_ID_UZIVATEL = :ID",
                        mapViewParams("ID", pacientId),
                        zdravotniKartaMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateByEntity(
        @NotNull ZdravortniKarta zdravortniKarta
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", zdravortniKarta.getId())
                .addValue("OD", Date.valueOf(zdravortniKarta.getKartaOd()))
                .addValue("DO", Date.valueOf(zdravortniKarta.getKartaDo()))
                .addValue("PACIENT_UZIVATEL_ID_UZIVATEL",
                    zdravortniKarta.getPacientUzivatelIdUzivatel()
                );

            namedParameterJdbcTemplate.update(
                "CALL ZDRAVOTNI_KARTA_PRC (" +
                    ":ID, :OD, :DO, :PACIENT_UZIVATEL_ID_UZIVATEL )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
