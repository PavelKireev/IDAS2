package com.idas2.zdravotnisystem.validator.specializace;

import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class SpecializaceUpdateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SpecializaceUpdateForm.class.isAssignableFrom(clazz)
            || Specializace.class.isAssignableFrom(clazz);    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull SpecializaceUpdateForm form = (SpecializaceUpdateForm) target;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny");

        if (Objects.nonNull(form.getPopis()) && form.getNazev().length() > 25)
            errors.rejectValue("nazev", "", "Prilis dlouhy nazev");

        if (Objects.nonNull(form.getPopis()) && form.getPopis().length() > 50)
            errors.rejectValue("popis", "", "Prilis dlouhy popis");
    }
}
