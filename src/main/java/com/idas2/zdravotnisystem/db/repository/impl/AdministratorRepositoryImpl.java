package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.mapper.view.AdministratorViewMapper;
import com.idas2.zdravotnisystem.db.repository.AdministratorRepository;
import com.idas2.zdravotnisystem.db.view.AdministratorView;
import jdk.nashorn.internal.runtime.logging.Loggable;
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
public class AdministratorRepositoryImpl
    extends AbstractCrudRepository
    implements AdministratorRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(AdministratorRepositoryImpl.class);

    private final AdministratorViewMapper administratorViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AdministratorRepositoryImpl(
        AdministratorViewMapper administratorViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.administratorViewMapper = administratorViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<AdministratorView> findAllView() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM ADMINISTRATOR_V",
                        mapParams(map),
                        administratorViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }
}
