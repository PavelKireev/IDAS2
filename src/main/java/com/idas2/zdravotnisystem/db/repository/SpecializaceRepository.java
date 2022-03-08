package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Specializace;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface SpecializaceRepository {

    @NotNull Specializace getOne(@NotNull Integer id);
    @NotNull List<Specializace> findAll();

    void save(@NotNull Specializace entity);
    void delete(@NotNull Integer id);
}
