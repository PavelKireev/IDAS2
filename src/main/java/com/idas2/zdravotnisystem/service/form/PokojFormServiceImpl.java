package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.NemocnicniPokojRepository;
import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokojFormServiceImpl implements PokojFormService {

    private final NemocnicniPokojRepository repository;

    @Autowired
    public PokojFormServiceImpl(
        NemocnicniPokojRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public void create(@NotNull PokojCreateForm form) {

        NemocnicniPokojView view = new NemocnicniPokojView();

        view
            .setNazev(form.getNazev())
            .setCislo(Integer.valueOf(form.getCislo()))
            .setPlocha(form.getPlocha())
            .setKapacita(form.getKapacita())
            .setPocetPacientu(form.getPocetPacientu());

        repository.saveFromView(view);
    }

    @Override
    public @NotNull PokojUpdateForm buildUpdateForm(
        @NotNull NemocnicniPokojView view
    ) {
        PokojUpdateForm form = new PokojUpdateForm();

        form
            .setNazev(view.getNazev())
            .setCislo(view.getCislo().toString())
            .setPlocha(view.getPlocha())
            .setKapacita(view.getKapacita())
            .setPocetPacientu(view.getPocetPacientu())
            .setId(view.getId());

        return form;
    }

    @Override
    public void update(@NotNull PokojUpdateForm form) {

        NemocnicniPokojView view = repository.findById(form.getId());

        view
            .setNazev(form.getNazev())
            .setCislo(Integer.valueOf(form.getCislo()))
            .setPlocha(form.getPlocha())
            .setKapacita(form.getKapacita())
            .setPocetPacientu(form.getPocetPacientu());

        repository.saveFromView(view);
    }
}
