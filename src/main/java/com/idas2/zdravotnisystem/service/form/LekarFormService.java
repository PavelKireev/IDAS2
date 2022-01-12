package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.lekar.LekarProfileUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface LekarFormService {

    void update(
        @NotNull LekarProfileUpdateForm source,
        @NotNull Integer lekarId
    );

    @NotNull
    LekarProfileUpdateForm buildInfoFormFromView(
        @NotNull LekarView lekarView
    );
}
