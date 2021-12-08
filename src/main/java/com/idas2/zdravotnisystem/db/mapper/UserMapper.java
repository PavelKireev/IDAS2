package com.idas2.zdravotnisystem.db.mapper;

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
            .setPassword(rs.getString("HESLO"));
//            .setRoleId(rs.getInt("role_id_role"))
//            .setAvatarId(rs.getInt("avatar_id_avatar"));

        return user;
    }
}
