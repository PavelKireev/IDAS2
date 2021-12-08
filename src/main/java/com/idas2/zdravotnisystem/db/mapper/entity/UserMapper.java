package com.idas2.zdravotnisystem.db.mapper.entity;

import com.idas2.zdravotnisystem.db.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("ID_UZIVATEL"));

        user
            .setJmeno(rs.getString("JMENO"))
            .setPrijmeni(rs.getString("PRIJMENI"))
            .setEmail(rs.getString("EMAIL"))
            .setPassword(rs.getString("HESLO"))
            .setObrazekIdObrazek(rs.getInt("OBRAZEK_ID_OBRAZEK"));

        return user;
    }
}

