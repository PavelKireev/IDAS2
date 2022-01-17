package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

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
            .setHospitalizaceOd(Date.valueOf(form.getHospitalizaceOd()))
            .setHospitalizaceDo(Date.valueOf(form.getHospitalizaceDo()))
            .setPacientUzivatelIdUzivatel(form.getPacientUzivatelIdUzivatel())
            .setId(form.getId());

        hospitalizaceRepository.saveFromEntity(hospitalizace);
    }
}
