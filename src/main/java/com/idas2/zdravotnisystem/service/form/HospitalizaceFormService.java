package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface HospitalizaceFormService {

    @NotNull
    HospitalizaceUpdateForm buildUpdateForm(
        @NotNull HospitalizaceView view
    );

    void create(
        @NotNull HospitalizaceCreateForm form
    );

    void update(
        @NotNull HospitalizaceUpdateForm form
    );
}
