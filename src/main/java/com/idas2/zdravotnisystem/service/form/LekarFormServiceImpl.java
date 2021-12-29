package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.LekarProfileUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LekarFormServiceImpl implements LekarFormService {

    private final LekarRepository lekarRepository;

    @Autowired
    public LekarFormServiceImpl(
        LekarRepository lekarRepository
    ) {
        this.lekarRepository = lekarRepository;
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
}
