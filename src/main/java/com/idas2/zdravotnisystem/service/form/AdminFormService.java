package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.AdministratorView;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface AdminFormService {

    void save(@NotNull AdminCreateForm form);
    void update(@NotNull AdminUpdateForm form);

    @NotNull AdminCreateForm buildCreateForm(
    );

    @NotNull
    AdminUpdateForm buildUpdateForm(@NotNull AdministratorView view);
}
