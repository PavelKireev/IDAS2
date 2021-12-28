package com.idas2.zdravotnisystem.db.mapper.entity;


import com.idas2.zdravotnisystem.db.entity.Lekar;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LekarMapper implements RowMapper<Lekar> {

    @Override
    public Lekar mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Lekar();
    }
}
