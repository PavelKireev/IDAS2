package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.base.BaseEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCrudRepository<T extends BaseEntity, M extends RowMapper<T>> {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AbstractCrudRepository(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Nullable
    protected T getOne(
        @NotNull String query,
        @NotNull SqlParameterSource params,
        @NotNull M mapper
    ) {
        try {
            return namedParameterJdbcTemplate.queryForObject(query, params, mapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    protected List<T> findAll(
        @NotNull String query,
        @NotNull SqlParameterSource params,
        @NotNull M mapper
    ) {
        return namedParameterJdbcTemplate.query(query, params, mapper);
    }

    protected Integer create(
        @NotNull String query,
        @NotNull SqlParameterSource params,
        @NotNull T entity
    ) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(query, params, keyHolder, new String[]{"id"});

        return (Integer) keyHolder.getKey();
    }

    protected void update(
        @NotNull String query,
        @NotNull SqlParameterSource params
    ) {
        namedParameterJdbcTemplate.update(query, params);
    }

    protected void delete(
        @NotNull String query,
        @NotNull SqlParameterSource params
    ) {
        namedParameterJdbcTemplate.update(query, params);
    }

    protected SqlParameterSource mapParams(
        String key, Object value
    ) {
        return mapParams(
            new HashMap<String, Object>() {{
                put(key, value);
            }}
        );
    }

    protected SqlParameterSource mapParams(
        Map<String, Object> params
    ) {
        return new MapSqlParameterSource(params);
    }

    protected SqlParameterSource mapViewParams(
        String key, Object value
    ) {
        return mapViewParams(
            new HashMap<String, Object>() {{
                put(key, value);
            }}
        );
    }

    protected SqlParameterSource mapViewParams(
        Map<String, Object> params
    ) {
        return new MapSqlParameterSource(params);
    }

}
