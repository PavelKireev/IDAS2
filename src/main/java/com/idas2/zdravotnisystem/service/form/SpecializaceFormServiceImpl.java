package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.db.repository.SpecializaceRepository;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceCreateForm;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializaceFormServiceImpl implements SpecializaceFormService {

    private final SpecializaceRepository repository;

    @Autowired
    public SpecializaceFormServiceImpl(
        SpecializaceRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public void create(@NotNull SpecializaceCreateForm form) {
        Specializace entity = new Specializace();

        entity
            .setNazev(form.getNazev())
            .setPopis(form.getPopis());

        repository.save(entity);
    }

    @Override
    public @NotNull SpecializaceUpdateForm buildUpdateForm(@NotNull Specializace entity) {

        return new SpecializaceUpdateForm()
            .setId(entity.getId())
            .setNazev(entity.getNazev())
            .setPopis(entity.getPopis());
    }

    @Override
    public void update(@NotNull SpecializaceUpdateForm form) {

        Specializace entity = new Specializace();

        entity
            .setNazev(form.getNazev())
            .setPopis(form.getPopis())
            .setId(form.getId());

        repository.save(entity);
    }
}
