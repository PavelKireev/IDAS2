package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PojistovnaMapper implements RowMapper<Pojistovna> {

    @Override
    public Pojistovna mapRow(ResultSet rs, int rowNum) throws SQLException {

        Pojistovna pojistovna = new Pojistovna();

        pojistovna
            .setNazev(rs.getString("NAZEV"))
            .setAdresa(rs.getString("ADRESA"))
            .setTelCislo(rs.getString("TELCISLO"))
            .setId(rs.getInt("ID_POJISTOVNA"));

        return pojistovna;
    }
}
