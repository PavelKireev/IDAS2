package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Specializace;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SpecializaceMapper implements RowMapper<Specializace> {

    @Override
    public Specializace mapRow(ResultSet rs, int rowNum) throws SQLException {
        Specializace specializace = new Specializace();

        specializace
            .setNazev(rs.getString("NAZEV"))
            .setPopis(rs.getString("POPIS"))
            .setId(rs.getInt("ID_SPEC"));

        return specializace;
    }
}
