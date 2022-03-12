package com.idas2.zdravotnisystem.validator.zarizeni.typ;

import com.idas2.zdravotnisystem.db.entity.TypZarizeni;
import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import com.idas2.zdravotnisystem.form.zarizeni.TypZarizeniCreateForm;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniCreateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Component
public class TypZarizeniCreateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TypZarizeniCreateForm.class.isAssignableFrom(clazz)
            || TypZarizeni.class.isAssignableFrom(clazz);    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull TypZarizeniCreateForm form = (TypZarizeniCreateForm) target;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny!");

        if (Objects.isNull(form.getPopis()) || form.getPopis().isEmpty())
            errors.rejectValue("popis", "", "Popis nesmi byt prazdny!");

        if (Objects.isNull(form.getCilenePouziti()) || form.getCilenePouziti().isEmpty())
            errors.rejectValue("cilenePouziti", "", "Cilene pouziti nesmi byt prazdne!");
    }

}
