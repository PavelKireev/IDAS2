package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.TypZarizeni;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface TypZarizeniRepository {

    @NotNull TypZarizeni getOne(@NotNull Integer id);
    @NotNull List<TypZarizeni> findAll();

    void save(@NotNull TypZarizeni entity);
    void delete(@NotNull Integer id);

}
