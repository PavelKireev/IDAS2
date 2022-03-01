package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Zarizeni;
import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ZarizeniRepository {
    List<Zarizeni> findAll();
    List<ZarizeniView> findAllView();

    @NotNull
    ZarizeniView getOne(@NotNull Integer id);

    void save(@NotNull Zarizeni view);
    void saveFromView(@NotNull ZarizeniView view);
    void delete(@NotNull Integer id);
}
