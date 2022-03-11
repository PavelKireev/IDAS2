package com.idas2.zdravotnisystem.validator.uzivatel.lekar;

import com.idas2.zdravotnisystem.db.entity.ZdravotniKarta;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarZdravortniKartaForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.util.Objects;

@Component
public class LekarZdravotniKartaFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LekarZdravortniKartaForm.class.isAssignableFrom(clazz)
            || ZdravotniKarta.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull LekarZdravortniKartaForm form = (LekarZdravortniKartaForm) target;

        if (Objects.isNull(form.getKartaOd()) || form.getKartaOd().isEmpty())
            errors.rejectValue("kartaOd", "", "Datum od nesmi byt prazdny");

        if (Objects.isNull(form.getKartaDo()) ||
            form.getKartaDo().isEmpty() ||
            Date.valueOf(form.getKartaDo()).before(Date.valueOf(form.getKartaOd())))
            errors.rejectValue("kartaDo", "", "Datum do nesmi byt pozdeji nez datum od");
    }
}
