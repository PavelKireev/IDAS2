package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NemocnicniPokojViewMapper implements RowMapper<NemocnicniPokojView> {

    @Override
    public NemocnicniPokojView mapRow(ResultSet rs, int rowNum) throws SQLException {

        NemocnicniPokojView nemocnicniPokojView = new NemocnicniPokojView();

        nemocnicniPokojView
            .setPocetPacientu(rs.getInt("POCET_PACIENTU"))
            .setKapacita(rs.getInt("KAPACITA"))
            .setPlocha(rs.getString("PLOCHA"))
            .setCislo(rs.getInt("CISLO"))
            .setNazev(rs.getString("NAZEV"))
            .setId(rs.getInt("ID"));


        return nemocnicniPokojView;
    }
}
