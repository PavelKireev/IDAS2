package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public @NotNull KancelarUpdateForm buildUpdateForm(
        @NotNull KancelarView view
    ) {
        return null;
    }

    @Override
    public void create(KancelarCreateForm form) {

        KancelarView view = new KancelarView();

        view
            .setNazev(form.getNazev())
            .setCislo(form.getCislo())
            .setPlocha(form.getPlocha())
            .setJeObsazena(Boolean.valueOf(form.getJeObsazena()));

//        kancelarRepository.saveFromView()
    }

    @Override
    public void update(KancelarUpdateForm form) {
        KancelarView view = new KancelarView();

        view
            .setId(form.getId())
            .setNazev(form.getNazev())
            .setCislo(form.getCislo())
            .setPlocha(form.getPlocha())
            .setJeObsazena(Boolean.valueOf(form.getJeObsazena()));

//        kancelarRepository.saveFromView()
    }
}
