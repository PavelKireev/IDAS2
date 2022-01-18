package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarProfileUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface LekarFormService {

    void update(
        @NotNull LekarProfileUpdateForm source,
        @NotNull Integer lekarId
    );

    void update(
        @NotNull LekarUpdateForm form
    );

    @NotNull
    LekarProfileUpdateForm buildInfoFormFromView(
        @NotNull LekarView lekarView
    );

    @NotNull
    LekarUpdateForm buildUpdateForm(
        @NotNull LekarView lekarView
    );

    void save(
        @NotNull LekarCreateForm form
    );
}
