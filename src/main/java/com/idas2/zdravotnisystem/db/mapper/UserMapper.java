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
        user.setId(rs.getInt("id"));

        user
            .setJmeno(rs.getString("jmeno"))
            .setPrijmeni(rs.getString("prijmeni"))
            .setEmail(rs.getString("email"))
            .setPassword(rs.getString("heslo"));
//            .setRoleId(rs.getInt("role_id_role"))
//            .setAvatarId(rs.getInt("avatar_id_avatar"));

        return user;
    }
}

