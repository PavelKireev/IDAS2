package com.idas2.zdravotnisystem.validator.hospitalizace;

import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceCreateForm;
import com.idas2.zdravotnisystem.form.hospitalizace.HospitalizaceUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.util.Objects;

@Component
public class HospitalizaceCreateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return HospitalizaceUpdateForm.class.isAssignableFrom(clazz)
            || HospitalizaceView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull HospitalizaceCreateForm form = (HospitalizaceCreateForm) target;

        if (Objects.isNull(form.getDuvod()) || form.getDuvod().isEmpty())
            errors.rejectValue("duvod", "", "Duvod nesmi byt prazdny");

        if (Objects.isNull(form.getStavPacienta()) || form.getStavPacienta().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny!");

        if (Objects.isNull(form.getHospitalizaceOd()) || form.getHospitalizaceOd().isEmpty())
            errors.rejectValue("hospitalizaceOd", "", "Datum od nesmi byt prazdny");

        if (Objects.isNull(form.getHospitalizaceDo()) ||
            form.getHospitalizaceDo().isEmpty() ||
            Date.valueOf(form.getHospitalizaceDo()).before(Date.valueOf(form.getHospitalizaceOd())))
            errors.rejectValue("hospitalizaceDo", "", "Datum od nesmi byt pozdejsi nez datum do");
    }
}
