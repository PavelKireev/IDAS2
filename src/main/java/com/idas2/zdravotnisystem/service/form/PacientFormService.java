package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.PacientInfoForm;
import org.jetbrains.annotations.NotNull;

public interface PacientFormService {

    @NotNull
    PacientInfoForm buildInfoFormFromView(
        @NotNull PacientInfoForm target,
        @NotNull PacientView source
    );

    @NotNull
    PacientInfoForm buildInfoFormFromView(
        @NotNull PacientView source
    );

    void updateProfileInfo(
        @NotNull String userUuid,
        @NotNull PacientInfoForm form
    );

    void updateInfoPaient(
        @NotNull Integer pacientId,
        @NotNull PacientInfoForm pacientInfoForm
    );
}
