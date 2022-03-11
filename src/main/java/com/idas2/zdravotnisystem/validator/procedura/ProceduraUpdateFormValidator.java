package com.idas2.zdravotnisystem.validator.procedura;

import com.idas2.zdravotnisystem.db.view.ProceduraView;
import com.idas2.zdravotnisystem.form.procedura.ProceduraCreateForm;
import com.idas2.zdravotnisystem.form.procedura.ProceduraUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class ProceduraUpdateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProceduraUpdateForm.class.isAssignableFrom(clazz)
            || ProceduraView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull ProceduraUpdateForm form = (ProceduraUpdateForm) target;

        if (Objects.isNull(form.getPopis()) || form.getPopis().isEmpty())
            errors.rejectValue("popis", "", "Popis nesmi byt prazdny");

        if (Objects.isNull(form.getDatum()) || form.getDatum().isEmpty())
            errors.rejectValue("datum", "", "Datum nesmi byt prazdny");
    }
}
