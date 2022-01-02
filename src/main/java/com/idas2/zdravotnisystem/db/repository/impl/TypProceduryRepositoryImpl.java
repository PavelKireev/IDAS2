package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.db.mapper.entity.TypProceduryMapper;
import com.idas2.zdravotnisystem.db.repository.TypProceduryRepository;
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
public class TypProceduryRepositoryImpl
    extends AbstractCrudRepository<TypProcedury, TypProceduryMapper>
    implements TypProceduryRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypProceduryRepositoryImpl.class);

    private final TypProceduryMapper typProceduryMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TypProceduryRepositoryImpl(
        TypProceduryMapper typProceduryMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
        this.typProceduryMapper = typProceduryMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<TypProcedury> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM TYP_PROCEDURY",
                        mapParams(map),
                        typProceduryMapper
                        );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }
}
