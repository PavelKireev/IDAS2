package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.AdministratorRepository;
import com.idas2.zdravotnisystem.db.view.AdministratorView;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminFormServiceImpl implements AdminFormService {

    private final PasswordEncoder passwordEncoder;
    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdminFormServiceImpl(
        PasswordEncoder passwordEncoder,
        AdministratorRepository administratorRepository
    ) {
        this.passwordEncoder = passwordEncoder;
        this.administratorRepository = administratorRepository;
    }

    @Override
    public void save(@NotNull AdminCreateForm form) {

        AdministratorView view = new AdministratorView();

        view
            .setEmail(form.getEmail())
            .setJmeno(form.getJmeno())
            .setPrijmeni(form.getPrijmeni())
            .setHeslo(passwordEncoder.encode(form.getHeslo()))
            .setTelCislo(form.getTelCislo());

        administratorRepository.saveFromView(view);
    }

    @Override
    public void update(@NotNull AdminUpdateForm form) {

        AdministratorView view = administratorRepository.findById(form.getId());

        view
            .setEmail(form.getEmail())
            .setJmeno(form.getJmeno())
            .setPrijmeni(form.getPrijmeni())
            .setTelCislo(form.getTelCislo());

        administratorRepository.saveFromView(view);
    }

    @Override
    public @NotNull AdminCreateForm buildCreateForm(
    ) {
        return new AdminCreateForm();
    }

    @Override
    public @NotNull AdminUpdateForm buildUpdateForm(
        @NotNull AdministratorView view
    ) {
        AdminUpdateForm form = new AdminUpdateForm();

        form
            .setId(view.getId())
            .setJmeno(view.getJmeno())
            .setPrijmeni(view.getPrijmeni())
            .setEmail(view.getEmail())
            .setTelCislo(view.getTelCislo());

        return form;
    }
}
