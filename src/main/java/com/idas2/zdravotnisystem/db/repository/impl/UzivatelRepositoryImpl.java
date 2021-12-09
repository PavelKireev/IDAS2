package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.mapper.entity.UserMapper;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UzivatelRepositoryImpl
    extends AbstractCrudRepository<User, UserMapper>
    implements UzivatelRepository {

    private final UserMapper mapper;

    @Autowired
    public UzivatelRepositoryImpl(
        NamedParameterJdbcTemplate namedParameterJdbcTemplate,
        UserMapper mapper
    ) {
        super(namedParameterJdbcTemplate);
        this.mapper = mapper;
    }

    @Override
    public @Nullable User getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull User entity) {
        return null;
    }

    @Override
    public User update(
        @NotNull User user
    ) {
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//// getPacientByUserId
//        parameters
//            .addValue("USER_ID", user.getId())
//            .addValue("EMAIL", user.getEmail())
//            .addValue("HESLO", user.getPassword())
//            .addValue("JMENO", user.getJmeno())
//            .addValue("PRIJMENI", user.getPrijmeni())
//            .addValue("TEL_CISLO", 1234)
//            .addValue("ADRESA", "1234")
//            .addValue("NAZEV", obrazek.getOriginalFilename())
//            .addValue("PRIPONA",
//                FilenameUtils.getExtension(obrazek.getOriginalFilename()))
//            .addValue("RUST", 2)
//            .addValue("HMOTNOST", 1)
//            .addValue("DATUM_NAROZENI", new Date(4124))
//            .addValue("ID_OTEC", null)
//            .addValue("ID_MATKA", null);
//
//
//        parameters.addValue(
//            "DATA", obrazek.getBytes()
////                new SqlLobValue(
////                    new ByteArrayInputStream(obrazek.getBytes()),
////                    obrazek.getBytes().length,
////                    new DefaultLobHandler()
////                ), OracleTypes.BLOB
//        );
//{
//
//
//
//        jdbcTemplate.update(
//            "CALL PACIENT_PRC (" +
//                ":USER_ID, :EMAIL, :HESLO, :JMENO, :PRIJMENI, :TEL_CISLO, " +
//                ":ADRESA, :DATA,:NAZEV,:PRIPONA, :RUST, :HMOTNOST, " +
//                ":DATUM_NAROZENI, :ID_OTEC, :ID_MATKA)",
//            parameters
//        );
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//        update(
//            mapParams()
//        );
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull User entity) {

    }

    @Override
    public User findByEmail(String email) {
        return getOne(
            "SELECT * FROM UZIVATEL WHERE EMAIL = :EMAIL",
            mapParams("EMAIL", email),
            mapper
        );
    }

    @NotNull
    @Override
    public User findByUuid(String uuid) {
        return getOne(
            "SELECT * FROM UZIVATEL WHERE UUID = :UUID",
            mapParams("UUID", uuid),
            mapper
        );
    }
}
