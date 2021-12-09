package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.PacientInfoForm;
import org.jetbrains.annotations.NotNull;

public interface PacientRepository {

    PacientView getPacientViewByUzivatelId(
        @NotNull Integer uzivatelId
    );

    void updateInfoByView(
        @NotNull PacientView pacientView
    );

}
