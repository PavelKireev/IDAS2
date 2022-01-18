package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.mapper.entity.PojisteniMapper;
import com.idas2.zdravotnisystem.db.repository.PojisteniRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PojisteniRepositoryImpl
    extends AbstractCrudRepository
    implements PojisteniRepository {

    private final PojisteniMapper pojisteniMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PojisteniRepositoryImpl(
        PojisteniMapper pojisteniMapper,
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.pojisteniMapper = pojisteniMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Pojisteni findByZdravorniKartaId(
        @NotNull Integer zdravotniKartaId
    ) {
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

    @Override
    public void updateByEntity(
        Pojisteni pojisteni
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("ID", pojisteni.getId())
                .addValue("CISLO_KARTY", pojisteni.getCisloKarty())
                .addValue("CISLO_SMLOUVY", pojisteni.getCisloSmlouvy())
                .addValue("POJISTNA_CASTKA", pojisteni.getPojistnaCastka())
                .addValue("OD", pojisteni.getPojisteniOd())
                .addValue("DO", pojisteni.getPojisteniDo())
                .addValue("ID_POJISTOVNA", pojisteni.getPojistovnaIdPojistovna())
                .addValue("ID_KARTA", pojisteni.getZdravotniKartaIdKarta())
            ;


            namedParameterJdbcTemplate.update(
                "CALL POJISTENI_PRC (" +
                    ":ID, :CISLO_KARTY, :CISLO_SMLOUVY, :POJISTNA_CASTKA, :OD, :DO, :ID_POJISTOVNA, :ID_KARTA )",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
