package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Zarizeni;
import com.idas2.zdravotnisystem.db.mapper.entity.ZarizeniMapper;
import com.idas2.zdravotnisystem.db.repository.ZarizeniRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ZarizeniRepositoryImpl
    extends AbstractCrudRepository
    implements ZarizeniRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZarizeniRepositoryImpl.class);

    private final ZarizeniMapper zarizeniMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ZarizeniRepositoryImpl(
        ZarizeniMapper zarizeniMapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.zarizeniMapper = zarizeniMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Zarizeni> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM ZARIZENI",
                        mapParams(map),
                        zarizeniMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }    }
}
