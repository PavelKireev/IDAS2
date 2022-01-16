package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Zaznam;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ZaznamMapper implements RowMapper<Zaznam> {

    @Override
    public Zaznam mapRow(ResultSet rs, int rowNum) throws SQLException {

        Zaznam zaznam = new Zaznam();

        zaznam
            .setTitul(rs.getString("TITUL"))
            .setText(rs.getString("TEXT"))
            .setHospitalizaceIdHospitalizace(rs.getInt("HOSPITALIZACE_ID_HOSPITALIZACE"))
            .setLekarUzivatelIdUzivatel(rs.getInt("LEKAR_UZIVATEL_ID_UZIVATEL"))
            .setDatumVytvareni(rs.getDate("DATUMVYTVARENI"))
            .setId(rs.getInt("ID"));

        return zaznam;
    }

}
