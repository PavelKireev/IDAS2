package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.PacientView;
import org.jetbrains.annotations.NotNull;

public interface PacientRepository{

    PacientView getPacientViewByUzivatelId(
        @NotNull Integer uzivatelId
    );

}
