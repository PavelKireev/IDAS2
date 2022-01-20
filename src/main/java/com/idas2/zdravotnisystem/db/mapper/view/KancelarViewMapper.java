package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.KancelarView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class KancelarViewMapper implements RowMapper<KancelarView> {

    @Override
    public KancelarView mapRow(ResultSet rs, int rowNum) throws SQLException {
        KancelarView view = new KancelarView();

        view
            .setNazev(rs.getString("NAZEV"))
            .setCislo(rs.getInt("CISLO"))
            .setPlocha(rs.getString("PLOCHA"))
            .setJeObsazena(rs.getBoolean("JEOBSAZENA"))
            .setId(rs.getInt("ID"));

        return view;
    }
}
