package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.ZaznamRepository;
import com.idas2.zdravotnisystem.db.view.ZaznamView;
import com.idas2.zdravotnisystem.form.hospitalizace.zaznam.ZaznamCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.zaznam.ZaznamUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZaznamFormServiceImpl implements ZaznamFormService {

    private final ZaznamRepository repository;

    @Autowired
    public ZaznamFormServiceImpl(
        ZaznamRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public void create(@NotNull ZaznamCreateForm form) {

        ZaznamView view = new ZaznamView();

        view
            .setTitul(form.getTitul())
            .setText(form.getText())
            .setHospitalizaceIdHospitalizace(form.getIdHospitalizace())
            .setLekarUzivatelIdUzivatel(form.getIdLekar());

        repository.saveFromView(view);
    }

    @Override
    public @NotNull ZaznamUpdateForm buildUpdateForm(@NotNull ZaznamView view) {
        ZaznamUpdateForm form = new ZaznamUpdateForm();

        form
            .setId(view.getId())
            .setTitul(view.getTitul())
            .setText(view.getText())
            .setIdHospitalizace(view.getHospitalizaceIdHospitalizace())
            .setIdLekar(view.getLekarUzivatelIdUzivatel())
            .setDatumVytvareni(view.getDatumVytvareni().toLocalDate());

        return form;
    }

    @Override
    public void update(@NotNull ZaznamUpdateForm form) {

        ZaznamView view = repository.findById(form.getId());

        view
            .setId(form.getId())
            .setTitul(form.getTitul())
            .setText(form.getTitul())
            .setHospitalizaceIdHospitalizace(form.getIdHospitalizace())
            .setLekarUzivatelIdUzivatel(form.getIdLekar());

        repository.saveFromView(view);
    }
}
