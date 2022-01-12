package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.pacient.PacientInfoForm;
import com.idas2.zdravotnisystem.form.pacient.PacientSignUpForm;
import com.idas2.zdravotnisystem.util.TimeUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class PacientFormServiceImpl implements PacientFormService {

    private final PasswordEncoder encoder;
    private final PacientRepository pacientRepository;
    private final UzivatelRepository uzivatelRepository;

    @Autowired
    public PacientFormServiceImpl(
        PasswordEncoder encoder,
        PacientRepository pacientRepository,
        UzivatelRepository uzivatelRepository
    ) {
        this.encoder = encoder;
        this.pacientRepository = pacientRepository;
        this.uzivatelRepository = uzivatelRepository;
    }


    @NotNull
    @Override
    public PacientInfoForm buildInfoFormFromView(
        @NotNull PacientInfoForm target,
        @NotNull PacientView source
    ) {
        return target
            .setAdresa(source.getAdresa())
            .setTelCislo(source.getTelCislo());
    }

    @Override
    public @NotNull PacientInfoForm buildInfoFormFromView(
        @NotNull PacientView source
    ) {
        return buildInfoFormFromView(new PacientInfoForm(), source);
    }

    @Override
    public void updateProfileInfo(
        @NotNull String userUuid,
        @NotNull PacientInfoForm form
    ) {
        User user =
            uzivatelRepository.findByUuid(userUuid)
                .setAdresa(form.getAdresa())
                .setTelCislo(form.getTelCislo());

        uzivatelRepository.update(user);
    }


    @Override
    public void updateInfoPaient(
        @NotNull Integer pacientId,
        @NotNull PacientInfoForm pacientInfoForm
    ) {
        PacientView view =
            pacientRepository.getPacientViewByUzivatelId(pacientId);

        view
            .setAdresa(pacientInfoForm.getAdresa())
            .setTelCislo(pacientInfoForm.getTelCislo());

        pacientRepository.updateByView(view);
    }

    @Override
    public void signUp(
        @NotNull PacientSignUpForm form
    ) {
        PacientView view = new PacientView();

        view
            .setEmail(form.getEmail())
            .setPassword(encoder.encode(form.getHeslo()))
            .setJmeno(form.getJmeno())
            .setPrijmeni(form.getPrijmeni())
            .setTelCislo(form.getTelCislo())
            .setAdresa(form.getAdresa())
            .setHmotnost(form.getHmotnost())
            .setRust(form.getRust())
            .setDatumNarozeni(
                Date.valueOf(
                    TimeUtil.fromStringSqlLocalDate(form.getDatumNarozeni())
                )
            );

        pacientRepository.updateByView(view);
    }


}
