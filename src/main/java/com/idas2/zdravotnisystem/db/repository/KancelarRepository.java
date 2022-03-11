package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.KancelarView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface KancelarRepository {

    List<KancelarView> findAllView();

    KancelarView findById(
        @NotNull Integer id
    );

    KancelarView findByCislo(
        @NotNull Integer cislo
    );

    void saveFromView(
        @NotNull KancelarView view
    );

    void delete(
        @NotNull Integer id
    );
}
