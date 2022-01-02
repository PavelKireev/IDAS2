package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.ProceduraRepository;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.form.ProceduraCreateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ProceduraFormServiceImpl implements ProceduraFormService {

    private final ProceduraRepository proceduraRepository;

    @Autowired
    public ProceduraFormServiceImpl(
        ProceduraRepository proceduraRepository
    ) {
        this.proceduraRepository = proceduraRepository;
    }

    @Override
    public void create(@NotNull ProceduraCreateForm form) {

        ProceduraView view = new ProceduraView();

        view
            .setDatum(Date.valueOf(form.getDatum()))
            .setPopis(form.getPopis())
            .setIdTypProcedury(form.getIdTypProcedury())
            .setIdTypZarizeni(form.getIdTypZarizeni())
            .setIdHospitalizace(form.getHospitalizace())
            .setIdLekar(form.getIdLekar());

        proceduraRepository.saveFromView(view);
    }

}
