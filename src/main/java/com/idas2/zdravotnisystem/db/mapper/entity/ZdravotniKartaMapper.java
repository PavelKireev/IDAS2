package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.ZdravotniKarta;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ZdravotniKartaMapper implements RowMapper<ZdravotniKarta> {

    @Override
    public ZdravotniKarta mapRow(ResultSet rs, int rowNum) throws SQLException {

        ZdravotniKarta zdravotniKarta = new ZdravotniKarta();

        zdravotniKarta
            .setKartaOd(rs.getDate("OD").toLocalDate())
            .setKartaDo(rs.getDate("DO").toLocalDate())
            .setDatumVytvareni(rs.getDate("DATUMVYTVARENI").toLocalDate())
            .setPacientUzivatelIdUzivatel(rs.getInt("PACIENT_UZIVATEL_ID_UZIVATEL"))
            .setId(rs.getInt("ID_KARTA"));

        return zdravotniKarta;
    }
}
