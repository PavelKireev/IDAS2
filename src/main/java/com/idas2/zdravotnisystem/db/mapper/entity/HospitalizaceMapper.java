package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalizaceMapper implements RowMapper<Hospitalizace> {

    @Override
    public Hospitalizace mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
