package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.LekarView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LekarViewMapper implements RowMapper<LekarView> {

    @Override
    public LekarView mapRow(ResultSet rs, int rowNum) throws SQLException {
        LekarView lekarView = new LekarView();

        lekarView
            .setId(rs.getInt("ID"))
            .setUuid(rs.getString("UUID"))
            .setEmail(rs.getString("EMAIL"))
            .setJmeno(rs.getString("JMENO"))
            .setPrijmeni(rs.getString("PRIJMENI"))
            .setTelCislo(rs.getString("TELCISLO"))
            .setObrazek(rs.getBytes("OBRAZEK_DATA"))
            .setPlat(rs.getInt("PLAT"))
            .setKancelarCislo(rs.getString("KANCELAR_CISLO"))
            .setKancelarNazev(rs.getString("NAZEV"));

        return lekarView;
    }
}
