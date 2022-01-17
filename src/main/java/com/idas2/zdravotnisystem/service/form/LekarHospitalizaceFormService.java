package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarZaznamForm;

public interface LekarHospitalizaceFormService {

//    void createHospitalizace(
//        @NotNull LekarHospitalizaceCreateForm hospitalizaceView
//    );

    void createZaznam(
        LekarZaznamForm lekarZaznamForm
    );
}
