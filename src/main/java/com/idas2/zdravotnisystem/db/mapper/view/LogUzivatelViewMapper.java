package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.LogUzivatelView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LogUzivatelViewMapper implements RowMapper<LogUzivatelView> {
    @Override
    public LogUzivatelView mapRow(ResultSet rs, int rowNum) throws SQLException {

        LogUzivatelView logUzivatelView = new LogUzivatelView();

        logUzivatelView
            .setText(rs.getString("TEXT"))
            .setTabulka(rs.getString("TABULKA"))
            .setTelCislo(rs.getString("TELCISLO"))
            .setPrijmeni(rs.getString("PRIJMENI"))
            .setJmeno(rs.getString("JMENO"))
            .setEmail(rs.getString("EMAIL"))
            .setStav(rs.getString("STAV"))
            .setIdStav(rs.getInt("ID_STAV"))
            .setAkce(rs.getString("AKCE"))
            .setDatum(rs.getDate("DATUM"))
            .setId(rs.getInt("ID"));

        return logUzivatelView;
    }
}
