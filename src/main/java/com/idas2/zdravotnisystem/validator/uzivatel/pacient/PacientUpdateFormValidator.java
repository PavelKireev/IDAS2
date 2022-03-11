package com.idas2.zdravotnisystem.validator.uzivatel.pacient;

import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.PacientUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientCreateForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

@Component
public class PacientUpdateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PacientCreateForm.class.isAssignableFrom(clazz)
            || PacientView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PacientUpdateForm form = (PacientUpdateForm) target;

        if(Objects.isNull(form.getDatumNarozeni()) ||
            !Date.valueOf(form.getDatumNarozeni()).after(Date.valueOf(LocalDate.now()))
        ) errors.rejectValue("hesloPotvrzeni", "","Datum Narozeni nesmi byt prazdny, nebo budouci!");

        if(Objects.nonNull(form.getEmail()) && (
            !Pattern
                .compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
                .matcher(form.getEmail()).matches() || form.getEmail().isEmpty())
        ) errors.rejectValue("email", "", "Nespravny format!");

        if(Objects.nonNull(form.getJmeno()) && form.getJmeno().isEmpty())
            errors.rejectValue("jmeno", "", "Jmeno nesmi byt prazdne!");

        if(Objects.nonNull(form.getPrijmeni()) && form.getPrijmeni().isEmpty())
            errors.rejectValue("prijmeni", "", "Prijmeni nesmi byt prazdne!");

        if(Objects.nonNull(form.getTelCislo()) && form.getTelCislo().isEmpty())
            errors.rejectValue("telCislo", "", "Telefonni cislo nesmi byt prazdne!");

        if(Objects.nonNull(form.getRust()) && form.getRust() < 1)
            errors.rejectValue("rust", "", "Rust nesmi byt zaporny!");

        if(Objects.nonNull(form.getHmotnost()) && form.getHmotnost() < 1)
            errors.rejectValue("hmotnost", "", "Hmotnost nesmi byt zaporna!");
    }
}
