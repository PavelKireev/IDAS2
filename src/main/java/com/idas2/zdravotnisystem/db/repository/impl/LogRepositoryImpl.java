package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Log;
import com.idas2.zdravotnisystem.db.mapper.entity.LogMapper;
import com.idas2.zdravotnisystem.db.mapper.view.LogTabulkyViewMapper;
import com.idas2.zdravotnisystem.db.mapper.view.LogUzivatelViewMapper;
import com.idas2.zdravotnisystem.db.repository.LogRepository;
import com.idas2.zdravotnisystem.db.view.LogTabulkyView;
import com.idas2.zdravotnisystem.db.view.LogUzivatelView;
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
    extends AbstractCrudRepository
    implements LogRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogRepositoryImpl.class);

    private final LogMapper logMapper;
    private final LogTabulkyViewMapper logTabulkyViewMapper;
    private final LogUzivatelViewMapper logUzivatelViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public LogRepositoryImpl(
        LogMapper logMapper,
        LogTabulkyViewMapper logTabulkyViewMapper,
        LogUzivatelViewMapper logUzivatelViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.logMapper = logMapper;
        this.logTabulkyViewMapper = logTabulkyViewMapper;
        this.logUzivatelViewMapper = logUzivatelViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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

    @Override
    public List<LogTabulkyView> findAllTableLog() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM LOG_TABULKY_V",
                        mapParams(map),
                        logTabulkyViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public List<LogUzivatelView> findAllUserLog() {
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM LOG_UZIVATEL_V",
                        mapParams(map),
                        logUzivatelViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }
}
