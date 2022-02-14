package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface PokojFormService {

    void create(@NotNull PokojCreateForm form);

    @NotNull
    PokojUpdateForm buildUpdateForm(@NotNull NemocnicniPokojView view);

    void update(@NotNull PokojUpdateForm form);

}
