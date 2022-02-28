package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.form.pojistovna.PojistovnaCreateForm;
import com.idas2.zdravotnisystem.form.pojistovna.PojistovnaUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface PojistovnaFormService {

    void create(@NotNull PojistovnaCreateForm form);

    @NotNull
    PojistovnaUpdateForm buildUpdateForm(@NotNull Pojistovna pojistovna);

    void update(@NotNull PojistovnaUpdateForm form);
}
