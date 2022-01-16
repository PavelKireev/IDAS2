package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Zaznam;
import com.idas2.zdravotnisystem.db.mapper.entity.ZaznamMapper;
import com.idas2.zdravotnisystem.db.mapper.view.ZaznamViewMapper;
import com.idas2.zdravotnisystem.db.repository.ZaznamRepository;
import com.idas2.zdravotnisystem.db.view.ZaznamView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZaznamRepositoryImpl
    extends AbstractCrudRepository<Zaznam, ZaznamMapper>
    implements ZaznamRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZaznamRepositoryImpl.class);

    private final ZaznamMapper zaznamMapper;
    private final ZaznamViewMapper zaznamViewMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ZaznamRepositoryImpl(
        ZaznamMapper zaznamMapper,
        ZaznamViewMapper zaznamViewMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        super(namedParameterJdbcTemplate);
        this.zaznamMapper = zaznamMapper;
        this.zaznamViewMapper = zaznamViewMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public @Nullable Zaznam getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull Zaznam entity) {
        return null;
    }

    @Override
    public @Nullable Zaznam update(@NotNull Zaznam entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

        try {
            namedParameterJdbcTemplate
                .update(
                    "DELETE FROM ZAZNAM WHERE ID_ZAZNAM = :ID",
                    mapParams("ID", id)
                );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("Delete zaznam ex");
        }
    }

    @Override
    public void delete(@NotNull Zaznam entity) {

    }

    @Override
    public List<ZaznamView> findAllByHospitalizaceId(
        @NotNull Integer hospitalizaceId
    ) {
        try {
            return
                namedParameterJdbcTemplate
                    .query(
                        "SELECT * FROM ZAZNAM_V WHERE " +
                            "HOSPITALIZACE_ID_HOSPITALIZACE = :HOSPITALIZACE_ID_HOSPITALIZACE",
                        mapParams("HOSPITALIZACE_ID_HOSPITALIZACE", hospitalizaceId),
                        zaznamViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public void saveFromView(
        @NotNull ZaznamView zaznamView
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", zaznamView.getId())
                .addValue("TITUL", zaznamView.getTitul())
                .addValue("TEXT", zaznamView.getText())
                .addValue("ID_HOSPITALIZACE", zaznamView.getHospitalizaceIdHospitalizace())
                .addValue("ID_LEKAR", zaznamView.getLekarUzivatelIdUzivatel());

            namedParameterJdbcTemplate.update(
                "CALL ZAZNAM_PRC (" +
                    ":ID, :TITUL, :TEXT, :ID_HOSPITALIZACE, :ID_LEKAR )",
                parameters
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
