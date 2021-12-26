package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Procedura;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProceduraMapper implements RowMapper<Procedura> {
    @Override
    public Procedura mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
