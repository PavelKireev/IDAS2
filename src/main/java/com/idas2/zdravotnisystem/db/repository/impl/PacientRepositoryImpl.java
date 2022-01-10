package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Pacient;
import com.idas2.zdravotnisystem.db.mapper.entity.PacientMapper;
import com.idas2.zdravotnisystem.db.mapper.view.PacientViewMapper;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacientRepositoryImpl
    extends AbstractCrudRepository<Pacient, PacientMapper>
    implements PacientRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PacientRepositoryImpl.class);

    private final PacientMapper pacientMapper;
    private final PacientViewMapper pacientViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PacientRepositoryImpl(
        PacientMapper pacientMapper,
        PacientViewMapper pacientViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
        this.pacientMapper = pacientMapper;
        this.pacientViewMapper = pacientViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public PacientView getPacientViewByUzivatelId(
        @NotNull Integer uzivatelId
    ) {
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM PACIENT_V WHERE ID = :ID",
                        mapViewParams("ID", uzivatelId),
                        pacientViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateByView(
        @NotNull PacientView pacientView
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();


            parameters
                .addValue("USER_ID", pacientView.getId())
                .addValue("EMAIL", pacientView.getEmail())
                .addValue("HESLO", pacientView.getPassword())
                .addValue("JMENO", pacientView.getJmeno())
                .addValue("PRIJMENI", pacientView.getPrijmeni())
                .addValue("TEL_CISLO", pacientView.getTelCislo())
                .addValue("ADRESA", pacientView.getAdresa())
                .addValue("NAZEV", pacientView.getObrazekNazev())
                .addValue("PRIPONA", pacientView.getObrazekPripona())
                .addValue("RUST", pacientView.getRust())
                .addValue("HMOTNOST", pacientView.getHmotnost())
                .addValue("DATUM_NAROZENI", pacientView.getDatumNarozeni())
                .addValue("ID_OTEC", pacientView.getPacientUzivatelIdOtec())
                .addValue("ID_MATKA", pacientView.getPacientUzivatelIdMatka());


            if (Objects.isNull(pacientView.getObrazekData())) {
                parameters.addValue(
                    "DATA", new byte[0]
                );
            } else {
                parameters.addValue("DATA", pacientView.getObrazekData());
            }


            namedParameterJdbcTemplate.update(
                "CALL PACIENT_PRC (" +
                    ":USER_ID, :EMAIL, :HESLO, :JMENO, :PRIJMENI, :TEL_CISLO, " +
                    ":ADRESA, :DATA, :NAZEV, :PRIPONA, :RUST, :HMOTNOST, " +
                    ":DATUM_NAROZENI, :ID_OTEC, :ID_MATKA )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Pacient> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM PACIENT",
                        mapParams(map),
                        pacientMapper
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
                    "DELETE FROM PACIENT WHERE UZIVATEL_ID_UZIVATEL = :ID",
                    mapParams("ID", id)
                );

            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM UZIVATEL WHERE ID_UZIVATEL = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete pacient ex");
        }
    }

}
