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
import org.springframework.stereotype.Component;
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
