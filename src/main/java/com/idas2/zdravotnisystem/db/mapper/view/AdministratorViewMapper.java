package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.AdministratorView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AdministratorViewMapper implements RowMapper<AdministratorView> {

    @Override
    public AdministratorView mapRow(ResultSet rs, int rowNum) throws SQLException {

        AdministratorView view = new AdministratorView();

        view
            .setTelCislo(rs.getString("TELCISLO"))
            .setJmeno(rs.getString("JMENO"))
            .setUuid(rs.getString("UUID"))
            .setId(rs.getInt("ID"))
            .setEmail(rs.getString("EMAIL"))
            .setHeslo(rs.getString("HESLO"))
            .setPrijmeni(rs.getString("PRIJMENI"))
            .setObrazekIdObrazek(rs.getInt("OBRAZEK_ID_OBRAZEK"))
            .setObrazekData(rs.getBytes("OBRAZEK_DATA"))
            .setObrazekNazev(rs.getString("OBRAZEK_NAZEV"))
            .setObrazekPripona(rs.getString("OBRAZEK_PRIPONA"))
            .setObrazekDatum(rs.getDate("OBRAZEK_DATUM"));

        return view;
    }
}
