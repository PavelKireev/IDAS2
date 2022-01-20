package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.KancelarView;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarUpdateForm;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface KancelarFormService {

    @NotNull
    KancelarCreateForm buildCreateForm();

    @NotNull
    KancelarUpdateForm buildUpdateForm(
        @NotNull KancelarView view
    );

    void create(KancelarCreateForm form);
    void update(KancelarUpdateForm form);

}
