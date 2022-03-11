package com.idas2.zdravotnisystem.validator.uzivatel.pacient;

import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientInfoForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class PacientInfoFormVaidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return PacientInfoForm.class.isAssignableFrom(clazz)
            || PacientView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PacientInfoForm form = (PacientInfoForm) target;

        if(Objects.nonNull(form.getTelCislo()) && form.getTelCislo().isEmpty())
            errors.rejectValue("telCislo", "", "Telefonni cislo nesmi byt prazdne!");


        if(Objects.nonNull(form.getAdresa()) && form.getAdresa().length() > 100)
            errors.rejectValue("telCislo", "", "Prilis dlouha adresa!");

    }
}
