package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceCreateForm;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface SpecializaceFormService {

    void create(@NotNull SpecializaceCreateForm form);

    @NotNull
    SpecializaceUpdateForm buildUpdateForm(@NotNull Specializace entity);

    void update(@NotNull SpecializaceUpdateForm form);

}
