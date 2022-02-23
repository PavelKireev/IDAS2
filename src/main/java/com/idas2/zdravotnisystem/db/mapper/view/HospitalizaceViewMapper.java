package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HospitalizaceViewMapper implements RowMapper<HospitalizaceView> {

    @Override
    public HospitalizaceView mapRow(ResultSet rs, int rowNum) throws SQLException {

        HospitalizaceView hospitalizaceView = new HospitalizaceView();

        return hospitalizaceView
            .setId(rs.getInt("ID"))
            .setDuvod(rs.getString("DUVOD"))
            .setPacientJmeno(rs.getString("PACIENT_JMENO"))
            .setPacientPrijmeni(rs.getString("PACIENT_PRIJMENI"))
            .setStavPacienta(rs.getString("STAVPACIENTA"))
            .setHospitalozaceOd(rs.getDate("OD"))
            .setHospitalizaceDo(rs.getDate("DO"))
            .setPokojCislo(rs.getInt("POKOJ_CISLO"))
            .setPokojNazev(rs.getString("POKOJ_NAZEV"));
    }
}
