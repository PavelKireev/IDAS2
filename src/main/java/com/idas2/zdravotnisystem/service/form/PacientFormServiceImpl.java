package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.PacientInfoForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacientFormServiceImpl implements PacientFormService {

    private final PacientRepository pacientRepository;
    private final UzivatelRepository uzivatelRepository;

    @Autowired
    public PacientFormServiceImpl(
        PacientRepository pacientRepository,
        UzivatelRepository uzivatelRepository
    ) {
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

        pacientRepository.updateInfoByView(view);
    }


}
