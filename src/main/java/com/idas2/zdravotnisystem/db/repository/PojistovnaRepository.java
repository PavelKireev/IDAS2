package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface PojistovnaRepository {
    @Nullable Pojistovna getOne(Integer id);

    void save(@NotNull Pojistovna pojistovna);

    List<Pojistovna> findAll();

    void delete(@NotNull Integer id);
}
