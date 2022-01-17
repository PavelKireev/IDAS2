package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Ordinace;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface OrdinaceFormService {

    void create(@NotNull OrdinaceCreateForm form);

    @NotNull
    OrdinaceUpdateForm buildUpdateForm(Ordinace ordinace, OrdinaceUpdateForm form);
    void update(@NotNull OrdinaceUpdateForm form);

}
