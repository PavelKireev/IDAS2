package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface PojistovnaRepository {
    @Nullable Pojistovna getOne(Integer id);

    List<Pojistovna> findAll();
}
