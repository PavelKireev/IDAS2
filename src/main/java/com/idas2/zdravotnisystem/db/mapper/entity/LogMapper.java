package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Log;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LogMapper implements RowMapper<Log> {

    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {

        Log log = new Log();
        log.setAkce(rs.getString("AKCE"))
            .setTabulka(rs.getString("TABULKA"))
            .setDatum(rs.getDate("DATUM"))
            .setText(rs.getString("TEXT"))
            .setUzivatelIdUzivatel(rs.getInt("UZIVATEL_ID_UZIVATEL"))
            .setOdebranyIdOdebranyUzivatel(rs.getInt("ODEBRANY_ID_ODEBRANY_UZIVATEL"))
            .setPrimarniKlic(rs.getInt("PRIMARNI_KLIC"))
            .setId(rs.getInt("ID_LOG"));


        return log;
    }
}
