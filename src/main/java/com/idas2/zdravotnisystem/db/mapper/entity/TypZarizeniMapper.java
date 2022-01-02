package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.TypZarizeni;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TypZarizeniMapper implements RowMapper<TypZarizeni> {

    @Override
    public TypZarizeni mapRow(ResultSet rs, int rowNum) throws SQLException {

        TypZarizeni typZarizeni = new TypZarizeni();

        typZarizeni
            .setNazev(rs.getString("NAZEV"))
            .setCilenePouziti(rs.getString("CILENEPOUZITI"))
            .setPopis(rs.getString("POPIS"))
            .setId(rs.getInt("ID_TYPZARIZENI"));


        return typZarizeni;
    }
}
