package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ZarizeniViewMapper implements RowMapper<ZarizeniView> {

    @Override
    public ZarizeniView mapRow(
        ResultSet rs, int rowNum
    ) throws SQLException {

        ZarizeniView view = new ZarizeniView();

        return new ZarizeniView()
            .setId(rs.getInt("ID"))
            .setNazev(rs.getString("NAZEV"))
            .setZnacka(rs.getString("ZNACKA"))
            .setDatumVyroby(rs.getDate("DATUMVYROBY"))
            .setJeFunkcni(rs.getBoolean("JEFUNKCNI"))
            .setIdMistnost(rs.getInt("ORDINACE_MISTNOST_ID_MISTNOST"))
            .setOrdinaceCislo(rs.getInt("ORDINACE_CISLO"))
            .setOrdinaceNazev(rs.getString("ORDINACE_NAZEV"))
            .setIdTypZarizeni(rs.getInt("TYP_ZARIZENI_ID_TYPZARIZENI"))
            .setTypZarizeniNazev(rs.getString("TYP_ZARIZENI_NAZEV"));

    }


}
