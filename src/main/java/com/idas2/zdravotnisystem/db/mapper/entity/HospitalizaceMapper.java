package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalizaceMapper implements RowMapper<Hospitalizace> {

    @Override
    public Hospitalizace mapRow(
        @NotNull ResultSet rs, int rowNum) throws SQLException {

        Hospitalizace hospitalizace = new Hospitalizace();

        hospitalizace
            .setDuvod(rs.getString("DUVOD"))
            .setHospitalizaceDo(rs.getDate("DO"))
            .setHospitalizaceOd(rs.getDate("OD"))
            .setPacientUzivatelIdUzivatel(rs.getInt("PACIENT_UZIVATEL_ID_UZIVATEL"))
            .setId(rs.getInt("ID_HOSPITALIZACE"));

        return hospitalizace;
    }
}
