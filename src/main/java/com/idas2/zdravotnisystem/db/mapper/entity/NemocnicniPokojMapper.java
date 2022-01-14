package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.NemocnicniPokoj;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NemocnicniPokojMapper implements RowMapper<NemocnicniPokoj> {

    @Override
    public NemocnicniPokoj mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
