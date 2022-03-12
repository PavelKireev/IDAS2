package com.idas2.zdravotnisystem.validator.zarizeni;

import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceUpdateForm;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Component
public class ZarizeniUpdateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ZarizeniUpdateForm.class.isAssignableFrom(clazz)
            || ZarizeniView.class.isAssignableFrom(clazz);    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull ZarizeniUpdateForm form = (ZarizeniUpdateForm) target;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny!");

        if (Objects.isNull(form.getDatumVyroby()) || form.getDatumVyroby().isEmpty())
            errors.rejectValue("datumVyroby", "", "Datum vyroby nesmi byt prazdny!");

        if (Objects.isNull(Date.valueOf(form.getDatumVyroby()).after(Date.valueOf(LocalDate.now()))))
            errors.rejectValue("datumVyroby", "", "Datum vyroby nesmi byt v budoucu!");

        if (Objects.isNull(form.getZnacka()) || form.getZnacka().isEmpty())
            errors.rejectValue("znacka", "", "Znacka nesmi byt prazdna!");

        if (Objects.nonNull(form.getZnacka()) && form.getZnacka().length() > 50)
            errors.rejectValue("znacka", "", "Prilis dlouhy nazev znacky!");
    }
}
