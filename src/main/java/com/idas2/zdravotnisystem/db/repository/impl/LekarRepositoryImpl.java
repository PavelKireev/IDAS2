package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Lekar;
import com.idas2.zdravotnisystem.db.mapper.entity.LekarMapper;
import com.idas2.zdravotnisystem.db.mapper.view.LekarViewMapper;
import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.view.LekarView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LekarRepositoryImpl
    extends AbstractCrudRepository<Lekar, LekarMapper>
    implements LekarRepository {

    private final LekarViewMapper lekarViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public LekarRepositoryImpl(
        LekarViewMapper lekarViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
        this.lekarViewMapper = lekarViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public @Nullable Lekar getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull Lekar entity) {
        return null;
    }

    @Override
    public @Nullable Lekar update(@NotNull Lekar entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull Lekar entity) {
    }


    @Override
    public @NotNull LekarView getViewById(@NotNull Integer id) {
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM LEKAR_V WHERE ID = :ID",
                        mapViewParams("ID", id),
                        lekarViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
