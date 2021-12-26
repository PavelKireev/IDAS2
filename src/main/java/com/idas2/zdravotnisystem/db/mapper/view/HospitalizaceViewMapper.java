package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

@Component
public class HospitalizaceViewMapper implements RowMapper<HospitalizaceView> {

    @Override
    public HospitalizaceView mapRow(ResultSet rs, int rowNum) throws SQLException {

        HospitalizaceView hospitalizaceView = new HospitalizaceView();

        return hospitalizaceView
            .setId(rs.getInt("ID"))
            .setDuvod(rs.getString("DUVOD"))
            .setStavPacienta(rs.getString("STAVPACIENTA"))
            .setHospitalozaceOd(rs.getDate("OD").toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE))
            .setHospitalizaceDo(rs.getDate("DO").toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
