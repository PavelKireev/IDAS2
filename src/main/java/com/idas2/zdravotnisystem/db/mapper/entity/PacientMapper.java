package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Pacient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientMapper implements RowMapper<Pacient> {
    @Override
    public Pacient mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
