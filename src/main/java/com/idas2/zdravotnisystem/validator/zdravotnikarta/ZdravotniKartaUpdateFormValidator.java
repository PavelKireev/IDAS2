package com.idas2.zdravotnisystem.validator.zdravotnikarta;

import com.idas2.zdravotnisystem.db.entity.ZdravotniKarta;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarKartaUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ZdravotniKartaUpdateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LekarKartaUpdateForm.class.isAssignableFrom(clazz)
            || ZdravotniKarta.class.isAssignableFrom(clazz);    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull LekarKartaUpdateForm form = (LekarKartaUpdateForm) target;


    }
}
