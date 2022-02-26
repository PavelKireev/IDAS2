package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.form.procedura.ProceduraCreateForm;
import com.idas2.zdravotnisystem.form.procedura.ProceduraUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface ProceduraFormService {

    @NotNull
    ProceduraUpdateForm buildUpdateForm(@NotNull ProceduraView view);

    void create(@NotNull ProceduraCreateForm form);

    void createAdmin(@NotNull ProceduraCreateForm form);

    void update(@NotNull ProceduraUpdateForm form);
}
