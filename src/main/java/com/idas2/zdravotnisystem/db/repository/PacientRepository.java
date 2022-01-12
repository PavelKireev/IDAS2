package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Pacient;
import com.idas2.zdravotnisystem.db.view.PacientView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface PacientRepository {

    PacientView getPacientViewByUzivatelId(
        @NotNull Integer uzivatelId
    );

    void updateByView(
        @NotNull PacientView pacientView
    );

    List<Pacient> findAll();

    List<PacientView> findAllView();

    void delete(@NotNull Integer id);


    PacientView getPacientViewByUzivatelUuid(
        @NotNull String pacientUuid
    );
}
