package com.idas2.zdravotnisystem.validator.uzivatel.lekar;

import com.idas2.zdravotnisystem.db.view.AdministratorView;
import com.idas2.zdravotnisystem.db.view.LekarView;
import com.idas2.zdravotnisystem.form.uzivatel.admin.AdminCreateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarCreateForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;
import java.util.regex.Pattern;

@Component
public class LekarCreateFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LekarCreateForm.class.isAssignableFrom(clazz)
            || LekarView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LekarCreateForm form = (LekarCreateForm) target;

        if(Objects.nonNull(form.getHeslo()) &&
            form.getHeslo().length() < 8
        ) errors.rejectValue("heslo", "", "Heslo nesmi byt kratsi nez 8 znaku");

        if(Objects.nonNull(form.getHeslo()) &&
            Objects.nonNull(form.getHesloPotvrzeni()) &&
            !form.getHeslo().equals(form.getHesloPotvrzeni())
        ) errors.rejectValue("hesloPotvrzeni", "","Heslo a Heslo Potvrzeni museji byt stejne!");

        if(Objects.nonNull(form.getEmail()) && (
            !Pattern
                .compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
                .matcher(form.getEmail()).matches() || form.getEmail().isEmpty())
        ) errors.rejectValue("email", "", "Nespravny format!");

        if(Objects.nonNull(form.getJmeno()) && form.getJmeno().isEmpty())
            errors.rejectValue("jmeno", "", "Jmeno nesmi byt prazdne!");

        if(Objects.nonNull(form.getPrijmeni()) && form.getPrijmeni().isEmpty())
            errors.rejectValue("prijmeni", "", "Prijmeni nesmi byt prazdne!");

        if(Objects.nonNull(form.getTelCislo()) && form.getTelCislo().isEmpty())
            errors.rejectValue("telCislo", "", "Telefonni cislo nesmi byt prazdne!");

        if(Objects.nonNull(form.getPlat()) && form.getPlat() < 16200)
            errors.rejectValue("plat", "", "Plat nesmi byt mensi nez minimalni mzda!");
    }
}
