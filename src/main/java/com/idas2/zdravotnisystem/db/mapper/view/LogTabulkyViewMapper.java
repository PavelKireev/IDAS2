package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.LogTabulkyView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LogTabulkyViewMapper implements RowMapper<LogTabulkyView> {

    @Override
    public LogTabulkyView mapRow(ResultSet rs, int rowNum) throws SQLException {

        LogTabulkyView logTabulkyView = new LogTabulkyView();

        logTabulkyView
            .setText(rs.getString("TEXT"))
            .setPrimarniKlic(rs.getInt("PRIMARNI_KLIC"))
            .setTabulka(rs.getString("TABULKA"))
            .setAkce(rs.getString("AKCE"))
            .setDatum(rs.getDate("DATUM"));

        return logTabulkyView;
    }
}
