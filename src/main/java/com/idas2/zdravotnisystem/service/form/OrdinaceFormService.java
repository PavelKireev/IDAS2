package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.OrdinaceView;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface OrdinaceFormService {

    void create(@NotNull OrdinaceCreateForm form);

    @NotNull
    OrdinaceUpdateForm buildUpdateForm(@NotNull OrdinaceView view);

    void update(@NotNull OrdinaceUpdateForm form);

}
