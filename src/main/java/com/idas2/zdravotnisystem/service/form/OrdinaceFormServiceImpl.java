package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Ordinace;
import com.idas2.zdravotnisystem.db.repository.OrdinaceRepository;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdinaceFormServiceImpl implements OrdinaceFormService {

    private final OrdinaceRepository repository;

    @Autowired
    public OrdinaceFormServiceImpl(
        OrdinaceRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public void create(
        @NotNull OrdinaceCreateForm form
    ) {

    }

    @Override
    public @NotNull OrdinaceUpdateForm buildUpdateForm(
        @NotNull Ordinace ordinace,
        @NotNull OrdinaceUpdateForm form
    ) {
        return form
            .setId(ordinace.getId())
            .setNazev(form.getNazev())
            .setCislo(form.getCislo())
            .setPlocha(form.getPlocha())
            .setJeVProvozu(form.getJeVProvozu());
    }

    @Override
    public void update(@NotNull OrdinaceUpdateForm form) {

    }
}
