package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TypProceduryMapper implements RowMapper<TypProcedury> {

    @Override
    public TypProcedury mapRow(ResultSet rs, int rowNum) throws SQLException {
        TypProcedury typProcedury = new TypProcedury();

        typProcedury
            .setNazev(rs.getString("NAZEV"))
            .setPopis(rs.getString("POPIS"))
            .setId(rs.getInt("ID_TYPPROCEDURY"));

        return typProcedury;
    }
}
