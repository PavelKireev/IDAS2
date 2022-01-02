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
            .setHeslo(rs.getString("HESLO"))
            .setEmail(rs.getString("EMAIL"))
            .setJmeno(rs.getString("JMENO"))
            .setPrijmeni(rs.getString("PRIJMENI"))
            .setTelCislo(rs.getString("TELCISLO"))
            .setObrazek(rs.getBytes("OBRAZEK_DATA"))
            .setObrazekPripona(rs.getString("OBRAZEK_PRIPONA"))
            .setObrazekNazev(rs.getString("OBRAZEK_NAZEV"))
            .setPlat(rs.getInt("PLAT"))
            .setKancelarCislo(rs.getString("KANCELAR_CISLO"))
            .setKancelarNazev(rs.getString("KANCELAR_NAZEV"))
            .setIdKancelar(rs.getInt("KANCELAR_ID_KANCELAR"))
            .setIdSpecializace(rs.getInt("SPECIALIZACE_ID_SPEC"));

        return lekarView;
    }
}
