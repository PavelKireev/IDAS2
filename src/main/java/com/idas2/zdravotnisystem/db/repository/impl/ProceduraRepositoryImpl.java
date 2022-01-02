package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Procedura;
import com.idas2.zdravotnisystem.db.mapper.entity.ProceduraMapper;
import com.idas2.zdravotnisystem.db.mapper.view.ProceduraViewMapper;
import com.idas2.zdravotnisystem.db.repository.ProceduraRepository;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.db.view.UzivatelView;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProceduraRepositoryImpl
    extends AbstractCrudRepository<Procedura, ProceduraMapper>
    implements ProceduraRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProceduraRepositoryImpl.class);

    private final ProceduraMapper proceduraMapper;
    private final ProceduraViewMapper proceduraViewMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProceduraRepositoryImpl(
        ProceduraMapper proceduraMapper, NamedParameterJdbcTemplate jdbcTemplate,
        ProceduraViewMapper proceduraViewMapper
    ) {
        super(jdbcTemplate);
        this.proceduraMapper = proceduraMapper;
        this.jdbcTemplate = jdbcTemplate;
        this.proceduraViewMapper = proceduraViewMapper;
    }

    @Override
    public List<ProceduraView> getProceduraViewListByUserIdBeforeNow(
        @NotNull Integer userId
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("PACIENT_UZIVATEL_ID_UZIVATEL", userId);
        map.put("CURRENT_TIME", Timestamp.valueOf(LocalDateTime.now()));
        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM PROCEDURA_V WHERE " +
                            "PACIENT_UZIVATEL_ID_UZIVATEL = :PACIENT_UZIVATEL_ID_UZIVATEL " +
                            "AND DATUM < :CURRENT_TIME",
                        mapParams(map),
                        proceduraViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProceduraView> getProceduraViewListByUserIdAfterNow(
        @NotNull Integer userId
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("PACIENT_UZIVATEL_ID_UZIVATEL", userId);
        map.put("CURRENT_TIME", Timestamp.valueOf(LocalDateTime.now()));
        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM PROCEDURA_V WHERE " +
                            "PACIENT_UZIVATEL_ID_UZIVATEL = :PACIENT_UZIVATEL_ID_UZIVATEL " +
                            "AND DATUM > :CURRENT_TIME",
                        mapParams(map),
                        proceduraViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProceduraView> getProceduraViewListByLekarIdBeforeNow(
        @NotNull Integer lekarId
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("LEKAR_UZIVATEL_ID_UZIVATEL", lekarId);
        map.put("CURRENT_TIME", Timestamp.valueOf(LocalDateTime.now()));
        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM PROCEDURA_V WHERE " +
                            "LEKAR_UZIVATEL_ID_UZIVATEL = :LEKAR_UZIVATEL_ID_UZIVATEL " +
                            "AND DATUM < :CURRENT_TIME",
                        mapParams(map),
                        proceduraViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProceduraView> getProceduraViewListByLekarIdAfterNow(
        @NotNull Integer lekarId
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("LEKAR_UZIVATEL_ID_UZIVATEL", lekarId);
        map.put("CURRENT_TIME", Timestamp.valueOf(LocalDateTime.now()));
        try {
            return
                jdbcTemplate
                    .query(
                        "SELECT * FROM PROCEDURA_V WHERE " +
                            "LEKAR_UZIVATEL_ID_UZIVATEL = :LEKAR_UZIVATEL_ID_UZIVATEL " +
                            "AND DATUM > :CURRENT_TIME",
                        mapParams(map),
                        proceduraViewMapper
                    );

        } catch (EmptyResultDataAccessException ex) {
            LOGGER.warn("EmptyResultDataAccessException");
            return new ArrayList<>();
        }
    }

    @Override
    public void saveFromView(ProceduraView view) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", view.getIdProcedura())
                .addValue("DATE", view.getDatum())
                .addValue("ID_PROCEDURY", view.getIdTypProcedury())
                .addValue("POPIS", view.getPopis())
                .addValue("ID_ZARIZENI", view.getIdZarizeni())
                .addValue("ID_HOSPITALIZACE", view.getIdHospitalizace())
                .addValue("ID_UZIVATEL", view.getIdLekar());

            jdbcTemplate.update(
                "CALL PROCEDURA_PRC (" +
                    ":ID, :DATE, :ID_PROCEDURY, :POPIS, :ID_ZARIZENI, " +
                    ":ID_HOSPITALIZACE, :ID_UZIVATEL )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteByUuid(@NotNull String uuid) {
        try {
            jdbcTemplate.update(
                "DELETE FROM PROCEDURA WHERE UUID = :UUID",
                mapParams("UUID", uuid)
            );
        } catch (EmptyResultDataAccessException ex) {
            LOGGER.error(ex.getMessage());
        }

    }
}
