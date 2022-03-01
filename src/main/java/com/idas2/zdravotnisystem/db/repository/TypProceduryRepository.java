package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface TypProceduryRepository{

    List<TypProcedury> findAll();

    @Nullable TypProcedury getOne(Integer id);

    void save(@NotNull TypProcedury typProcedury);

    void delete(@NotNull Integer id);
}
