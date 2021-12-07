package com.idas2.zdravotnisystem.db.mapper;

import com.idas2.zdravotnisystem.db.entity.Administrator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AdministratorMapper implements RowMapper<Administrator> {

    public Administrator mapRow(ResultSet rs, int rowNum) throws SQLException {
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("ID_UZIVATEL"));

        administrator.setUserId(1L);

        return administrator;
    }


}
