package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.mapper.view.NemocnicniPokojViewMapper;
import com.idas2.zdravotnisystem.db.repository.NemocnicniPokojRepository;
import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;
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
public class NemocnicniPokojRepositoryImpl
    extends AbstractCrudRepository
    implements NemocnicniPokojRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(NemocnicniPokojRepositoryImpl.class);

    private final NemocnicniPokojViewMapper nemocnicniPokojViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public NemocnicniPokojRepositoryImpl(
        NemocnicniPokojViewMapper nemocnicniPokojViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.nemocnicniPokojViewMapper = nemocnicniPokojViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<NemocnicniPokojView> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM NEMOCNICNI_POKOJ_V",
                        mapParams(map),
                        nemocnicniPokojViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }
}
