package com.idas2.zdravotnisystem.validator.specializace;

import com.idas2.zdravotnisystem.db.entity.Specializace;
import com.idas2.zdravotnisystem.form.specializace.SpecializaceCreateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class SpecializaceCreateFormValidator implements Validator {

    @Override
    public boolean supports(@NotNull Class<?> aClass) {
        return SpecializaceCreateForm.class.isAssignableFrom(aClass)
            || Specializace.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@NotNull Object o, @NotNull Errors errors) {
        @NotNull SpecializaceCreateForm form = (SpecializaceCreateForm) o;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny");

        if (Objects.nonNull(form.getPopis()) && form.getNazev().length() > 25)
            errors.rejectValue("nazev", "", "Prilis dlouhy nazev");

        if (Objects.nonNull(form.getPopis()) && form.getPopis().length() > 50)
            errors.rejectValue("popis", "", "Prilis dlouhy popis");

    }
}
