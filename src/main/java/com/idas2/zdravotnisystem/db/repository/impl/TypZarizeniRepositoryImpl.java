package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.TypZarizeni;
import com.idas2.zdravotnisystem.db.mapper.entity.TypZarizeniMapper;
import com.idas2.zdravotnisystem.db.repository.TypZarizeniRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypZarizeniRepositoryImpl
    extends AbstractCrudRepository
    implements TypZarizeniRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(TypZarizeniRepositoryImpl.class);

    private final TypZarizeniMapper typZarizeniMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public TypZarizeniRepositoryImpl(
        TypZarizeniMapper typZarizeniMapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.typZarizeniMapper = typZarizeniMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TypZarizeni> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM TYP_ZARIZENI",
                        mapParams(map),
                        typZarizeniMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }
}
