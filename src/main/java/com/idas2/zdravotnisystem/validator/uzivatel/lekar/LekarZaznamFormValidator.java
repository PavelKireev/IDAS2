package com.idas2.zdravotnisystem.validator.uzivatel.lekar;

import com.idas2.zdravotnisystem.db.view.ZaznamView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarZaznamForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class LekarZaznamFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LekarZaznamForm.class.isAssignableFrom(clazz)
            || ZaznamView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull LekarZaznamForm form = (LekarZaznamForm) target;

        if (Objects.isNull(form.getTitul()) || form.getTitul().isEmpty())
            errors.rejectValue("titul", "", "Titul nesmi byt prazdny!");

        if (Objects.isNull(form.getText()) || form.getText().isEmpty())
            errors.rejectValue("text", "", "Text nesmi byt prazdny!");
    }
}
