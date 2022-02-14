package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface NemocnicniPokojRepository {

    List<NemocnicniPokojView> findAll();

    void saveFromView(
        @NotNull NemocnicniPokojView view
    );

    void delete(
        @NotNull Integer id
    );

    NemocnicniPokojView findById(
        @NotNull Integer id
    );

}
