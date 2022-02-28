package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Objects;

@Service
public class HospitalizaceFormServiceImpl
    implements HospitalizaceFormService {

    private final HospitalizaceRepository hospitalizaceRepository;

    @Autowired
    public HospitalizaceFormServiceImpl(
        HospitalizaceRepository hospitalizaceRepository
    ) {
        this.hospitalizaceRepository = hospitalizaceRepository;
    }

    @Override
    public @NotNull HospitalizaceUpdateForm buildUpdateForm(
        @NotNull HospitalizaceView view
    ) {

        HospitalizaceUpdateForm form = new HospitalizaceUpdateForm();

        form
            .setDuvod(view.getDuvod())
            .setStavPacienta(view.getStavPacienta())
            .setPacientUzivatelIdUzivatel(view.getPacientId());

        if(Objects.nonNull(view.getHospitalizaceOd()))
            form.setHospitalizaceOd(view.getHospitalizaceOd().toString());

        if(Objects.nonNull(view.getHospitalizaceDo()))
            form.setHospitalizaceDo(view.getHospitalizaceDo().toString());

        return form;
    }

    @Override
    public void create(
        @NotNull HospitalizaceCreateForm form
    ) {
        Hospitalizace hospitalizace = new Hospitalizace();

        hospitalizace
            .setDuvod(form.getDuvod())
            .setStavPacienta(form.getStavPacienta())
            .setHospitalizaceOd(Date.valueOf(form.getHospitalizaceOd()))
            .setHospitalizaceDo(Date.valueOf(form.getHospitalizaceDo()))
            .setPacientUzivatelIdUzivatel(form.getPacientUzivatelIdUzivatel());

        hospitalizaceRepository.saveFromEntity(hospitalizace);
    }

    @Override
    public void update(
        @NotNull HospitalizaceUpdateForm form
    ) {
        Hospitalizace hospitalizace = new Hospitalizace();

        hospitalizace
            .setDuvod(form.getDuvod())
            .setStavPacienta(form.getStavPacienta())
            .setPacientUzivatelIdUzivatel(form.getPacientUzivatelIdUzivatel())
            .setId(form.getId());

        if(Objects.nonNull(form.getHospitalizaceOd()) &&
            !form.getHospitalizaceOd().isEmpty())
            hospitalizace.setHospitalizaceOd(
                Date.valueOf(form.getHospitalizaceOd())
            );

        if(Objects.nonNull(form.getHospitalizaceDo()) &&
            !form.getHospitalizaceDo().isEmpty())
            hospitalizace.setHospitalizaceDo(
                Date.valueOf(form.getHospitalizaceDo())
            );

        hospitalizaceRepository.saveFromEntity(hospitalizace);
    }
}
