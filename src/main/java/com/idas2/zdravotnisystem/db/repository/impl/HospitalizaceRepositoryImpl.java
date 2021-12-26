package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.mapper.entity.HospitalizaceMapper;
import com.idas2.zdravotnisystem.db.mapper.view.HospitalizaceViewMapper;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalizaceRepositoryImpl
    extends AbstractCrudRepository<Hospitalizace, HospitalizaceMapper>
    implements HospitalizaceRepository {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(HospitalizaceRepositoryImpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final HospitalizaceViewMapper hospitalizaceViewMapper;

    public HospitalizaceRepositoryImpl(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        HospitalizaceViewMapper hospitalizaceViewMapper
    ) {
        super(namedParameterJdbcTemplate);
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.hospitalizaceViewMapper = hospitalizaceViewMapper;
    }

    public @Nullable HospitalizaceView findOne(Integer id) {
        try {
            return
                namedParameterJdbcTemplate
                    .queryForObject(
                        "SELECT * FROM HOSPITALIZACE_V WHERE ID = :ID",
                        mapParams("ID", id),
                        hospitalizaceViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public @Nullable Hospitalizace getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull Hospitalizace entity) {
        return null;
    }

    @Override
    public @Nullable Hospitalizace update(@NotNull Hospitalizace entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull Hospitalizace entity) {

    }

    @Override
    public List<HospitalizaceView> findAllByPacientId(
        @NotNull Integer pacientId
    ) {
        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM HOSPITALIZACE_V WHERE " +
                            "PACIENT_UZIVATEL_ID_UZIVATEL = :PACIENT_UZIVATEL_ID_UZIVATEL",
                        mapParams("PACIENT_UZIVATEL_ID_UZIVATEL", pacientId),
                        hospitalizaceViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<HospitalizaceView>();
        }
    }


}
