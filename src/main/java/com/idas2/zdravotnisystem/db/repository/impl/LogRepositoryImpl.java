package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Log;
import com.idas2.zdravotnisystem.db.mapper.entity.LogMapper;
import com.idas2.zdravotnisystem.db.repository.LogRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogRepositoryImpl
    extends AbstractCrudRepository<Log, LogMapper>
    implements LogRepository {


    public LogRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate);
    }

    @Override
    public @Nullable Log getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull Log entity) {
        return null;
    }

    @Override
    public @Nullable Log update(@NotNull Log entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull Log entity) {

    }

    @Override
    public List<Log> findAll() {
        return null;
    }
}
