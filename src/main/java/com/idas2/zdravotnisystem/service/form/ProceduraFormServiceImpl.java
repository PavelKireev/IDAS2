package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.ProceduraRepository;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.form.procedura.ProceduraCreateForm;
import com.idas2.zdravotnisystem.form.procedura.ProceduraUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
    public @NotNull ProceduraUpdateForm buildUpdateForm(
        @NotNull ProceduraView view
    ) {
        ProceduraUpdateForm form = new ProceduraUpdateForm();

        form.setPopis(view.getPopis());

        if(Objects.nonNull(view.getDatum()))
            form.setDatum(view.getDatum().toLocalDate().toString());

        if(Objects.nonNull(view.getIdTypProcedury()))
            form.setIdTypProcedury(view.getIdTypProcedury().toString());

        if(Objects.nonNull(view.getIdZarizeni()))
            form.setIdZarizeni(view.getIdZarizeni().toString());

        if(Objects.nonNull(view.getIdLekar()))
            form.setIdLekar(view.getIdLekar().toString());

        if(Objects.nonNull(view.getIdHospitalizace()))
            form.setIdHospitalizace(view.getIdHospitalizace().toString());

        return form;
    }

    @Override
    public void create(@NotNull ProceduraCreateForm form) {

        ProceduraView view = new ProceduraView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthUser authUser = ((AuthUser) authentication.getPrincipal());

        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(form.getDatum(), DATEFORMATTER);

        view
            .setDatum(Date.valueOf(ld))
            .setPopis(form.getPopis())
            .setIdTypProcedury(Integer.valueOf(form.getIdTypProcedury()))
            .setIdZarizeni(Integer.valueOf(form.getIdZarizeni()))
            .setIdHospitalizace(Integer.valueOf(form.getIdHospitalizace()))
            .setIdLekar(authUser.getUser().getId());

        proceduraRepository.saveFromView(view);
    }

    @Override
    public void createAdmin(@NotNull ProceduraCreateForm form) {

        ProceduraView view = new ProceduraView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(form.getDatum(), DATEFORMATTER);

        view
            .setDatum(Date.valueOf(ld))
            .setPopis(form.getPopis())
            .setIdTypProcedury(Integer.valueOf(form.getIdTypProcedury()))
            .setIdZarizeni(Integer.valueOf(form.getIdZarizeni()))
            .setIdHospitalizace(Integer.valueOf(form.getIdHospitalizace()))
            .setIdLekar(Integer.valueOf(form.getIdLekar()));

        proceduraRepository.saveFromView(view);
    }

    @Override
    public void update(@NotNull ProceduraUpdateForm form) {

        ProceduraView view = new ProceduraView();

        view
            .setPopis(form.getPopis())
            .setIdProcedura(Integer.valueOf(form.getIdTypProcedury()))
            .setIdTypZarizeni(Integer.valueOf(form.getIdZarizeni()))
            .setIdTypProcedury(Integer.valueOf(form.getIdTypProcedury()))
            .setIdHospitalizace(Integer.valueOf(form.getIdHospitalizace()))
            .setIdLekar(Integer.valueOf(form.getIdTypProcedury()));

        proceduraRepository.saveFromView(view);
    }

}
