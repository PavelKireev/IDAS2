package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class KancelarFormServiceImpl implements KancelarFormService {

    private final KancelarRepository kancelarRepository;

    public KancelarFormServiceImpl(
        KancelarRepository kancelarRepository
    ) {
        this.kancelarRepository = kancelarRepository;
    }


    @Override
    public @NotNull KancelarCreateForm buildCreateForm() {
        return new KancelarCreateForm();
    }

    @Override
    public @NotNull KancelarUpdateForm buildUpdateForm(
        @NotNull KancelarView view
    ) {
        KancelarUpdateForm form = new KancelarUpdateForm();

        form
            .setId(view.getId())
            .setNazev(view.getNazev())
            .setCislo(view.getCislo())
            .setPlocha(view.getPlocha())
            .setJeObsazena(view.getJeObsazena());

        return form;
    }

    @Override
    public void create(KancelarCreateForm form) {

        KancelarView view = new KancelarView();

        Boolean obsazena =
            Objects.nonNull(form.getJeObsazena()) && form.getJeObsazena().equals("on");
        
        view
            .setNazev(form.getNazev())
            .setCislo(form.getCislo())
            .setPlocha(form.getPlocha())
            .setJeObsazena(obsazena);

        kancelarRepository.saveFromView(view);
    }

    @Override
    public void update(KancelarUpdateForm form) {
        KancelarView view = new KancelarView();

        view
            .setId(form.getId())
            .setNazev(form.getNazev())
            .setCislo(form.getCislo())
            .setPlocha(form.getPlocha())
            .setJeObsazena(form.getJeObsazena());

        kancelarRepository.saveFromView(view);
    }
}
