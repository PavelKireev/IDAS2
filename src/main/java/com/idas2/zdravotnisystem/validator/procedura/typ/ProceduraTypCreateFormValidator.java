package com.idas2.zdravotnisystem.validator.procedura.typ;

import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.form.procedura.typ.ProceduraTypCreateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class ProceduraTypCreateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProceduraTypCreateForm.class.isAssignableFrom(clazz)
            || TypProcedury.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull ProceduraTypCreateForm form = (ProceduraTypCreateForm) target;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny");

        if (Objects.isNull(form.getPopis()) || form.getPopis().isEmpty())
            errors.rejectValue("popis", "", "Popis nesmi byt prazdny");

    }
}
