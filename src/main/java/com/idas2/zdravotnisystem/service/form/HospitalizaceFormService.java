package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface HospitalizaceFormService {

    void create(
        @NotNull HospitalizaceCreateForm form
    );

    void update(
        @NotNull HospitalizaceUpdateForm form
    );
}
