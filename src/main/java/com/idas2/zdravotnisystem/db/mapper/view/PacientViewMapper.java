package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.PacientView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PacientViewMapper implements RowMapper<PacientView> {

    @Override
    public PacientView mapRow(ResultSet rs, int rowNum) throws SQLException {
        PacientView user = new PacientView();

            Integer otecID =
                rs.getInt("PACIENT_UZIVATEL_ID_OTEC") == 0 ?
                    null : rs.getInt("PACIENT_UZIVATEL_ID_OTEC");

        Integer matkaId =
            rs.getInt("PACIENT_UZIVATEL_ID_MATKA") == 0 ?
                null : rs.getInt("PACIENT_UZIVATEL_ID_MATKA");

        user
            .setId(rs.getInt("ID"))
            .setPassword(rs.getString("HESLO"))
            .setUuid(rs.getString("UUID"))
            .setEmail(rs.getString("EMAIL"))
            .setJmeno(rs.getString("JMENO"))
            .setPrijmeni(rs.getString("PRIJMENI"))
            .setTelCislo(rs.getString("TELCISLO"))
            .setObrazekData(rs.getBytes("OBRAZEK_DATA"))
            .setObrazekNazev(rs.getString("OBRAZEK_NAZEV"))
            .setObrazekPripona(rs.getString("OBRAZEK_PRIPONA"))
            .setObrazekDatum(rs.getDate("DATUMNAROZENI"))
            .setAdresa(rs.getString("ADRESA"))
            .setRust(rs.getInt("RUST"))
            .setHmotnost(rs.getInt("HMOTNOST"))
            .setDatumNarozeni(rs.getDate("DATUMNAROZENI"))
            .setPokojNazev(rs.getString("POKOJ_NAZEV"))
            .setPokojCislo(rs.getString("POKOJ_CISLO"))
            .setPokojKapacita(rs.getInt("POKOJ_KAPACITA"))
            .setPokojPocetPacientu(rs.getInt("POKOJ_POCETPACIENTU"))
            .setPacientUzivatelIdOtec(otecID)
            .setPacientUzivatelIdMatka(matkaId);

        return user;
    }
}
