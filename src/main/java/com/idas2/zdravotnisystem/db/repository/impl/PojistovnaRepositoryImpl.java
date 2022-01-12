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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PojistovnaRepositoryImpl
    extends AbstractCrudRepository<Pojistovna, PojistovnaMapper>
    implements PojistovnaRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PojistovnaRepositoryImpl.class);

    private final PojistovnaMapper pojistovnaMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PojistovnaRepositoryImpl(
        PojistovnaMapper pojistovnaMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
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
            return null;
        }
    }

    @Override
    public @NotNull Integer create(@NotNull Pojistovna entity) {
        return null;
    }

    @Override
    public @Nullable Pojistovna update(@NotNull Pojistovna entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {
    }

    @Override
    public void delete(@NotNull Pojistovna entity) {
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
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

}
