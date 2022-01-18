package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarProfileUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LekarFormServiceImpl implements LekarFormService {

    private final LekarRepository lekarRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LekarFormServiceImpl(
        LekarRepository lekarRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.lekarRepository = lekarRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void update(
        @NotNull LekarProfileUpdateForm source,
        @NotNull Integer target
    ) {
        LekarView view =
            lekarRepository.getViewById(target);

        view.setTelCislo(source.getTelCislo());

        lekarRepository.updateInfoByView(view);

    }

    @Override
    public void update(@NotNull LekarUpdateForm form) {

        LekarView view =
            lekarRepository.getViewById(form.getId());

        view
            .setEmail(form.getEmail())
            .setJmeno(form.getJmeno())
            .setPrijmeni(form.getPrijmeni())
            .setTelCislo(form.getTelCislo())
            .setPlat(form.getPlat())
            .setObrazek(form.getObrazek())
            .setObrazekNazev(form.getNazev())
            .setObrazekPripona(form.getPripona())
            .setIdKancelar(form.getIdKancelar())
            .setIdSpecializace(form.getIdSpecializace());
    }

    @Override
    public @NotNull LekarProfileUpdateForm buildInfoFormFromView(
        @NotNull LekarView lekarView
    ) {
        return new LekarProfileUpdateForm()
            .setTelCislo(lekarView.getTelCislo());
    }

    @Override
    public @NotNull LekarUpdateForm buildUpdateForm(@NotNull LekarView view) {

        LekarUpdateForm form = new LekarUpdateForm();

        return form
            .setEmail(view.getEmail())
            .setJmeno(view.getJmeno())
            .setPrijmeni(view.getPrijmeni())
            .setTelCislo(view.getTelCislo())
            .setPlat(view.getPlat())
            .setObrazek(view.getObrazek())
            .setNazev(view.getObrazekNazev())
            .setPripona(view.getObrazekPripona())
            .setIdKancelar(view.getIdKancelar())
            .setIdSpecializace(view.getIdSpecializace());
    }

    @Override
    public void save(
        @NotNull LekarCreateForm form
    ) {
        LekarView view = new LekarView();

        view
            .setEmail(form.getEmail())
            .setHeslo(passwordEncoder.encode(form.getHeslo()))
            .setJmeno(form.getJmeno())
            .setPrijmeni(form.getPrijmeni())
            .setTelCislo(form.getTelCislo())
            .setPlat(form.getPlat())
            .setIdKancelar(form.getIdKancelar())
            .setIdSpecializace(form.getIdSpecializace());

        lekarRepository.updateInfoByView(view);
    }
}
