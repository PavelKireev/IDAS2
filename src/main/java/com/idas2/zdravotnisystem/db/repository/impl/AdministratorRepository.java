package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Administrator;
import com.idas2.zdravotnisystem.db.mapper.entity.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdministratorRepository
    extends AbstractCrudRepository<Administrator, AdministratorMapper> {

    @Autowired
    public AdministratorRepository(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
    }
}
