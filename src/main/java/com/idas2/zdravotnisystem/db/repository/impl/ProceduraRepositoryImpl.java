package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Procedura;
import com.idas2.zdravotnisystem.db.mapper.entity.ProceduraMapper;
import com.idas2.zdravotnisystem.db.mapper.view.ProceduraViewMapper;
import com.idas2.zdravotnisystem.db.repository.ProceduraRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProceduraRepositoryImpl
    extends AbstractCrudRepository<Procedura, ProceduraMapper>
    implements ProceduraRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProceduraRepositoryImpl.class);
    private final ProceduraViewMapper proceduraViewMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProceduraRepositoryImpl(
        NamedParameterJdbcTemplate jdbcTemplate,
        ProceduraViewMapper proceduraViewMapper
    ) {
        super(jdbcTemplate);
        this.jdbcTemplate = jdbcTemplate;
        this.proceduraViewMapper = proceduraViewMapper;
    }

    @Override
    public List<ProceduraView> getProceduraViewListByUserIdBeforeNow(
        @NotNull Integer userId
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("PACIENT_UZIVATEL_ID_UZIVATEL", userId);
        map.put("CURRENT_TIME", Timestamp.valueOf(LocalDateTime.now()));
        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM PROCEDURA_V WHERE " +
                            "PACIENT_UZIVATEL_ID_UZIVATEL = :PACIENT_UZIVATEL_ID_UZIVATEL " +
                            "AND DATUM < :CURRENT_TIME",
                        mapParams(map),
                        proceduraViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProceduraView> getProceduraViewListByUserIdAfterNow(
        @NotNull Integer userId
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("PACIENT_UZIVATEL_ID_UZIVATEL", userId);
        map.put("CURRENT_TIME", Timestamp.valueOf(LocalDateTime.now()));
        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM PROCEDURA_V WHERE " +
                            "PACIENT_UZIVATEL_ID_UZIVATEL = :PACIENT_UZIVATEL_ID_UZIVATEL " +
                            "AND DATUM > :CURRENT_TIME",
                        mapParams(map),
                        proceduraViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }
}
