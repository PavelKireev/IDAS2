package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniCreateForm;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface ZarizeniFormService {

    void create(@NotNull ZarizeniCreateForm form);

    @NotNull
    ZarizeniUpdateForm buildUpdateForm(@NotNull ZarizeniView view);

    void update(@NotNull ZarizeniUpdateForm form);
}
