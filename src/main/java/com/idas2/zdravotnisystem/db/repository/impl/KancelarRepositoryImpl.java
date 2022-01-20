package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.mapper.view.KancelarViewMapper;
import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
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
public class KancelarRepositoryImpl
    extends AbstractCrudRepository
    implements KancelarRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(KancelarRepositoryImpl.class);

    private final KancelarViewMapper kancelarViewMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public KancelarRepositoryImpl(
        KancelarViewMapper kancelarViewMapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.kancelarViewMapper = kancelarViewMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KancelarView> findAllView() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM KANCELAR_V",
                        mapParams(map),
                        kancelarViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }
}
