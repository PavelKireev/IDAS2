package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Zarizeni;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ZarizeniMapper implements RowMapper<Zarizeni> {

    @Override
    public Zarizeni mapRow(ResultSet rs, int rowNum) throws SQLException {

        Zarizeni zarizeni = new Zarizeni();

        zarizeni
            .setNazev(rs.getString("NAZEV"))
            .setZnacka(rs.getString("ZNACKA"))
            .setDatumVyroby(rs.getDate("DATUMVYROBY").toLocalDate())
            .setJeFunkcni(rs.getBoolean("JEFUNKCNI"))
            .setId(rs.getInt("ID_ZARIZENI"));

        return zarizeni;
    }
}
