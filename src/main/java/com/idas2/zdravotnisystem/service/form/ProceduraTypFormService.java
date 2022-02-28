package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.form.procedura.typ.ProceduraTypCreateForm;
import com.idas2.zdravotnisystem.form.procedura.typ.ProceduraTypUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface ProceduraTypFormService {
    @NotNull
    ProceduraTypUpdateForm buildUpdateForm(@NotNull TypProcedury proceduraTyp);

    void create(@NotNull ProceduraTypCreateForm form);

    void update(@NotNull ProceduraTypUpdateForm form);
}
