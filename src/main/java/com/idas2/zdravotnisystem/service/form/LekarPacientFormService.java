package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarKartaUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarPacientUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarPojisteniForm;
import org.jetbrains.annotations.NotNull;

public interface LekarPacientFormService {

    @NotNull
    LekarKartaUpdateForm buildKartaForm(
        @NotNull ZdravortniKarta source,
        @NotNull LekarKartaUpdateForm target
    );

    void updateKartaForm(
        @NotNull Integer pacientId,
        @NotNull LekarKartaUpdateForm source
    );

    @NotNull
    LekarPojisteniForm buildPojisteniForm(
        @NotNull Pojisteni source,
        @NotNull LekarPojisteniForm target
    );

    void updatePojisteniForm(
        @NotNull Integer zdravotniKartaId,
        @NotNull LekarPojisteniForm source
    );


    @NotNull
    LekarPacientUpdateForm buildPacientForm(
        @NotNull PacientView source,
        @NotNull LekarPacientUpdateForm target
    );

    void updatePacientForm(
        @NotNull Integer pacientId,
        @NotNull LekarPacientUpdateForm source
    );

}
