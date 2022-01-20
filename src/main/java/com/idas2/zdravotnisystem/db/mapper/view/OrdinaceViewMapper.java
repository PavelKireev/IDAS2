package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.OrdinaceView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdinaceViewMapper implements RowMapper<OrdinaceView> {

    @Override
    public OrdinaceView mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrdinaceView view = new OrdinaceView();

        view
            .setNazev(rs.getString("NAZEV"))
            .setCislo(rs.getInt("CISLO"))
            .setPlocha(rs.getInt("CISLO"))
            .setJeVProvozu(rs.getBoolean("JEVPROVOZU"))
            .setId(rs.getInt("ID"));

        return view;
    }
}
