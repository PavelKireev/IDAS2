package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.ProceduraView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProceduraViewMapper implements RowMapper<ProceduraView> {

    @Override
    public ProceduraView mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProceduraView proceduraView = new ProceduraView();

        proceduraView
            .setIdProcedura(rs.getInt("ID_PROCEDURA"))
            .setDatum(rs.getDate("DATUM"))
            .setPopis(rs.getString("POPIS"))
            .setIdTypProcedury(rs.getInt("TYP_PROCEDURY_ID_TYPPROCEDURY"))
            .setNazevZarizeni(rs.getString("ZARIZENI_NAZEV"))
            .setZnackaZarizeni(rs.getString("ZARIZENI_ZNACKA"))
            .setDatuVyrobyZarizeni(rs.getDate("ZARIZENI_DATUMVYROBY"))
            .setJeFunkcni(rs.getBoolean("ZARIZENI_JEFUNKCNI"))
            .setIdMistnost(rs.getInt("ORDINACE_MISTNOST_ID_MISTNOST"))
            .setOrdinaceNazev(rs.getString("ORDINACE_NAZEV"))
            .setOrdinaceCislo(rs.getString("ORDINACE_CISLO"))
            .setOrdinacePlocha(rs.getString("ORDINACE_PLOCHA"))
            .setOrdinaceJeVprovozu(rs.getBoolean("ORDINACE_JEVPROVOZU"));

        return proceduraView;
    }
}
