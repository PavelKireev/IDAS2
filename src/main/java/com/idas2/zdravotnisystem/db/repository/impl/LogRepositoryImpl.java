package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Log;
import com.idas2.zdravotnisystem.db.mapper.entity.LogMapper;
import com.idas2.zdravotnisystem.db.repository.LogRepository;
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
public class LogRepositoryImpl
    extends AbstractCrudRepository<Log, LogMapper>
    implements LogRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogRepositoryImpl.class);


    private final LogMapper logMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public LogRepositoryImpl(
        LogMapper logMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
        this.logMapper = logMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public @Nullable Log getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull Log entity) {
        return null;
    }

    @Override
    public @Nullable Log update(@NotNull Log entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull Log entity) {

    }

    @Override
    public List<Log> findAll() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM LOG",
                        mapParams(map),
                        logMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }
}
