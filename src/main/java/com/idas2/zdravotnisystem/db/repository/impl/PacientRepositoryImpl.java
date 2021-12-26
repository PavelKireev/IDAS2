package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Pacient;
import com.idas2.zdravotnisystem.db.mapper.entity.PacientMapper;
import com.idas2.zdravotnisystem.db.mapper.view.PacientViewMapper;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PacientRepositoryImpl
    extends AbstractCrudRepository<Pacient, PacientMapper>
    implements PacientRepository {

    private final PacientViewMapper pacientViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PacientRepositoryImpl(
        PacientViewMapper pacientViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
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
    public void updateInfoByView(
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
                .addValue("DATA", pacientView.getObrazekData())
                .addValue("RUST", pacientView.getRust())
                .addValue("HMOTNOST", pacientView.getHmotnost())
                .addValue("DATUM_NAROZENI", pacientView.getDatumNarozeni())
                .addValue("ID_OTEC", pacientView.getPacientUzivatelIdOtec())
                .addValue("ID_MATKA", pacientView.getPacientUzivatelIdMatka());


//            parameters.addValue(
//                "DATA", pacientView.getBytes()
////                new SqlLobValue(
////                    new ByteArrayInputStream(obrazek.getBytes()),
////                    obrazek.getBytes().length,
////                    new DefaultLobHandler()
////                ), OracleTypes.BLOB
//            );


            namedParameterJdbcTemplate.update(
                "CALL PACIENT_PRC (" +
                    ":USER_ID, :EMAIL, :HESLO, :JMENO, :PRIJMENI, :TEL_CISLO, " +
                    ":ADRESA, :DATA,:NAZEV,:PRIPONA, :RUST, :HMOTNOST, " +
                    ":DATUM_NAROZENI, :ID_OTEC, :ID_MATKA)",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private SqlParameterSource mapViewParams(
        String key, Object value
    ) {
        return mapViewParams(
            new HashMap<String, Object>() {{
                put(key, value);
            }}
        );
    }

    private SqlParameterSource mapViewParams(
        Map<String, Object> params
    ) {
        return new MapSqlParameterSource(params);
    }

}
