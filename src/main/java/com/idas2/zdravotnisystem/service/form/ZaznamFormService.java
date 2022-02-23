package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.ZaznamView;
import com.idas2.zdravotnisystem.form.hospitalizace.zaznam.ZaznamCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.zaznam.ZaznamUpdateForm;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface ZaznamFormService {

    void create(@NotNull ZaznamCreateForm form);

    @NotNull
    ZaznamUpdateForm buildUpdateForm(@NotNull ZaznamView view);

    void update(@NotNull ZaznamUpdateForm form);
}
