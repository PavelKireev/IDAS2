package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.mapper.entity.PojisteniMapper;
import com.idas2.zdravotnisystem.db.repository.PojisteniRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PojisteniRepositoryImpl
    extends AbstractCrudRepository<Pojisteni, PojisteniMapper>
    implements PojisteniRepository {

    private PojisteniMapper pojisteniMapper;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PojisteniRepositoryImpl(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public @Nullable Pojisteni getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull Pojisteni entity) {
        return null;
    }

    @Override
    public @Nullable Pojisteni update(@NotNull Pojisteni entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull Pojisteni entity) {

    }

    @Override
    public Pojisteni findByZdravorniKartaId(
        @NotNull Integer zdravotniKartaId
    ){
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM POJISTENI WHERE ZDRAVOTNI_KARTA_ID_KARTA = :ID",
                        mapViewParams("ID", zdravotniKartaId),
                        pojisteniMapper
                    );
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
