package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Ordinace;
import com.idas2.zdravotnisystem.db.repository.OrdinaceRepository;
import com.idas2.zdravotnisystem.db.view.OrdinaceView;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
        @NotNull OrdinaceView view
    ) {
        OrdinaceUpdateForm form = new OrdinaceUpdateForm();

        form
            .setNazev(view.getNazev())
            .setCislo(view.getCislo().toString())
            .setPlocha(view.getPlocha().toString())
            .setJeVProvozu(view.getJeVProvozu())
            .setId(view.getId());

        return form;
    }

    @Override
    public void update(@NotNull OrdinaceUpdateForm form) {

        OrdinaceView view = repository.findById(form.getId());

        view
            .setNazev(form.getNazev())
            .setCislo(Integer.valueOf(form.getCislo()))
            .setPlocha(Integer.valueOf(form.getPlocha()))
            .setJeVProvozu(Boolean.valueOf(form.getJeVProvozu()));

        repository.saveFromView(view);
    }
}
