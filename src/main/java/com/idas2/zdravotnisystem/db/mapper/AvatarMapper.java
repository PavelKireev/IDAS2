package com.idas2.zdravotnisystem.db.mapper;

import com.idas2.zdravotnisystem.db.entity.Obrazek;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AvatarMapper implements RowMapper<Obrazek> {

    @Override
    public Obrazek mapRow(ResultSet rs, int rowNum) throws SQLException {
        Obrazek obrazek = new Obrazek();
        obrazek.setId(rs.getInt("ID_OBRAZEK"));

        obrazek
            .setData(rs.getBytes("DATA"))
            .setNazev(rs.getString("NAZEV"))
            .setPripona(rs.getString("PRIPONA"))
            .setDatum(rs.getDate("DATUM").toLocalDate());

        return obrazek;
    }

}
