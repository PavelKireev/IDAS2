package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.lekar.LekarKartaUpdateForm;
import com.idas2.zdravotnisystem.form.lekar.LekarPacientUpdateForm;
import com.idas2.zdravotnisystem.form.lekar.LekarPojisteniForm;
import com.idas2.zdravotnisystem.form.lekar.LekarZdravortniKartaForm;
import org.jetbrains.annotations.NotNull;

public interface LekarPacientFormService {

    @NotNull
    LekarKartaUpdateForm buildKartaForm(
        @NotNull ZdravortniKarta source,
        @NotNull LekarKartaUpdateForm target
    );

    void updateKartaForm(
        @NotNull Integer kartaId,
        @NotNull LekarZdravortniKartaForm source
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
