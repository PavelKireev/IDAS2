package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarProfileUpdateForm;
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
    public @NotNull LekarProfileUpdateForm buildInfoFormFromView(
        @NotNull LekarView lekarView
    ) {
        return new LekarProfileUpdateForm()
            .setTelCislo(lekarView.getTelCislo());
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
