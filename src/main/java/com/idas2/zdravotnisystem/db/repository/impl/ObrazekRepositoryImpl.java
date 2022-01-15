package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Obrazek;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.mapper.entity.AvatarMapper;
import com.idas2.zdravotnisystem.db.repository.ObrazekRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import oracle.jdbc.internal.OracleTypes;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.sql.Date;

@Service
public class ObrazekRepositoryImpl
    extends AbstractCrudRepository<Obrazek, AvatarMapper>
    implements ObrazekRepository {

    private final AvatarMapper avatarMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ObrazekRepositoryImpl(
        AvatarMapper avatarMapper,
        NamedParameterJdbcTemplate jdbcTemplate
    ) {
        super(jdbcTemplate);
        this.avatarMapper = avatarMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @NotNull
    @Override
    public Integer create(
        @NotNull Obrazek obrazek
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue(
                "DATA",
                new SqlLobValue(
                    new ByteArrayInputStream(obrazek.getData()),
                    obrazek.getData().length,
                    new DefaultLobHandler()
                ), OracleTypes.BLOB);
            parameters.addValue("NAZEV", obrazek.getNazev());
            parameters.addValue("PRIPONA", obrazek.getPripona());
            parameters.addValue("DATUM", obrazek.getDatum(), OracleTypes.DATE);

            return jdbcTemplate.update(
                "INSERT INTO OBRAZEK(DATA, NAZEV, PRIPONA, DATUM)" +
                    " VALUES (:DATA,:NAZEV, :PRIPONA, :DATUM)",
                parameters
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void upload(
        @NotNull User user,
        @NotNull MultipartFile obrazek
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();
// getPacientByUserId
            parameters
                .addValue("USER_ID", user.getId())
                .addValue("EMAIL", user.getEmail())
                .addValue("HESLO", user.getPassword())
                .addValue("JMENO", user.getJmeno())
                .addValue("PRIJMENI", user.getPrijmeni())
                .addValue("TEL_CISLO", 1234)
                .addValue("ADRESA", "1234")
                .addValue("NAZEV", obrazek.getOriginalFilename())
                .addValue("PRIPONA",
                    FilenameUtils.getExtension(obrazek.getOriginalFilename()))
                .addValue("RUST", 2)
                .addValue("HMOTNOST", 1)
                .addValue("DATUM_NAROZENI", new Date(4124))
                .addValue("ID_OTEC", null)
                .addValue("ID_MATKA", null);


            parameters.addValue(
                "DATA", obrazek.getBytes()
//                new SqlLobValue(
//                    new ByteArrayInputStream(obrazek.getBytes()),
//                    obrazek.getBytes().length,
//                    new DefaultLobHandler()
//                ), OracleTypes.BLOB
            );




            jdbcTemplate.update(
                "CALL PACIENT_PRC (" +
                    ":USER_ID, :EMAIL, :HESLO, :JMENO, :PRIJMENI, :TEL_CISLO, " +
                    ":ADRESA, :DATA,:NAZEV,:PRIPONA, :RUST, :HMOTNOST, " +
                    ":DATUM_NAROZENI, :ID_OTEC, :ID_MATKA)",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void upload(
        @NotNull PacientView user,
        @NotNull MultipartFile obrazek
    ) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            parameters
                .addValue("USER_ID", user.getId())
                .addValue("EMAIL", user.getEmail())
                .addValue("HESLO", user.getPassword())
                .addValue("JMENO", user.getJmeno())
                .addValue("PRIJMENI", user.getPrijmeni())
                .addValue("TEL_CISLO", 1234)
                .addValue("ADRESA", "1234")
                .addValue("NAZEV", obrazek.getOriginalFilename())
                .addValue("PRIPONA",
                    FilenameUtils.getExtension(obrazek.getOriginalFilename()))
                .addValue("RUST", 2)
                .addValue("HMOTNOST", 1)
                .addValue("DATUM_NAROZENI", new Date(4124))
                .addValue("ID_OTEC", null)
                .addValue("ID_MATKA", null);


            parameters.addValue(
                "DATA", obrazek.getBytes()
//                new SqlLobValue(
//                    new ByteArrayInputStream(obrazek.getBytes()),
//                    obrazek.getBytes().length,
//                    new DefaultLobHandler()
//                ), OracleTypes.BLOB
            );




            jdbcTemplate.update(
                "CALL PACIENT_PRC (" +
                    ":USER_ID, :EMAIL, :HESLO, :JMENO, :PRIJMENI, :TEL_CISLO, " +
                    ":ADRESA, :DATA,:NAZEV,:PRIPONA, :RUST, :HMOTNOST, " +
                    ":DATUM_NAROZENI, :ID_OTEC, :ID_MATKA)",
                parameters
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public @Nullable Obrazek getOne(Integer id) {
        return getOne(
            "SELECT * FROM OBRAZEK WHERE ID_OBRAZEK = :ID_OBRAZEK",
            mapParams("ID_OBRAZEK", id),
            avatarMapper
        );
    }

    @Override
    public @Nullable Obrazek update(@NotNull Obrazek entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull Obrazek entity) {

    }
}
