package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Pacient;
import com.idas2.zdravotnisystem.db.view.PacientView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PacientMapper implements RowMapper<Pacient> {

    @Override
    public Pacient mapRow(ResultSet rs, int rowNum) throws SQLException {

        Pacient user = new Pacient();

        Integer otecID =
            rs.getInt("PACIENT_UZIVATEL_ID_OTEC") == 0 ?
                null : rs.getInt("PACIENT_UZIVATEL_ID_OTEC");

        Integer matkaId =
            rs.getInt("PACIENT_UZIVATEL_ID_MATKA") == 0 ?
                null : rs.getInt("PACIENT_UZIVATEL_ID_MATKA");

        user
            .setRust(rs.getInt("RUST"))
            .setHmotnost(rs.getInt("HMOTNOST"))
            .setDatumNarozeni(rs.getDate("DATUMNAROZENI"))
            .setNemocnicniPokojIdMistnost(rs.getInt("NEMOCNICNI_POKOJ_ID_MISTNOST"))
            .setAdresa(rs.getString("ADRESA"))
            .setIdMatka(matkaId)
            .setIdOtec(otecID)
            .setId(rs.getInt("UZIVATEL_ID_UZIVATEL"));

        return user;
    }

}
