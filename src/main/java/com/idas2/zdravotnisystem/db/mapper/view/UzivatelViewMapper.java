package com.idas2.zdravotnisystem.db.mapper.view;

import com.idas2.zdravotnisystem.db.view.UzivatelView;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UzivatelViewMapper implements RowMapper<UzivatelView> {

    @Override
    public UzivatelView mapRow(ResultSet rs, int rowNum) throws SQLException {

        UzivatelView user = new UzivatelView();

        user.setId(rs.getInt("ID"));

        return user
            .setJmeno(rs.getString("JMENO"))
            .setPrijmeni(rs.getString("PRIJMENI"))
            .setEmail(rs.getString("EMAIL"))
            .setPassword(rs.getString("HESLO"))
            .setObrazekIdObrazek(rs.getInt("OBRAZEK_ID_OBRAZEK"))
            .setUuid(rs.getString("UUID"))
            .setRole(rs.getString("ROLE"));

    }
}
