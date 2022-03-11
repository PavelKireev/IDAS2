package com.idas2.zdravotnisystem.validator.mistnost.ordinace;

import com.idas2.zdravotnisystem.db.repository.OrdinaceRepository;
import com.idas2.zdravotnisystem.db.view.OrdinaceView;
import com.idas2.zdravotnisystem.form.mistnost.ordinace.OrdinaceUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class OrdinaceUpdateFormValidator implements Validator {

    private final OrdinaceRepository ordinaceRepository;

    @Autowired
    public OrdinaceUpdateFormValidator(
        OrdinaceRepository ordinaceRepository
    ) {
        this.ordinaceRepository = ordinaceRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return OrdinaceUpdateForm.class.isAssignableFrom(clazz)
            || OrdinaceView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        @NotNull OrdinaceUpdateForm form = (OrdinaceUpdateForm) target;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny");

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny!");

        if (Objects.isNull(form.getCislo()))
            errors.rejectValue("cislo", "", "Cislo nesmi byt prazdne!");

        if (Objects.nonNull(ordinaceRepository.findByCislo(form.getCislo())))
            errors.rejectValue("cislo", "", "Zadane cislo ordinace jiz se pouziva!");

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
