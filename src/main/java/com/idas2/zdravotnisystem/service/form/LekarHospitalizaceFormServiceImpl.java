package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.ZaznamRepository;
import com.idas2.zdravotnisystem.db.view.ZaznamView;
import com.idas2.zdravotnisystem.form.lekar.LekarZaznamForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class LekarHospitalizaceFormServiceImpl implements LekarHospitalizaceFormService {

    private final ZaznamRepository zaznamRepository;

    @Autowired
    public LekarHospitalizaceFormServiceImpl(
        ZaznamRepository zaznamRepository
    ) {
        this.zaznamRepository = zaznamRepository;
    }


    @Override
    public void createZaznam(LekarZaznamForm lekarZaznamForm) {

        ZaznamView view = new ZaznamView();

        view
            .setTitul(lekarZaznamForm.getTitul())
            .setText(lekarZaznamForm.getText())
            .setDatumVytvareni(Date.valueOf(LocalDate.now()))
            .setLekarUzivatelIdUzivatel(lekarZaznamForm.getIdLekar())
            .setHospitalizaceIdHospitalizace(lekarZaznamForm.getIdHospitalizace());

        zaznamRepository.saveFromView(view);
    }
}
