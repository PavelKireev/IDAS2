package com.idas2.zdravotnisystem.validator.pojistovna;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;
import com.idas2.zdravotnisystem.form.pojistovna.PojistovnaUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class PojistovnaUpdateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PojistovnaUpdateForm.class.isAssignableFrom(clazz)
            || Pojistovna.class.isAssignableFrom(clazz);    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull PojistovnaUpdateForm form = (PojistovnaUpdateForm) target;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny");

        if (Objects.nonNull(form.getAdresa()) && form.getAdresa().length() > 50)
            errors.rejectValue("adresa", "", "Prilis dlouha adresa");

        if (Objects.nonNull(form.getTelCislo()) && form.getTelCislo().length() > 15)
            errors.rejectValue("telCislo", "", "Prilis dlouhe telefonni cislo");
    }
}
