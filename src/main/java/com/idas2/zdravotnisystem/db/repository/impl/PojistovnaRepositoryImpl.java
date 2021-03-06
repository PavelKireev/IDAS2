package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.mapper.entity.PojistovnaMapper;
import com.idas2.zdravotnisystem.db.repository.PojistovnaRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PojistovnaRepositoryImpl
    extends AbstractCrudRepository
    implements PojistovnaRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PojistovnaRepositoryImpl.class);

    private final PojistovnaMapper pojistovnaMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PojistovnaRepositoryImpl(
        PojistovnaMapper pojistovnaMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.pojistovnaMapper = pojistovnaMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public @Nullable Pojistovna getOne(Integer id) {
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM POJISTOVNA WHERE ID_POJISTOVNA = :ID",
                        mapViewParams("ID", id),
                        pojistovnaMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn(ex.getMessage());
            return null;
        }
    }

    @Override
    public void save(@NotNull Pojistovna pojistovna) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", pojistovna.getId())
                .addValue("NAZEV", pojistovna.getNazev())
                .addValue("ADRESA", pojistovna.getAdresa())
                .addValue("TEL_CISLO", pojistovna.getTelCislo());

            namedParameterJdbcTemplate.update(
                "CALL POJISTOVNA_PRC (" +
                    ":ID, :NAZEV, :ADRESA, :TEL_CISLO )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pojistovna> findAll(){
        Map<String, Object> map = new HashMap<>();

        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM POJISTOVNA",
                        mapParams(map),
                        pojistovnaMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void delete(@NotNull Integer id) {

        try {
            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM POJISTOVNA WHERE ID_POJISTOVNA = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete pojistovna ex");
        }
    }

}
