package com.idas2.zdravotnisystem.db.repository.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCrudRepository {

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
