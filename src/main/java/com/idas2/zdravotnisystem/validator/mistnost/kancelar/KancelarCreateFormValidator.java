package com.idas2.zdravotnisystem.validator.mistnost.kancelar;

import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarCreateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class KancelarCreateFormValidator implements Validator {

    private final KancelarRepository repository;

    @Autowired
    public KancelarCreateFormValidator(
        KancelarRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return KancelarCreateForm.class.isAssignableFrom(clazz)
            || KancelarView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull KancelarCreateForm form = (KancelarCreateForm) target;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny");

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny!");

        if (Objects.isNull(form.getCislo()))
            errors.rejectValue("cislo", "", "Cislo nesmi byt prazdne!");

        if (Objects.nonNull(repository.findByCislo(form.getCislo())))
            errors.rejectValue("cislo", "", "Zadane cislo kancelare jiz se pouziva!");

        try {
            Integer.parseInt(form.getPlocha());

            if (Objects.isNull(form.getPlocha()) ||
                Integer.parseInt(form.getPlocha()) <= 0 ||
                form.getPlocha().isEmpty()
            ) errors.rejectValue(
                "plocha",
                "",
                "Plocha nesmi byt prazdna anebo mensi nez 1!"
            );

        } catch (NumberFormatException ex) {
            errors.rejectValue("plocha", "", "Nespravny format!");
        }
    }
}
