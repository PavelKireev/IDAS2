package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Ordinace;
import com.idas2.zdravotnisystem.db.repository.OrdinaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class OrdinaceRepositoryImpl implements OrdinaceRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public OrdinaceRepositoryImpl(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<Ordinace> findAll() {
        return null;
    }

    @Override
    public void saveFromEntity(Ordinace entity) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", entity.getId())
                .addValue("NAZEV", entity.getNazev())
                .addValue("CISLO", Integer.valueOf(entity.getCislo()))
                .addValue("PLOCHA", entity.getPlocha())
                .addValue("JEVPROVOZU", entity.getJeVProvozu().toString());


            namedParameterJdbcTemplate.update(
                "CALL ORDINACE_PRC (" +
                    ":ID, :NAZEV, :CISLO, :PLOCHA, :JEVPROVOZU )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
