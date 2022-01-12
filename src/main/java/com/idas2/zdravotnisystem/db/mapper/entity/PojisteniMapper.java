package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PojisteniMapper implements RowMapper<Pojisteni> {

    @Override
    public Pojisteni mapRow(ResultSet rs, int rowNum) throws SQLException {

        Pojisteni pojisteni = new Pojisteni();

        pojisteni
            .setCisloKarty(rs.getString("CISLOKARTY"))
            .setCisloSmlouvy(rs.getString("CISLOSMLOUVY"))
            .setPojistnaCastka(rs.getInt("POJISTNACASTKA"))
            .setPojisteniOd(rs.getDate("OD").toLocalDate())
            .setPojisteniDo(rs.getDate("DO").toLocalDate())
            .setPojistovnaIdPojistovna(rs.getInt("POJISTOVNA_ID_POJISTOVNA"))
            .setZdravotniKartaIdKarta(rs.getInt("ZDRAVOTNI_KARTA_ID_KARTA"))
            .setId(rs.getInt("ID_POJISTENI"));

        return pojisteni;
    }
}
