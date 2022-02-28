package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.db.repository.PojistovnaRepository;
import com.idas2.zdravotnisystem.form.pojistovna.PojistovnaCreateForm;
import com.idas2.zdravotnisystem.form.pojistovna.PojistovnaUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PojistovnaFormServiceImpl implements PojistovnaFormService {

    private final PojistovnaRepository pojistovnaRepository;

    @Autowired
    public PojistovnaFormServiceImpl(
        PojistovnaRepository pojistovnaRepository
    ) {
        this.pojistovnaRepository = pojistovnaRepository;
    }


    @Override
    public void create(@NotNull PojistovnaCreateForm form) {

        Pojistovna pojistovna = new Pojistovna();

        pojistovna
            .setNazev(form.getNazev())
            .setAdresa(form.getAdresa())
            .setTelCislo(form.getTelCislo());

        pojistovnaRepository.save(pojistovna);
    }

    @Override
    public @NotNull PojistovnaUpdateForm buildUpdateForm(@NotNull Pojistovna pojistovna) {

        PojistovnaUpdateForm form = new PojistovnaUpdateForm();

        form
            .setId(pojistovna.getId())
            .setNazev(pojistovna.getNazev())
            .setAdresa(pojistovna.getAdresa())
            .setTelCislo(pojistovna.getTelCislo());

        return form;
    }

    @Override
    public void update(@NotNull PojistovnaUpdateForm form) {
        Pojistovna pojistovna = new Pojistovna();

        pojistovna
            .setNazev(form.getNazev())
            .setAdresa(form.getAdresa())
            .setTelCislo(form.getTelCislo())
            .setId(form.getId());

        pojistovnaRepository.save(pojistovna);
    }
}
