package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.OrdinaceView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface OrdinaceRepository {

    @NotNull
    List<OrdinaceView> findAll();

    @NotNull
    OrdinaceView findById(
        @NotNull Integer id
    );

    void delete(
        @NotNull Integer id
    );

    void saveFromView(
        @NotNull OrdinaceView view
    );
}
