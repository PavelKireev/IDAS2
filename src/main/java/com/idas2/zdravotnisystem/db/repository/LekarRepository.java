package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.LekarView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface LekarRepository {

    @NotNull
    LekarView getViewById(
        @NotNull Integer id
    );

    void updateInfoByView(
        LekarView view
    );

    @NotNull
    List<LekarView> findAllView();

    void delete(
        @NotNull Integer id
    );
}
