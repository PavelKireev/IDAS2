package com.idas2.zdravotnisystem.validator.uzivatel.lekar;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarPojisteniForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.util.Objects;

@Component
public class LekarPojisteniFormValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return LekarPojisteniForm.class.isAssignableFrom(clazz)
            || Pojisteni.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull LekarPojisteniForm form = (LekarPojisteniForm) target;

        if (Objects.isNull(form.getCisloKarty()) || form.getCisloKarty().isEmpty())
            errors.rejectValue("cisloKarty", "", "Cislo karty nesmi byt prazdne!");

        if (Objects.isNull(form.getCisloSmlouvy()) || form.getCisloSmlouvy().isEmpty())
            errors.rejectValue("cisloKarty", "", "Cislo smlouvy nesmi byt prazdne!");

        if (Objects.isNull(form.getPojistnaCastka()) || form.getPojistnaCastka() < 10000)
            errors.rejectValue("pojistnaCastka", "", "Pojistna castka nesmi byt mensi nez 10 000!");

        if (Objects.isNull(form.getPojisteniOd()) || form.getPojisteniOd().isEmpty())
            errors.rejectValue("pojisteniOd", "", "Datum od nesmi byt prazdny");

        if (Objects.isNull(form.getPojisteniDo()) ||
            form.getPojisteniDo().isEmpty() ||
            Date.valueOf(form.getPojisteniDo()).before(Date.valueOf(form.getPojisteniOd())))
            errors.rejectValue("pojisteniDo", "", "Datum do nesmi byt pozdeji nez datum od");
    }
}
