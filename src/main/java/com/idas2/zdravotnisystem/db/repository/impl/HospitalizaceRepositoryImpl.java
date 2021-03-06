package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.mapper.entity.HospitalizaceMapper;
import com.idas2.zdravotnisystem.db.mapper.view.HospitalizaceViewMapper;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
public class HospitalizaceRepositoryImpl
    extends AbstractCrudRepository
    implements HospitalizaceRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(HospitalizaceRepositoryImpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final HospitalizaceViewMapper hospitalizaceViewMapper;

    @Autowired
    public HospitalizaceRepositoryImpl(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        HospitalizaceViewMapper hospitalizaceViewMapper
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.hospitalizaceViewMapper = hospitalizaceViewMapper;
    }

    @Override
    public @Nullable HospitalizaceView findOne(Integer id) {
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM HOSPITALIZACE_V WHERE ID = :ID",
                        mapParams("ID", id),
                        hospitalizaceViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void delete(@NotNull Integer id) {

        try {
            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM HOSPITALIZACE WHERE ID_HOSPITALIZACE = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete pacient ex");
        }
    }

    @Override
    public void saveFromEntity(
        Hospitalizace entity
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", entity.getId())
                .addValue("DUVOD", entity.getDuvod())
                .addValue("STAVPACIENTA", entity.getStavPacienta())
                .addValue("OD", entity.getHospitalizaceOd())
                .addValue("DO", entity.getHospitalizaceDo())
                .addValue("PACIENT_UZIVATEL_ID_UZIVATEL", entity.getPacientUzivatelIdUzivatel())
            ;


            namedParameterJdbcTemplate.update(
                "CALL HOSPITALIZACE_PRC (" +
                    ":ID, :DUVOD, :STAVPACIENTA, :OD, :DO, :PACIENT_UZIVATEL_ID_UZIVATEL )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HospitalizaceView> findAllByPacientId(
        @NotNull Integer pacientId
    ) {
        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM HOSPITALIZACE_V WHERE " +
                            "PACIENT_UZIVATEL_ID_UZIVATEL = :PACIENT_UZIVATEL_ID_UZIVATEL",
                        mapParams("PACIENT_UZIVATEL_ID_UZIVATEL", pacientId),
                        hospitalizaceViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<HospitalizaceView>();
        }
    }

    @Override
    public List<HospitalizaceView> findAllByLekarId(@NotNull Integer lekarId) {
        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM HOSPITALIZACE_V",
                        mapParams("PACIENT_UZIVATEL_ID_UZIVATEL", lekarId),
                        hospitalizaceViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<HospitalizaceView>();
        }
    }

    @Override
    public List<HospitalizaceView> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM HOSPITALIZACE_V",
                        mapParams(map),
                        hospitalizaceViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }


}
