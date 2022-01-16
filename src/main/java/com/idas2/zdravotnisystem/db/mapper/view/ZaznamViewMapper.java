package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.ZaznamView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ZaznamViewMapper implements RowMapper<ZaznamView> {

    @Override
    public ZaznamView mapRow(ResultSet rs, int rowNum) throws SQLException {

        ZaznamView view = new ZaznamView();

        view
            .setTitul(rs.getString("TITUL"))
            .setText(rs.getString("TEXT"))
            .setHospitalizaceIdHospitalizace(rs.getInt("HOSPITALIZACE_ID_HOSPITALIZACE"))
            .setLekarUzivatelIdUzivatel(rs.getInt("LEKAR_UZIVATEL_ID_UZIVATEL"))
            .setDatumVytvareni(rs.getDate("DATUMVYTVARENI"))
            .setJmeno(rs.getString("JMENO"))
            .setPrijmeni(rs.getString("PRIJMENI"))
            .setId(rs.getInt("ID"));

        return view;
    }
}
