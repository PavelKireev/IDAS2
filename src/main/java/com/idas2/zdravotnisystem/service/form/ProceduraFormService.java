package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.form.ProceduraCreateForm;
import org.jetbrains.annotations.NotNull;

public interface ProceduraFormService {

    void create(@NotNull ProceduraCreateForm form);

}
