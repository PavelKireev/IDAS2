package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.db.repository.TypProceduryRepository;
import com.idas2.zdravotnisystem.form.procedura.typ.ProceduraTypCreateForm;
import com.idas2.zdravotnisystem.form.procedura.typ.ProceduraTypUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class ProceduraTypFormServiceImpl implements ProceduraTypFormService {

    private final TypProceduryRepository repository;

    @Autowired
    public ProceduraTypFormServiceImpl(
        TypProceduryRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public @NotNull ProceduraTypUpdateForm buildUpdateForm(
        @NotNull TypProcedury proceduraTyp
    ) {
        ProceduraTypUpdateForm form = new ProceduraTypUpdateForm();

        form
            .setNazev(proceduraTyp.getNazev())
            .setPopis(proceduraTyp.getPopis());

        return form;
    }

    @Override
    public void create(
        @NotNull ProceduraTypCreateForm form
    ) {
        TypProcedury typProcedury = new TypProcedury();

        typProcedury
            .setNazev(form.getNazev())
            .setPopis(form.getPopis());

        repository.save(typProcedury);
    }

    @Override
    public void update(@NotNull ProceduraTypUpdateForm form) {
        TypProcedury typProcedury = new TypProcedury();

        typProcedury
            .setNazev(form.getNazev())
            .setPopis(form.getPopis());

        repository.save(typProcedury);
    }
}
