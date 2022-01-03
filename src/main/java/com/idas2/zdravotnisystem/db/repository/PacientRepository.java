package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Pacient;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.PacientInfoForm;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface PacientRepository {

    PacientView getPacientViewByUzivatelId(
        @NotNull Integer uzivatelId
    );

    void updateInfoByView(
        @NotNull PacientView pacientView
    );

    List<Pacient> findAll();


}
